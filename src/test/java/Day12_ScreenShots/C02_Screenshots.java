package Day12_ScreenShots;

import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import utilities.BaseTest;

import java.io.File;
import java.io.IOException;

public class C02_Screenshots extends BaseTest {

    @Test
    public void getPageScreenshot() throws IOException {
        driver.get("https://www.n11.com/");

        File kaynak =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(kaynak,new File("test-output/Screenshots/n11Screenshot.png"));




    }
    @Test
    public void getElementScreenshot(){


    }

}
