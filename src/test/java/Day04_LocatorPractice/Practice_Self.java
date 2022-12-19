package Day04_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Practice_Self {


    WebDriver driver;

    @Before

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        button(100);
        buttonDelete(40);
    }

    public void button(int tiklaSayisi) {
        WebElement tikla = driver.findElement(By.cssSelector("#content > div > button"));
        for (int i = 0; i < tiklaSayisi; i++) {
            tikla.click();
        }
    }
    public void buttonDelete(int tiklaSayisi) {
        List<WebElement> tikla = driver.findElements(By.xpath("//*[@id=\"elements\"]/button"));
       int kontrol = tikla.size();

        for (int i = 0; i <tiklaSayisi ; i++) {
            tikla.get(i).click();
        }
        List<WebElement> kntrl=driver.findElements(By.xpath("//*[@id=\"elements\"]/button"));
        int kontrolson= kntrl.size();
        Assert.assertEquals(kontrol-tiklaSayisi,kontrolson);
        System.out.println("Beklenen Değer :"+(kontrol-tiklaSayisi)+" Gerçekleşen değer :"+kontrolson);
    }
}
