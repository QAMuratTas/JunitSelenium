package Day04_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework2 {
    //https://id.heroku.com/login sayfasına gidiniz.
    //Bir mail adresi giriniz.
    //Bir password giriniz.
    //Login butonuna tıklayınız.
    //"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
    //Eğer yazı görünür değilse "Kayıt Yapıldı" yazdırınız.
    //Tüm sayfaları kapatınız.
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test(){
        driver.get("https://id.heroku.com/login");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("lorem@impus.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("loremlorem");
        WebElement login = driver.findElement(By.xpath("//*[@id=\"login\"]/form/button"));
        login.click();
        WebElement text = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[1]"));
        text.getText();
        if (text.getText().equals("There was a problem with your login.")){
            System.out.println("Kayıt Yapılamadı");

        }else System.out.println("Kayıt Yapıldı");



    }

}
