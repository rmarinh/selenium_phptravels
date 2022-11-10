import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashboardPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestLogin extends BaseTest{


    @Before
    @Override
    public void setup() throws IOException {
        super.setup();
        driver.get(testDataProps.getProperty("baseUrl") + "login");
    }
    @Test
    public void loggingWithValidData() throws InterruptedException {
        Assert.assertEquals("Login - PHPTRAVELS", driver.getTitle());
        loginPage.fillPage(
                testDataProps.getProperty("user3Login"),
                testDataProps.getProperty("user3Password"),
                false
        );
        loginPage.clickLoginButton();
        Assert.assertTrue(checkLoginSuccess(testDataProps.getProperty("user3Name")));
    }
    @Test
    public void loggingWithInvalidData() throws InterruptedException {
        Assert.assertEquals("Login - PHPTRAVELS", driver.getTitle());

        loginPage.clickLoginButton();
        Assert.assertEquals(testDataProps.getProperty("baseUrl") + "login", driver.getCurrentUrl());
        loginPage.fillPage(
                testDataProps.getProperty("user1Login"),
                testDataProps.getProperty("user1Password"),
                false
        );
        loginPage.clickLoginButton();
        Assert.assertEquals(testDataProps.getProperty("baseUrl") + "login/failed", driver.getCurrentUrl());

        Assert.assertEquals("Login - PHPTRAVELS", driver.getTitle());

    }

    @Test
    public void resetPasswordValidData() throws InterruptedException {
        Assert.assertEquals("Login - PHPTRAVELS", driver.getTitle());
        loginPage.resetPassword(testDataProps.getProperty("user2Login"));
        Assert.assertEquals(testDataProps.getProperty("baseUrl") + "login/reset/success", driver.getCurrentUrl());

    }
    @Test
    public void resetPasswordInvalidData() throws InterruptedException {
        Assert.assertEquals("Login - PHPTRAVELS", driver.getTitle());
        loginPage.resetPassword(testDataProps.getProperty("user1Login"));
        Assert.assertEquals(testDataProps.getProperty("baseUrl") + "login/reset/fail", driver.getCurrentUrl());

    }
    @Test
    public void resetPasswordInvalidData2() throws InterruptedException {
        Assert.assertEquals("Login - PHPTRAVELS", driver.getTitle());
        //Todo there is a bug in email verification here for invalid email
        loginPage.resetPassword("a");
        Assert.assertEquals(testDataProps.getProperty("baseUrl") + "login/reset/fail", driver.getCurrentUrl());

    }



    private boolean checkLoginSuccess (String userName)  {
        DashboardPage dashboardPage =  PageFactory.initElements(driver, DashboardPage.class);
        return dashboardPage.pageLoaded(userName) &&
        driver.getTitle().equals("Dashboard - PHPTRAVELS") &&
                driver.getCurrentUrl().equals(testDataProps.getProperty("baseUrl")+"account/dashboard");
    }

}
