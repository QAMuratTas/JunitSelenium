package Day06_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Homework2 {
//    - https://demoqa.com/select-menu sitesine gidin
//            - <select> elementini locate edin
//- <select> elementinin seceneklerini yazdirin
//- Sirasiyla selectByIndex, selectByValue, selectByVisibleText methodlarini kullanarak;
//    * Yellow (index)
//    * Purple (value)
//    * Black  (text)
//    seceneklerini secin
WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");

    }
    @After
    public void tearDown() {
        //driver.quit();
    }
    @Test
    public void selectPrint(){
       WebElement drpDown= driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(drpDown);
        List<WebElement> opt=select.getOptions();
        for(WebElement option : opt) {
            System.out.println(option.getText());
        }
    }
    @Test
    public void selectByIndex () {
        WebElement drpDown= driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(drpDown);
select.selectByIndex(3);
select.selectByValue("4");
select.selectByVisibleText("Black");
    }
}
