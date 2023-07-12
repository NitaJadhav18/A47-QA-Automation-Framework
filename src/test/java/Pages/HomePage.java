package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = ".playlist.playlist:nth-child(3)")
    private WebElement playlistElement;
    @FindBy(css="[name='name']")
    private WebElement newPlaylistInputField;

    //For Rename Playlist Methods
    public void doubleClickToPlaylist(){

        doubleClick(playlistElement);
    }
    public void enterNewPlaylistName(String playlistName){
        newPlaylistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        newPlaylistInputField.sendKeys(playlistName);
        newPlaylistInputField.sendKeys(Keys.ENTER);
    }
    public boolean playlistExist(String PlaylistName){
        By newPlaylist = By.xpath("//a[text()='"+ PlaylistName + "']");
        return findElement(newPlaylist).isDisplayed();
    }

}
