package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Collection;

public class PlaylistPage extends BasePage{
    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(xpath= "//li[@class='playlist playlist']//a[contains(text(),'Test')]")
    private WebElement existingPlaylist;
    @FindBy(css="button.del.btn-delete-playlist")
    private WebElement deletePlaylistButtonElement;
    @FindBy(css="div.success.show")
    private WebElement notificationMessageElement;
    @FindBy(css = ".playlist.playlist:nth-child(3)")
    private WebElement playlistElement;
    @FindBy(css="[name='name']")
    private WebElement newPlaylistInputField;
    public void selectPlaylist() {
        existingPlaylist.click();
    }
    public void doubleClickToPlaylist(){
        doubleClick(playlistElement);
    }
    public void clickDeletePlaylist() {
        deletePlaylistButtonElement.click();
    }
    public String deletePlaylistMessage() {
        return notificationMessageElement.getText();
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
