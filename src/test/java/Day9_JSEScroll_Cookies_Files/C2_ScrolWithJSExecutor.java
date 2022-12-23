package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C2_ScrolWithJSExecutor extends BaseTest{

//    go to url : https://api.jquery.com/dblclick/
//    double click on the blue square at the bottom of the page and then write the changed color.


    @Test
    public void doubleClick() {
        driver.get("https://api.jquery.com/dblclick/");
        driver.switchTo().frame(0);
        WebElement blueBox = driver.findElement(By.cssSelector("body>div"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",blueBox);

        System.out.println("Color before: "+blueBox.getCssValue("background-color"));
        Actions act =new Actions(driver);
        act.doubleClick(blueBox).perform();
        System.out.println("Color after :"+blueBox.getCssValue("background-color"));


    }
}
