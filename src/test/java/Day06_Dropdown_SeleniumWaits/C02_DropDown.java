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

public class C02_DropDown {


    WebDriver driver;

    @Before
    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After

    public void tearDown () {
        //driver.quit();

    }

    @Test
    public void selectByindex(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        //Dropdown locate edildi
        WebElement drpDown = driver.findElement(By.name("country"));

        //Locate edilen dropdown select objesine donusturuldu
        Select select = new Select(drpDown);

        select.selectByIndex(1); // ALGERIA

        //selectByIndex() metodu 0 ile baslar.


    }
    @Test
    public void selectByvalue(){

        driver.get("https://demo.guru99.com/test/newtours/register.php");

        //Dropdown locate edildi
        WebElement drpDown = driver.findElement(By.name("country"));

        //Locate edilen dropdown select objesine donusturuldu
        Select select = new Select(drpDown);

        select.selectByValue("TURKEY");



    }@Test
    public void selectByVisibleText(){

    }


}
