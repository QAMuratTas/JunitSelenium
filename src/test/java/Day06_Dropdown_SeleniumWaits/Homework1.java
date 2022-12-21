package Day06_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework1 {
    //Go to URL: https://demoqa.com/radio-button
    //Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.
    //Her bir seçenek seçildiğinde aşağıda çıkan text’leri konsolda yazdırınız.

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");

    }

    @Test
    public void yesButtontest() {
        driver.findElement(By.xpath("//label[@for='yesRadio']")).click();

        System.out.println("Yes button text :" + driver.findElement(By.xpath("//p[@class='mt-3']")).getText());
    }

    @Test
    public void impressiveButtontest() {
        driver.findElement(By.xpath("//label[@for='impressiveRadio']")).click();
        System.out.println("İmpressive button text :" + driver.findElement(By.xpath("//p[@class='mt-3']")).getText());
    }

    @Test
    public void noButtontest() {
        WebElement noButtons = driver.findElement(By.xpath("//label[@for='noRadio']"));
        noButtons.click();
        System.out.println(noButtons.isSelected() ? "No buttons selected" : "No buttons nonselected");

        System.out.println("No button text :" + driver.findElement(By.xpath("//p[@class='mt-3']")).getText());
    }

}
