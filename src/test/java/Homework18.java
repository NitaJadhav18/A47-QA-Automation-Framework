import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException {
        //openLoginUrl();
        enterEmail("Nita.jadhav@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
        //click playnext song button
        clickPlaynextSong();
        clickPlayButton();
        Assert.assertTrue(checkSongPlaying());

    }

}
