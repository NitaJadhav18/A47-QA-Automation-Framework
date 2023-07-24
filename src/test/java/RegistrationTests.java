import Pages.LoginPage;
import Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest
{
  @Test
    public void registerWithValidEmail()  {
      LoginPage loginPage = new LoginPage(getDriver());
      RegistrationPage registrationPage = new RegistrationPage(getDriver());
      loginPage.clickRegistrationLink();
      registrationPage.enterEmail("N5@gmail.com");
      registrationPage.clickRegistrationBtn();
      //check Registration Successful message
    Assert.assertTrue(registrationPage.getNotificationMessage());
    }
}
