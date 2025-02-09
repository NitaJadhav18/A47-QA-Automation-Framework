package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "[type='email']")
    private WebElement emailField;
    @FindBy(css = "[type='password']" )
    private WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    private WebElement submitBtn;

    //Login Helper Methods
    public LoginPage enterEmail(String email){
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage enterPassword(String password){
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit(){
        submitBtn.click();
        return this;
    }

}
