package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "section.songs>h1>button")
    private WebElement viewAllBtn;
    @FindBy(css = "#songResultsWrapper tr.song-item td.title")
    private WebElement firstSongSelect;
    @FindBy(css = ".btn-add-to")
    private WebElement addToBtn;
    @FindBy(xpath = "//section[@id='songResultsWrapper']//li[contains(text( ),'My Songs')]")
    private WebElement playlistBtn;
    @FindBy(css = "div.success.show")
    private WebElement notificationMessage;
    @FindBy(xpath = "//span[contains(text(),'Ketsa')]")
    private WebElement songTitle;

    public void viewAllSongs() {
        viewAllBtn.click();
    }

    public void selectSong() {
        firstSongSelect.click();
    }

    public void clickAddToButton() {
         addToBtn.click();
    }

    public void addInToPlaylist() {
        //  WebElement playlistButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text( ),'My Playlist')]"));
     //   WebElement  playlistButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//li[contains(text( ),'My Playlist')]")));
        playlistBtn.click();
    }

    public String getNotificationText() {
        return notificationMessage.getText();
    }

    public String getSongTitle() {
        return songTitle.getText();
    }
}

