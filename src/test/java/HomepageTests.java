import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomepageTests extends BaseTest{
    @Test
    public void playSong(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
        //click playnext song button
        homePage.clickPlaynextSong();
        homePage.clickPlayButton();
        Assert.assertTrue(homePage.checkSongPlaying());
    }
}
