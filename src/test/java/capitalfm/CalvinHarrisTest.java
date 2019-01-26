package capitalfm;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CalvinHarrisTest {

    WebDriver Driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/waqasraza/Drivers/chromedriver");
        Driver = new ChromeDriver();
        Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        Driver.quit();
    }

    @Test
    public void calvinHarrisIsPlaying() {
        String artistNowPlaying = "";
        Driver.navigate().to("https://www.capitalfm.com/");
        Driver.navigate().refresh();
        artistNowPlaying = Driver.findElement(By.cssSelector(".now_playing_card div:nth-child(3)")).getText();
        assertThat("Calvin Harris is now playing", artistNowPlaying, is(equalTo("Calvin Harris")));
    }

    @Test
    public void calvinHarrisHasPlayed() {
        Driver.navigate().to("https://www.capitalfm.com/");
        Driver.navigate().refresh();
        List<WebElement> artistsRecentlyPlayed;
        artistsRecentlyPlayed = Driver.findElements(By.className("artist"));
        for (int i = 1; i < 4; i++) {
            if (artistsRecentlyPlayed.get(i).getText().equalsIgnoreCase("Calvin Harris")) {
                System.out.println("Calvin Harris has recently played");
                break;
            }
        }
        System.out.println("Calvin Harris has not recently played");
    }
}
