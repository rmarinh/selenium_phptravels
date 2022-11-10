package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage{
    WebDriverWait wait;
    WebDriver driver;

    @FindBy(css = ".form-group input[name='email']")
    WebElement emailInput;

    @FindBy(css = ".form-group input[name='password']")
    WebElement passwordInput;

    @FindBy(css = ".container button[type='submit']")
    WebElement loginButton;

    @FindBy(css = "label[for='rememberchb']")
    WebElement rememberMeCheckBox;

    //@FindBy(css = ".custom-checkbox.mb-0:nth-child(2) label")
    @FindBy(xpath= "//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/form/div[2]/div[2]/div[2]/label")
    WebElement resetPassword;

    @FindBy(css = ".input-group .form-control")
    WebElement resetPasswordEmailInput;

    @FindBy(css = ".btn.btn-primary.ladda.effect.ladda-button.waves-effect")
    WebElement resetButton;

    @FindBy(css = "#modal")
    WebElement resetPasswordLabel;

    public LoginPage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,30);

    }

    public void enterEmail(String text){
        emailInput.sendKeys(text);
    }

    public void enterPassword(String text){
        passwordInput.sendKeys(text);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void tickRememberMe(){rememberMeCheckBox.click();}

    public void resetPassword(){resetPassword.click();}

    public void enterResetPasswordEmail(String email ){
        resetPasswordEmailInput.sendKeys(email);
    }
    public void clickResetButton(){
            resetButton.click();
    }

    public void fillPage(String email, String passsword, boolean rememberMe){
        enterEmail(email);
        enterPassword(passsword);
        if(rememberMe)
            tickRememberMe();
    }


    public void resetPassword(String email){
        resetPassword.click();
        wait.until(ExpectedConditions.textToBePresentInElement(resetPasswordLabel,"Reset Password"));

        enterResetPasswordEmail(email);
        clickResetButton();
    }

}
