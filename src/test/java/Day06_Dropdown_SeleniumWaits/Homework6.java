package Day06_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework6 {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After

    public void tearDown() {
        //    driver.quit();

    }
//    Go to URL: http://demo.automationtesting.in/Alerts.html
//    Click "Alert with OK" and click 'click the button to display an alert box:’+
//    Accept Alert(I am an alert box!) and print alert on console.
//    Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
//    Cancel Alert  (Press a Button !)
//    Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
//    And then sendKeys «BootcampCamp» (Please enter your name)
//    Finally print on console this message "Hello BootcampCamp How are you today" assertion these message.


    @Test
    public void alert() {
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
        driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();

        driver.switchTo().alert().sendKeys("BootCamp");
        driver.switchTo().alert().accept();

        System.out.println(driver.findElement(By.xpath("//*[@id=\"demo1\"]")).getText());
    }


}
