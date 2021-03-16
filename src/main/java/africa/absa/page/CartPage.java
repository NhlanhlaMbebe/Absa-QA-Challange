package africa.absa.page;

import africa.absa.utilities.Utilities;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.logging.Logger;

public class CartPage {

    public static final Logger log4j = Logger.getLogger(CartPage.class.getName());

    private final WebDriver driver;

    @FindBy(xpath = "//*[@fill='currentColor']")
    WebElement addToCutButton;

    @FindBy(xpath = "//*[text()='CHECKOUT']")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        log4j.info("================== Initial go to cart page ================");
        Utilities.extentTest.info("Cart home screen ", MediaEntityBuilder.createScreenCaptureFromPath( Utilities.getScreenShot(this.driver)).build());
    }

    public void clickOnAddCutButton() {
        this.addToCutButton.click();
        log4j.info("Cliking on the add to cut button : " + addToCutButton.toString());
    }

    public void clickOnTheCheckoutButton() throws IOException {
        Utilities.extentTest.info("Continuing with the order ", MediaEntityBuilder.createScreenCaptureFromPath( Utilities.getScreenShot(this.driver)).build());
        this.checkoutButton.click();
        log4j.info("Cliking on the check out button : " + checkoutButton.toString());
    }
}
