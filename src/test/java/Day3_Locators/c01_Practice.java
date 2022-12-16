package Day3_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class c01_Practice {
     //    Go to https://www.linkedin.com/
     //    When we write an e-mail without the @ sign in the e-mail box and press enter.
     //    Let's test the "Invalid email address" warning.

WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
}
@After
    public void teardown(){
       // driver.quit();

}
    @Test
    public void xpathPracitce(){
        driver.get("https://www.linkedin.com/");
        //WebElement control =driver.findElement(By.xpath("//*[@id=\"session_key\"]"));
        driver.findElement(By.xpath("//*[@id=\"session_key\"]")).sendKeys("etsiz bir text"+ Keys.ENTER);
//control.sendKeys("etsiz bir text");
//control.submit();

    }


}
