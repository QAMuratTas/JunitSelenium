package Day06_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }
    @After
    public void tearDown() {
        //driver.quit();
    }
    @Test
    public void login(){
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();



    }


}
