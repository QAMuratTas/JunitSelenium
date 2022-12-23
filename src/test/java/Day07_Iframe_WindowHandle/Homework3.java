package Day07_Iframe_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.BaseTest;
import java.util.Iterator;
import java.util.Set;

public class Homework3 extends BaseTest {
//    Go to URL: https://demoqa.com/browser-windows
//    Click on the windows - "WindowButton"
//    Click on all the child windows.
//    Print the text present on all the child windows in the console.
//    Print the heading of the parent window in the console.

    @Test
    public void test(){
        driver.get("https://demoqa.com/browser-windows");
String homePage=driver.getWindowHandle();
        driver.findElement(By.id("tabButton")).click();
        driver.findElement(By.xpath("//button[@id='windowButton']")).click();
        Set<String> w = driver.getWindowHandles();
        Iterator<String> i = w.iterator();
        while (i.hasNext()){
            driver.switchTo().window(i.next());
            if(driver.getWindowHandle().equals(homePage)){
                continue;
            }
            System.out.println("Child Window = " + driver.findElement(By.id("sampleHeading")).getText());
        }
driver.switchTo().window(homePage);
        System.out.println("HomePage Title= " + driver.getTitle());
    }
}
