import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;




public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static String url;

    @BeforeSuite
    static void setupClass() {
                WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    public void launchBrowser(String baseURL){
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url=baseURL;
        driver.get(url);
        wait = new WebDriverWait(driver,Duration.ofSeconds(4));
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
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

    protected String getNotificationText() throws InterruptedException {
       // WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        WebElement  notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationElement.getText();
    }

    protected void clickAddToButton() throws InterruptedException {
        //click addto
      //  WebElement addToButton = driver.findElement(By.cssSelector(".btn-add-to"));
        WebElement  addToButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-add-to")));
        addToButton.click();
        //add into playlist
         }

    protected void selectSong() throws InterruptedException {
        //select first song
       // WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper tr.song-item td.title"));
        WebElement  firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songResultsWrapper tr.song-item td.title")));
        firstSong.click();
    }

    protected void addInToPlaylist() throws InterruptedException {
      //  WebElement playlistButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text( ),'My Playlist')]"));
        WebElement  playlistButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//li[contains(text( ),'My Playlist')]")));
        playlistButton.click();
    }

    protected void viewAllSongs() throws InterruptedException {
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

    protected void clickPlayButton() throws InterruptedException {
     //   WebElement playButtonElement= driver.findElement(By.cssSelector("[title='Play or resume']"));
        WebElement  playButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Play or resume']")));
        playButtonElement.click();
    }

    protected void clickPlaynextSong() throws InterruptedException {
       // WebElement playnextSongElement = driver.findElement(By.cssSelector("[title='Play next song']"));
        WebElement  playnextSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Play next song']")));
        playnextSongElement.click();
    }

    protected boolean checkSongPlaying() {
      //  WebElement pauseButtonElement= driver.findElement(By.cssSelector("[title='Pause']"));
        WebElement  pauseButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Pause']")));
        return pauseButtonElement.isDisplayed();
    }

    protected String deletePlaylistMessage() throws InterruptedException {
      //  WebElement notificationMessageElement = driver.findElement(By.cssSelector("div.success.show"));
        WebElement  notificationMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMessageElement.getText();
        }

    protected void clickDeletePlaylist() throws InterruptedException {
        // WebElement deletePlaylistButtonElement = driver.findElement(By.cssSelector("button.del.btn-delete-playlist"));
        WebElement  deletePlaylistButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.del.btn-delete-playlist")));
        deletePlaylistButtonElement.click();
    }

    protected void selectPlaylist() throws InterruptedException {
       // WebElement existingPlaylist = driver.findElement(By.xpath("//li[@class='playlist playlist']//a[contains(text(),'Test')]"));
        WebElement  existingPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='playlist playlist']//a[contains(text(),'Test')]")));
        existingPlaylist.click();
    }
}