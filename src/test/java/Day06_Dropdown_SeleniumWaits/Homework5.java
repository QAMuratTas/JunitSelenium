package Day06_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Homework5 {
//    Launch the browser.
//            Open "https://demoqa.com/select-menu".
//    Select the Standard Multi-Select using the element id.
//    Verifying that the element is multi-select.
//            Select 'Opel' using the index and deselect the same using index.
//            Select 'Saab' using value and deselect the same using value.
//    Deselect all the options.
//    Close the browser.

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After

    public void tearDown() {
        driver.quit();

    }

    @Test
    public void cars() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        Select s = new Select(driver.findElement(By.xpath("//select[@name='cars']")));
        Assert.assertTrue(s.isMultiple());
        s.selectByIndex(2);
        Thread.sleep(1700);
        s.deselectByIndex(2);
        s.selectByValue("saab");
        Thread.sleep(1700);
        s.deselectByValue("saab");
        s.deselectAll();


    }


}
