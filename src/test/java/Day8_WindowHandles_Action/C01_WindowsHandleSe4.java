package Day8_WindowHandles_Action;

import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.BaseTest;

public class C01_WindowsHandleSe4 extends BaseTest {

    // https://testproject.io/

// https://blog.testproject.io/


    @Override
    public void tearDown() {

    }

    @Test
    public void newWindow(){
        driver.get("https://testproject.io/");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://blog.testproject.io/");
// dikkat driver objesi switchTo neredeyse onun için çalışıyor.... dikkat!!

    }





}
