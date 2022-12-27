package Day10_ApachePOI;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class Homework1 extends BaseTest {

//    Go to URL: https://www.monsterindia.com/seeker/registration
//    Upload file.


    @Test
    public void fileUpload() {

        driver.get("https://www.monsterindia.com/seeker/registration");

        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        dosyaSec.sendKeys("C:\\Users\\MURAT\\Desktop\\resume.txt");

        WebElement dosyaKontrol =driver.findElement(By.id("registrationDetails"));

        Assert.assertEquals("resume.txt",dosyaKontrol.getText());
    }
}
