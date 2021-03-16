package africa.absa.page;

import africa.absa.utilities.Utilities;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.logging.Logger;

public class LoginPage {

    public static final Logger log4j = Logger.getLogger(LoginPage.class.getName());

    private WebDriver driver;

    @FindBy(how = How.XPATH, xpath = "//*[@id='user-name']")
    WebElement userName;

    @FindBy(xpath = "//*[@id='password']")
    WebElement password;

    @FindBy(xpath = "//*[@id='login-button']")
    WebElement login;

    public LoginPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        log4j.info("=============== Login page screen ================");
    }

    public void login(String userName, String password) throws IOException {
        this.userName.clear();
        this.userName.sendKeys(userName);
        log4j.info("Entered username : " + userName + " on text box : " +  this.userName.toString());

        this.password.clear();
        this.password.sendKeys(password);
        log4j.info("Entered password : " + password + " on text box : " +  this.password.toString());

        Utilities.extentTest.info("Login screen", MediaEntityBuilder.createScreenCaptureFromPath( Utilities.getScreenShot(this.driver)).build());
        login.click();
        log4j.info("Clicking on the login button " + login.toString());
    }
}
