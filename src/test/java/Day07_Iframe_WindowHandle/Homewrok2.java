package Day07_Iframe_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.BaseTest;

public class Homewrok2 extends BaseTest {
//    Go to URL: https://testproject.io/
//    Selenium’s 4 newWindow() method to open a new Window for TestProject’s Blog page.
//            https://blog.testproject.io/

    @Test
    public void test(){

        driver.get("https://testproject.io/");
        driver.switchTo().newWindow(WindowType.WINDOW).get(" https://blog.testproject.io/");
    }


}
