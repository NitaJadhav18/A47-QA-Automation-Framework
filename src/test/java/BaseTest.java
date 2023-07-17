import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;


public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public static String url;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();

    @BeforeSuite
   static void setupClass() {
//                WebDriverManager.chromedriver().setup();
    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps= new DesiredCapabilities();
        String gridURL = "http://192.168.1.253:4444";

        switch(browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();

            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);

            case "grid-edge":
                caps.setCapability("browserName","MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "grid-firefox":
                caps.setCapability("browserName","firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "grid-chrome":
                caps.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "cloud":
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }
    @BeforeMethod
    @Parameters({"baseURL"})
    public void launchBrowser(String baseURL) throws MalformedURLException {
        //driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url=baseURL;
        getDriver().get(url);
        wait = new WebDriverWait(getDriver(),Duration.ofSeconds(4));
        actions =new Actions(getDriver());
    }
    public static WebDriver getDriver(){
        return threadDriver.get();
    }
    @AfterMethod
      public void tearDown(){
        threadDriver.get().quit();
        threadDriver.remove();
    }
    public static WebDriver lambdaTest() throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("114.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "nita.jadhav");
        ltOptions.put("accessKey", "RvyOZvpNoM4MmuOFq6fiU7BhuYmEQn4vdlKHQIW4O22B8j1YEt");
        ltOptions.put("project", "Untitled");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-java");
        browserOptions.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URL(hubURL),browserOptions);
    }

   // Helper method
    //protected void openLoginUrl() {
//        driver.get(url);
//    }

    protected void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        emailField.sendKeys(email);
    }

    protected void enterPassword(String password) {
        WebElement passwordField= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
        passwordField.sendKeys(password);
    }

    protected void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submitButton.click();
    }

    protected String getNotificationText() {
       // WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        WebElement  notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationElement.getText();
    }

    protected void clickAddToButton(){
        //click addto
      //  WebElement addToButton = driver.findElement(By.cssSelector(".btn-add-to"));
        WebElement  addToButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-add-to")));
        addToButton.click();
        //add into playlist
         }

    protected void selectSong()  {
        //select first song
       // WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper tr.song-item td.title"));
        WebElement  firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songResultsWrapper tr.song-item td.title")));
        firstSong.click();
    }

    protected void addInToPlaylist()  {
      //  WebElement playlistButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text( ),'My Playlist')]"));
        WebElement  playlistButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//li[contains(text( ),'My Playlist')]")));
        playlistButton.click();
    }

    protected void viewAllSongs()  {
      //  WebElement viewAllField = driver.findElement(By.cssSelector("section.songs>h1>button"));
        WebElement  viewAllField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.songs>h1>button")));
        viewAllField.click();
    }

    protected void searchSong(String song) {
        //WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        WebElement  searchField  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(song);
    }

    protected void clickPlayButton()  {
     //   WebElement playButtonElement= driver.findElement(By.cssSelector("[title='Play or resume']"));
        WebElement  playButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Play or resume']")));
        playButtonElement.click();
    }

    protected void clickPlaynextSong()  {
       // WebElement playnextSongElement = driver.findElement(By.cssSelector("[title='Play next song']"));
        WebElement  playnextSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Play next song']")));
        playnextSongElement.click();
    }

    protected boolean checkSongPlaying() {
      //  WebElement pauseButtonElement= driver.findElement(By.cssSelector("[title='Pause']"));
        WebElement  pauseButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Pause']")));
        return pauseButtonElement.isDisplayed();
    }

    protected String deletePlaylistMessage()  {
      //  WebElement notificationMessageElement = driver.findElement(By.cssSelector("div.success.show"));
        WebElement  notificationMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMessageElement.getText();
        }

    protected void clickDeletePlaylist()  {
        // WebElement deletePlaylistButtonElement = driver.findElement(By.cssSelector("button.del.btn-delete-playlist"));
        WebElement  deletePlaylistButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.del.btn-delete-playlist")));
        deletePlaylistButtonElement.click();
    }

    protected void selectPlaylist()  {
       // WebElement existingPlaylist = driver.findElement(By.xpath("//li[@class='playlist playlist']//a[contains(text(),'Test')]"));
        WebElement  existingPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='playlist playlist']//a[contains(text(),'Test')]")));
        existingPlaylist.click();
    }

    protected void login() {
        enterEmail("nita.jadhav@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
    }
    //Rename Playlist Helper Methods

//    protected boolean playlistExist() {
//       WebElement existingPlaylistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+ newPlaylistName + "']")));
//       return existingPlaylistElement.isDisplayed();
//    }

    public void enterNewPlaylistName() {
       WebElement newPlaylistNameInputField = wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']"))));
       newPlaylistNameInputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
    //   newPlaylistNameInputField.sendKeys(newPlaylistName);
       newPlaylistNameInputField.sendKeys(Keys.ENTER);
    }

    public void doubleClickToPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist.playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }
}