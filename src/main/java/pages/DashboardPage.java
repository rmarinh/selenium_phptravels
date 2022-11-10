package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    WebDriverWait wait;
    WebDriver driver;

    @FindBy(css = ".author__meta")
    WebElement welcomeBackText;

    @FindBy(css = "h2 span")

    WebElement user;

    public DashboardPage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,30);

    }
    public boolean pageLoaded(String userName){
        wait.until(ExpectedConditions.textToBePresentInElement(welcomeBackText,"Welcome Back"));
        return welcomeBackText.getText().equals("Welcome Back")
                && user.getText().equals(userName);// isDisplayed();
    }


}
