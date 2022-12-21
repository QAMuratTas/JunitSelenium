package Day07_Iframe_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class C03_WindowsHandle extends BaseTest {


    @Override
    public void tearDown() {

    }

    //    Go to URL: https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/
    //    Print the existing windowHandles ids by clicking all the links on the page.
    //    Click on the links that open a new page.
    //    Close other pages other than the home page.
    //    Set the driver back to the main page.
@Test
    public void windowsHandle (){
    driver.get("https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/");
    String homePageID =driver.getWindowHandle();
    List<WebElement> links = driver.findElements(By.xpath("//a[@target='_blank']"));
    links.get(0).click();
    links.get(1).click();

    Set<String> windows =driver.getWindowHandles();
    Iterator<String> iterator = windows.iterator();

    while (iterator.hasNext()){
        driver.switchTo().window(iterator.next());
        if (driver.getWindowHandle().equals(homePageID)){

           continue;}
driver.close();


    }
}






}
