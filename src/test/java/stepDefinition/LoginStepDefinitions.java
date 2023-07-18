package stepDefinition;

import Pages.HomePage;
import Pages.LoginPage;
import com.beust.ah.A;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinitions {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public static String url = null;

    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url ="https://qa.koel.app/";
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }

    @Given("I open Login Page")
    public void openLoginPage(){
        driver.get(url);
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword(password);
    }

    @And("I click submit")
    public void iClickSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmit();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isAvatarDisplayed());
    }

    @Then("I am not logged in")
    public void iAmNotLoggedIn() {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
