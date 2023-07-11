import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {
       String notificationMessage ="Deleted playlist ";
        login();
        selectPlaylist();
        clickDeletePlaylist();
        Assert.assertTrue(deletePlaylistMessage().contains(notificationMessage));

    }

}
