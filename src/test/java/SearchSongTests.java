import Pages.HomePage;
import Pages.LoginPage;
import Pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchSongTests extends BaseTest{
    @Test
    public void SearchSong() {
        String song= "Ketsa";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SearchPage searchPage = new SearchPage(getDriver());
        loginPage.login();  //login
        homePage.searchSong(song);  //Search a song
       // Assert.assertTrue(searchPage.getSongTitle().contains(song));

    }
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SearchPage searchPage = new SearchPage(getDriver());
        String notificationText = "Added 1 song into";
        //Enter Email
        loginPage.login();
        //Search a song
        homePage.searchSong("Ketsa");
        //View Songs
        searchPage.viewAllSongs();
        //select a song
        searchPage.selectSong();
        //click AddtoButton
        searchPage.clickAddToButton();
        //Add song into Playlist
        searchPage.addInToPlaylist();
        // Asserting Notification text message
        Assert.assertTrue(searchPage.getNotificationText().contains(notificationText));
    }
}
