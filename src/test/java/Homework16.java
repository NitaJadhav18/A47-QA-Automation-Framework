
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import java.time.Duration;
public class Homework16 extends BaseTest{
    @Test
    public void registrationNavigation() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        //click on Registration
        WebElement registrationField = driver.findElement(By.cssSelector("#hel"));
        registrationField.click();

        //Register button
        WebElement submitField = driver.findElement(By.cssSelector("#button"));

        //to check user is on Registration page or not
        Assert.assertTrue(submitField.isDisplayed());

        //close web browser
       driver.close();

    }
}



