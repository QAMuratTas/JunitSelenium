package Day07_Iframe_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Homework1 extends BaseTest {
//    Go to URL: http://demo.guru99.com/test/guru99home/
//    Find the number of iframes on the page.
//    Link to the fourth iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
//    Exit the iframe and return to the main page.

    @Override
    public void tearDown() {

    }

    @Test
    public void iframe() {
        String homePageId = driver.getWindowHandle();
        driver.get("http://demo.guru99.com/test/guru99home/");
        List<WebElement> l = driver.findElements(By.xpath("//iframe"));
        System.out.println("iframe size: " + l.size());
        driver.switchTo().frame("a077aa5e");
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();


        driver.switchTo().defaultContent();

        Set<String> w = driver.getWindowHandles();
        Iterator<String> i = w.iterator();
        while (i.hasNext()) {
            driver.switchTo().window(i.next());
            if (driver.getWindowHandle().equals(homePageId)) {
                continue;
            }
            driver.close();


        }


    }
}
