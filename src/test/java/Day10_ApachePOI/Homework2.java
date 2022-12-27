package Day10_ApachePOI;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.io.File;

public class Homework2 extends BaseTest {

    // Go to https://the-internet.herokuapp.com/download
    //  Download sample.png file
    //  Then verify if the file downloaded successfully


    @Test
    public void fileDownloadTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/download");
        WebElement download = driver.findElement(By.linkText("sample.png"));
        download.click();
        Thread.sleep(5000);
        String homePath = System.getProperty("user.home");
        String filePath = "\\Downloads\\sample.png";
        String fullPath =homePath+filePath;
        File image =new File(fullPath);
        Assert.assertTrue(image.exists());
    }
}
