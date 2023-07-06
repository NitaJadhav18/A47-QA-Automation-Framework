import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.Thread;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String notificationText = "Added 1 song into";
        //Open LoginUrl
        openLoginUrl();
        //Enter Email
        enterEmail("nita.jadhav@testpro.io");
        //Enter Password
        enterPassword("te$t$tudent");
        //click Submit button
        clickSubmit();
        Thread.sleep(2000);
        //Search a song
        searchSong("Ketsa");
        //View Songs
        viewAllSongs();
        //select a song
        selectSong();
        //click AddtoButton
        clickAddToButton();
        //Add song into Playlist
        addInToPlaylist();
        // Asserting Notification text message
        Assert.assertTrue(getNotificationText().contains(notificationText));
    }


}
