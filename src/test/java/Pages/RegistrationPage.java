package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "#email")
    private WebElement emailInputField;
    @FindBy(css = "#button")
    private WebElement registrationBtn;
    @FindBy(xpath = "//body//h3[contains(text( ), 'Registration Successful')]")
    private WebElement notificationMessage;


    public void enterEmail(String email) {
        emailInputField.sendKeys(email);
    }

    public void clickRegistrationBtn() {
        registrationBtn.click();
    }

    public boolean getNotificationMessage() {
        return notificationMessage.isDisplayed();
    }
}
