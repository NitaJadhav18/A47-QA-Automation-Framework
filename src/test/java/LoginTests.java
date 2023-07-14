import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTests extends BaseTest {
    @Test
    public void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.enterEmail("nita.jadhav@testpro.io").enterPassword("te$t$tudent").clickSubmit();
        Assert.assertTrue(homePage.isAvatarDisplayed());
    }

    @Test
    public void LoginInvalidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterEmail("123@gmail.com").enterPassword("abcdef").clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test
    public void LoginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterEmail(" ").enterPassword(" ").clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
    @Test
    public void LoginEmptyEmailTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterEmail(" ").enterPassword("te$t$tudent").clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}
