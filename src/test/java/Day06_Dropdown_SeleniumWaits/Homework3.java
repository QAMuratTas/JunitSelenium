package Day06_Dropdown_SeleniumWaits;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
/* Bu test çalışmıyor gündüz bakıver....*/
public class Homework3 {
//    Go to URL: https://opensource-demo.orangehrmlive.com/
//    Login with Username: Admin
//    Login with Password: admin123
//    Click login button
//    Click on PIM
//    Click on Employee List
//    Employee Name -> Use Faker Class
//    ID -> Use Faker Class
//    Employment Status -> select by index: 2
//    Include -> selectByVisibleText: Current and Past Employees
//    Supervisor Name -> Use Faker Class
//    Job Title ->selectByValue: IT Manager
//    Sub Unit ->selectByValue: 3
//    Click search button
//    Verify text visible : "No Records Found"

    WebDriver driver;
    Faker faker = new Faker();
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://opensource-demo.orangehrmlive.com/");

    }
    @After
    public void tearDown() {
        //driver.quit();
    }
    @Test
    public void login(){

        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement userNameBox = driver.findElement(By.name("username"));
        userNameBox.sendKeys("Admin");
        WebElement passwordBox = driver.findElement(By.cssSelector("[name='password']"));
        passwordBox.sendKeys("admin123");
        WebElement loginBox = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBox.click();
        WebElement pimButton = driver.findElement(By.xpath("//li[@class='oxd-main-menu-item-wrapper'][2]"));
        pimButton.click();
        WebElement employeeListButton = driver.findElement(By.xpath("//a[@class='oxd-topbar-body-nav-tab-item' and text()='Employee List']"));
        employeeListButton.click();
        List<WebElement> infoButtons = driver.findElements(By.cssSelector(".oxd-grid-item.oxd-grid-item--gutters"));
        infoButtons.get(0).sendKeys(faker.name().name());
        infoButtons.get(1).sendKeys(faker.idNumber().valid());
        infoButtons.get(2).sendKeys(Keys.ARROW_DOWN);
        infoButtons.get(3).sendKeys(Keys.ARROW_DOWN);
        infoButtons.get(4).sendKeys(faker.name().firstName());
        infoButtons.get(5).sendKeys(Keys.ARROW_DOWN);
        infoButtons.get(6).sendKeys(Keys.ARROW_DOWN);
        WebElement noRecordText = driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]"));
        Assert.assertTrue(noRecordText.isDisplayed());



    }


}
