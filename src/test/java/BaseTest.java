import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;




public class BaseTest {
    public static WebDriver driver = null;
    public static String url="https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser(){
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    // Helper method
    protected void openLoginUrl() {
        driver.get(url);
    }

    protected void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys(email);
    }

    protected void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.sendKeys(password);
    }

    protected void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    protected String getNotificationText() throws InterruptedException {
        Thread.sleep(2000);
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();
    }

    protected void clickAddToButton() throws InterruptedException {
        //click addto
        WebElement addToButton = driver.findElement(By.cssSelector(".btn-add-to"));
        addToButton.click();
        //add into playlist
        Thread.sleep(2000);
    }

    protected void selectSong() throws InterruptedException {
        //select first song
        WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper tr.song-item td.title"));
        firstSong.click();
        Thread.sleep(2000);
        Thread.sleep(2000);
    }

    protected void addInToPlaylist() throws InterruptedException {
        WebElement playlistButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text( ),'My Playlist')]"));
        playlistButton.click();
        Thread.sleep(2000);
    }

    protected void viewAllSongs() throws InterruptedException {
        WebElement viewAllField = driver.findElement(By.cssSelector("section.songs>h1>button"));
        viewAllField.click();
        Thread.sleep(2000);
    }

    protected void searchSong(String song) {
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(song);
    }

    protected void clickPlayButton() throws InterruptedException {
        WebElement playButtonElement= driver.findElement(By.cssSelector("[title='Play or resume']"));
        playButtonElement.click();
        Thread.sleep(2000);
    }

    protected void clickPlaynextSong() throws InterruptedException {
        WebElement playnextSongElement = driver.findElement(By.cssSelector("[title='Play next song']"));
        playnextSongElement.click();
        Thread.sleep(2000);
    }

    protected boolean checkSongPlaying() {
        WebElement pauseButtonElement= driver.findElement(By.cssSelector("[title='Pause']"));
        return pauseButtonElement.isDisplayed();
    }
}