package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Homework1 extends BaseTest {
//    https://api.jquery.com/ sitesine gidelim
//    arama alanina json yazalim
//    Enter islemini robot class kullanrak yapalim


    @Override
    public void tearDown() {
    }

    @Test
    public void robotEnter() throws AWTException {
        driver.get("https://api.jquery.com/");
        driver.findElement(By.name("s")).sendKeys("json");
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
    }
}
