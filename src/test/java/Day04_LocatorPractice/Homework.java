package Day04_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework {
    //Navigate to https://testpages.herokuapp.com/styled/index.html
// Click on Calculate under Micro Apps.
// Type any number in the first input.
// Type any number in the second input.
// Click on Calculate.
// Get the result.
// Print the result.
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() {
        //driver.quit();

    }

    @Test
    public void test() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement calc = driver.findElement(By.xpath("//*[@id=\"calculatetest\"]"));
        calc.click();
        WebElement type1 = driver.findElement(By.xpath("//*[@id=\"number1\"]"));
        type1.sendKeys("2522");
        WebElement type2 = driver.findElement(By.xpath("//*[@id=\"number2\"]"));
        type2.sendKeys("22");
        WebElement calculate = driver.findElement(By.xpath("//*[@id=\"calculate\"]"));

        calculate.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"answer\"]"));
        System.out.println("Result  = " + result.getText());


    }

}
