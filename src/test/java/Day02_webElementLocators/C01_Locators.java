package Day02_webElementLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Locators {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void idLocator() {
        // id locator "session_key"
        WebElement email = driver.findElement(By.id("session_key"));
        email.sendKeys("Clarusway selenium dersinden selamlar...");
        driver.manage().window().maximize();
    }
     @Test
        public void nameLocator(){
            WebElement password = driver.findElement(By.name("session_password"));
            password.sendKeys("Sifre");

        };



}
