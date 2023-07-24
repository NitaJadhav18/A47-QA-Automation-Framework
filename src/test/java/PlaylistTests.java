import Pages.HomePage;
import Pages.LoginPage;
import Pages.PlaylistPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest{
    @Test
    public void deletePlaylist() {
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());
        String notificationMessage ="Deleted playlist ";
        loginPage.login();  //Login
        playlistPage.selectPlaylist();   //Select Playlist
        playlistPage.clickDeletePlaylist();  //click delete playlist
        Assert.assertTrue(playlistPage.deletePlaylistMessage().contains(notificationMessage)); //Check Notification message
    }

    @Test
    public void renamePlaylist() {
        LoginPage loginPage =new LoginPage(getDriver());
        PlaylistPage playlistPage =new PlaylistPage(getDriver());
        String newPlaylistName = "My Fav";
        loginPage.login();
        playlistPage.doubleClickToPlaylist(); //double click to playlist
        playlistPage.enterNewPlaylistName(newPlaylistName);  //Enter New PlaylistName
        //check playlist is rename or not
        Assert.assertTrue(playlistPage.playlistExist(newPlaylistName));
    }
}
