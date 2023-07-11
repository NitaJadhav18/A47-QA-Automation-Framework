package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    private By playlistElement = By.cssSelector(".playlist.playlist:nth-child(3)");
    private By newPlaylistInputField = By.cssSelector("[name='name']");


    //For Rename Playlist Methods
    public void doubleClickToPlaylist(){

        doubleClick(playlistElement);
    }
    public void enterNewPlaylistName(String playlistName){
        findElement(newPlaylistInputField).sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        findElement(newPlaylistInputField).sendKeys(playlistName);
        findElement(newPlaylistInputField).sendKeys(Keys.ENTER);
    }
    public boolean playlistExist(String PlaylistName){
        By newPlaylist = By.xpath("//a[text()='"+ PlaylistName + "']");
        return findElement(newPlaylist).isDisplayed();
    }

}
