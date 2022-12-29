package Day13_Log4j_SeleniumExceptions_ExtentReport;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTestReport;

public class Homework1 extends BaseTestReport {

//    Tasktaki her bir step icin lutfen log mesajlarini yazdirarak ilerleyiniz :)
//    Go to URL: https://healthunify.com/bmicalculator/
//    Entring weight
//    Selecting kilograms
//    Selecting height in feet
//    Selecting height in inchs
//    Clicking on calculate
//    Getting SIUnit value
//    Getting USUnit value
//    Getting UKUnit value
//    Getting overall description


    @Test
    public void logMessageTest() throws InterruptedException {
        PropertyConfigurator.configure("log4j.properties");
        Logger logger=Logger.getLogger(Homework1.class.getName());
        extentTest = extentReports.createTest("My first Test with LogMessage");
        extentTest.info("Go to URL :https://healthunify.com/bmicalculator/");

        driver.get("https://healthunify.com/bmicalculator/");
        WebElement enterWeight = driver.findElement(By.name("wg"));
        extentTest.info("Entring weight 105");
        enterWeight.sendKeys("105");
        WebElement selectKg = driver.findElement(By.name("opt1"));
        Select selkg = new Select(selectKg);
        extentTest.info("Selecting kilograms");
        selkg.selectByIndex(1);
        WebElement heightfeet = driver.findElement(By.name("opt2"));
        Select selheightfeet = new Select(heightfeet);
        extentTest.info("Selecting height in feet");
        selheightfeet.selectByIndex(4);
        WebElement heightInch = driver.findElement(By.name("opt3"));
        Select selheightInch = new Select(heightInch);
        extentTest.info("Selecting height in inchs");
        selheightInch.selectByIndex(8);
        WebElement calc = driver.findElement(By.name("cc"));
        extentTest.info("Clicking on calculate");
        calc.click();
        WebElement getSI = driver.findElement(By.name("si"));
        extentTest.info("Getting SI unit value");
        System.out.println(getSI.getAttribute("value"));
        logger.info("SI unit value printed");

        WebElement getUS = driver.findElement(By.name("us"));
        extentTest.info("Getting USUnit value");
        System.out.println(getUS.getAttribute("value"));
        logger.info("US unit printed");
        WebElement getUK = driver.findElement(By.name("uk"));
        extentTest.info("Getting UkUnit value");
        System.out.println(getUK.getAttribute("value"));
        logger.info("Uk unit printed");
        WebElement overall = driver.findElement(By.xpath("//input[@class='content']"));
        extentTest.info("Getting overall description");
        System.out.println(overall.getAttribute("value"));
        logger.info("Overall description printed");
        extentTest.pass("Test passed");

    }

}
