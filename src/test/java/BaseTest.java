import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.DashboardPage;
import pages.LoginPage;
import util.Util;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    WebDriver driver;
    String BASE_URL ="ze";
    LoginPage loginPage;
    DashboardPage dashboardPage;
    public static final Properties testDataProps=new Properties();
    public static final Properties testLocatorsProps=new Properties();
    @Before
    public void setup() throws IOException {
        //TestData
        FileReader reader=new FileReader("src/test/TestData.properties");
        testDataProps.load(reader);

        //Locators
        FileReader reader2=new FileReader("src/test/TestLocators.properties");
        testLocatorsProps.load(reader2);

        //OS LOAD
        String OS = Util.checkOS();
        switch (OS) {
            case "WINDOWS": System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            break;
            case "LINUX": System.setProperty("webdriver.chrome.driver", "chromedrivers");
            break;
            case "MAC": System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            break;
            default: System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        }

        BASE_URL = testDataProps.getProperty("baseUrl");

        driver = new ChromeDriver();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        driver.get(BASE_URL);
        driver.manage ().window ().maximize ();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
