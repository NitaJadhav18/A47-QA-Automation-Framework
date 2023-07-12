import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
   @Test
    public void renamePlaylist(){
       LoginPage loginPage =new LoginPage(driver);
       HomePage homePage = new HomePage(driver);
       String newPlaylistName = "My Songs";

       loginPage.enterEmail("nita.jadhav@testpro.io").enterPassword("te$t$tudent").clickSubmit();
       homePage.doubleClickToPlaylist();
       homePage.enterNewPlaylistName(newPlaylistName);

       //check playlist is rename or not
      Assert.assertTrue(homePage.playlistExist(newPlaylistName));
   }
}
