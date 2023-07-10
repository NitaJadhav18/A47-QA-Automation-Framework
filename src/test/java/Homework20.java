import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends  BaseTest{
    @Test
    public void refactorDeletePlaylist() {
        String notificationMessage ="Deleted playlist ";
        login();
        selectPlaylist();
        clickDeletePlaylist();
        Assert.assertTrue(deletePlaylistMessage().contains(notificationMessage));

    }

}
