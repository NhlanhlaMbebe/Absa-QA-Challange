package africa.absa.page;

import africa.absa.utilities.Utilities;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.logging.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckoutPage {

    public static final Logger log4j = Logger.getLogger(CheckoutPage.class.getName());

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='first-name']")
    WebElement firstName;

    @FindBy(xpath = "//*[@id='last-name']")
    WebElement lastName;

    @FindBy(xpath = "//*[@id='postal-code']")
    WebElement postalCode;

    @FindBy(xpath = "//*[@value='CONTINUE']")
    WebElement continueButton;

    @FindBy(xpath = "//*[text()='FINISH']")
    WebElement finishButton;

    @FindBy(xpath = "//*[@class='complete-header']")
    WebElement confirmationMessage;

    public CheckoutPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Utilities.extentTest.info("Checkout home page", MediaEntityBuilder.createScreenCaptureFromPath( Utilities.getScreenShot(this.driver)).build());
    }

    public void enterCheckoutInformation(String name, String surname, String postal) throws IOException {
        firstName.clear();
        firstName.sendKeys(name);
        log4j.info("Entering the name : " + name + " on the name text field " + firstName.toString());

        lastName.clear();
        lastName.sendKeys(surname);
        log4j.info("Entering the last name : " + surname + " on the name text field " + lastName.toString());

        postalCode.clear();
        postalCode.sendKeys(postal);
        log4j.info("Entering the postal code : " + postal + " on the name text field " + postalCode.toString());
        Utilities.extentTest.info("Adding shipping information", MediaEntityBuilder.createScreenCaptureFromPath( Utilities.getScreenShot(this.driver)).build());
    }

    public void clickOnContinueButton() {
        this.continueButton.click();
        log4j.info("Clicking on the continue " + this.continueButton.toString());
    }

    public void clickOnTheFinishButton() throws IOException {
        this.finishButton.click();
        log4j.info("Clicking on the finish button " + this.finishButton.toString());
        Utilities.extentTest.info("Completing order information", MediaEntityBuilder.createScreenCaptureFromPath( Utilities.getScreenShot(this.driver)).build());
    }

    public void confirmationMessage() {
        String message = "THANK YOU FOR YOUR ORDER";
        String actualMessage = confirmationMessage.getText();
        assertThat(actualMessage).isEqualToIgnoringCase(message);
        log4j.info("validating the confirmation message " + actualMessage);
    }
}
