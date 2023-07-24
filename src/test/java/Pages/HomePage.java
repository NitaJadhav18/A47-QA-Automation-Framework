package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }




    @FindBy(css ="[type='search']")
    private WebElement searchInputField;

    @FindBy(css ="[title='Play next song']")
    private WebElement playnextSongElement;
    @FindBy(css = "[title='Play or resume']")
    private WebElement playButtonElement;
    @FindBy(css = "[title='Pause']")
    private WebElement pauseButtonElement;

    public boolean isAvatarDisplayed() {
        By avatarIconElement = By.cssSelector(".profile .avatar");
        return findElement(avatarIconElement).isDisplayed();
    }
    public void searchSong(String song) {
        searchInputField.click();
        searchInputField.clear();
        searchInputField.sendKeys(song);
    }

    public void clickPlaynextSong() {
        playnextSongElement.click();
    }

    public void clickPlayButton() {
         playButtonElement.click();
    }

    public boolean checkSongPlaying() {
        return pauseButtonElement.isDisplayed();
    }
}
