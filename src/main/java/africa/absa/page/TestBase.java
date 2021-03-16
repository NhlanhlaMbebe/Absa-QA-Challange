package africa.absa.page;

import africa.absa.utilities.ExcelReader;
import africa.absa.utilities.Utilities;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.logging.Logger;

import static africa.absa.utilities.Utilities.createOutputFolder;

public class TestBase {

    public static final Logger log4j = Logger.getLogger(TestBase.class.getName());

    public static WebDriver driver;

    private ExcelReader excelReader;

    public static ExtentReports extent;

    public TestBase() {
        driver = null;
    }

    @BeforeClass
    public void before() throws Exception {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        log4j.info("Logging chrome browser");
        Utilities.folderName = createOutputFolder();
    }

    @AfterClass
    public void after() {
        if (driver != null) {
            driver.quit();
            log4j.info("================ Closing the browser session, test complete ========");
        }
    }

    protected String getSiteURL() {
        String URL = System.getProperty("testURL");
        if (URL == null)
            return "https://www.saucedemo.com/";
        else {
            return URL;
        }
    }

    public String[][] getData(String excelName, String sheetName) {
        String path = System.getProperty("user.dir") + "/src/main/resources/TestData/" + excelName;
        log4j.info("Opening URL path for excel" + System.getProperty("user.dir") + "/src/main/resources/TestData/" + excelName);
        //excelReader = new ExcelReader(path);
        //String[][] data = excelReader.getDataFromExcelSheet(sheetName);
        return null;
    }

    protected WebDriver getWebDriver() {
        return driver;
    }
}
