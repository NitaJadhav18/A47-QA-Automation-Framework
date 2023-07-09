import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {
       String notificationMessage ="Deleted playlist ";
        enterEmail("nita.jadhav@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
        selectPlaylist();
        clickDeletePlaylist();
        Assert.assertTrue(deletePlaylistMessage().contains(notificationMessage));

    }

}
