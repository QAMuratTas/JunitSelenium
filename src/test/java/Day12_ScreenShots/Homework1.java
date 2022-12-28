package Day12_ScreenShots;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Homework1 extends BaseTest {

//    Go to URL: https://opensource-demo.orangehrmlive.com/
//    Getting screenshot of  Orange HRM Page Section.
//    Save the screenshot with format 'screenshotname_yyyy_MM_dd_hh_mm_ss.png'
    @Test
    public void orangeHRM () throws IOException, InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(5000);
        File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
        FileUtils.copyFile(s,new File("test-output\\Screenshots\\orangeHRM_"+date+".png"));



    }



}
