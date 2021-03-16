package africa.absa.page;

import africa.absa.utilities.ExtentTestNGITestListener;
import africa.absa.utilities.Utilities;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.logging.Logger;

public class ProductPage {

    public static final Logger log4j = Logger.getLogger(ProductPage.class.getName());

    WebDriver driver;

    @FindBy(how = How.XPATH, xpath = "//button[text()='ADD TO CART']")
    WebElement addToCart;

    @FindBy(how = How.XPATH, xpath = "//button[text()='<- Back']")
    WebElement backButton;

    public ProductPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
        log4j.info("================ Initial product page =====================");
        Utilities.extentTest.info("Product page from screen", MediaEntityBuilder.createScreenCaptureFromPath( Utilities.getScreenShot(this.driver)).build());
    }

    public void addItemsToCart(String items) throws IOException {

        for (String item : items.split(",")) {
            driver.findElement(By.xpath("//*[contains(text(),'" + item + "')]")).click();
            log4j.info("Selecting item to buy : " + item);
            addToCart.click();
            Utilities.extentTest.info("Adding items on the cart", MediaEntityBuilder.createScreenCaptureFromPath( Utilities.getScreenShot(this.driver)).build());
            backButton.click();
            log4j.info("Clicking on the add to cart button " + addToCart.toString());
            log4j.info("Clicking on the back button " + backButton.toString());
        }
    }
}
