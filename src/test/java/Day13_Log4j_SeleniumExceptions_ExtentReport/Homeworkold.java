package Day13_Log4j_SeleniumExceptions_ExtentReport;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class Homeworkold extends BaseTest {

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

@Test
    public void test (){
    Faker faker = new Faker();
    driver.get("https://opensource-demo.orangehrmlive.com/");

    WebElement username =driver.findElement(By.name("username"));
    username.sendKeys("Admin");
    WebElement passsword = driver.findElement(By.name("password"));
    passsword.sendKeys("admin123"+Keys.ENTER);

    WebElement pim =driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[2]"));
    pim.click();
    WebElement employeeListButton = driver.findElement(By.xpath("//a[@class='oxd-topbar-body-nav-tab-item' and text()='Employee List']"));
    employeeListButton.click();

}
}
