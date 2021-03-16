package africa.absa.test;

import africa.absa.page.*;
import africa.absa.utilities.ExtentManger;
import africa.absa.utilities.Utilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.Logger;

public class ShoppingTest extends TestBase {

    public static final Logger log4j = Logger.getLogger(ShoppingTest.class.getName());
    private LoginPage login;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @Override
    @BeforeClass
    public void before() throws Exception {
        super.before();
        getWebDriver().get(getSiteURL());
    }

    @Test
    public void shoppingTest() throws InterruptedException, IOException {
        Utilities.extentTest = ExtentManger.getInstance().createTest("testName");
        login = new LoginPage(getWebDriver());
        login.login("standard_user", "secret_sauce");
        productPage = new ProductPage(getWebDriver());
        productPage.addItemsToCart("Sauce Labs Backpack,Sauce Labs Bike Light,Sauce Labs Bolt T-Shirt");
        cartPage = new CartPage(getWebDriver());
        cartPage.clickOnAddCutButton();
        cartPage.clickOnTheCheckoutButton();
        checkoutPage = new CheckoutPage(getWebDriver());
        checkoutPage.enterCheckoutInformation("Nhlanhla", "Mbebe", "1709");
        checkoutPage.clickOnContinueButton();
        checkoutPage.clickOnTheFinishButton();
        checkoutPage.confirmationMessage();
        Thread.sleep(2500L);
    }

    @Override
    @AfterClass
    public void after() {
        super.after();
        ExtentManger.getInstance().flush();
    }

}
