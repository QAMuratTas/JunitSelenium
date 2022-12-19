package Day05_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class C01_RelativeLocator {

    WebDriver driver;

    @Before
    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After

    public void tearDown () {
        driver.quit();

    }
    @Test
    public void test () {
        // Go to http://www.bestbuy.com
// Verify that the page title contains "Best" Also, using Relative Locator.
// LogoTest  Verify if the BestBuy logo is displayed.
// mexicoLinkTest  Verify if the link is displayed.

        driver.get("http://www.bestbuy.com");
        Assert.assertTrue("Title Best kelimesini içermiyor",driver.getTitle().contains("Best"));
        // logo locate edilip kontrol ediliyor
        By logoLocator = RelativeLocator.with(By.tagName("img")).above(By.xpath("//div[text()='Hello!']"));
        WebElement logo =driver.findElement(logoLocator);
        Assert.assertTrue(logo.isDisplayed());
        // Mexico link locate edilip kontrol ediliyor
        By mexicoLinkLocator =RelativeLocator.with(By.tagName("a")).toRightOf(By.xpath("//div[@lang='en']"+"//a[@class='us-link']"));
        WebElement mexicoLink =driver.findElement(mexicoLinkLocator);
        Assert.assertTrue(mexicoLink.isDisplayed());
    }

}
