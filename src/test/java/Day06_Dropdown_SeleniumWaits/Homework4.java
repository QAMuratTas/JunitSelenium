package Day06_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

import java.util.List;

public class Homework4 {

    //    Go to URL: https://the-internet.herokuapp.com/dropdown
//    Create method selectByIndexTest and Select Option 1 using index .
//    Create method selectByValueTest Select Option 2 by value.
//    Create method selectByVisibleTextTest Select Option 1 value by visible text.
//    Create method printAllTest Print all dropdown value.
//    Verify the dropdown has Option 2 text.
//    Create method printFirstSelectedOptionTest Print first selected option.
//    Find the size of the dropdown, Print "Expected Is Not Equal Actual"
//    if there are not 3 elements in the dropdown.
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");

    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void selectByIndexTest() {

        Select s = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        s.selectByIndex(1);
    }

    @Test
    public void selectByValueTest() {

        Select s = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        s.selectByValue("2");
    }

    @Test
    public void selectByVisibleTextTest() {

        Select s = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        s.selectByVisibleText("Option 1");
    }

    @Test
    public void printAllTest() {

        Select s = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        List<WebElement> s1 = s.getOptions();


        for (int i = 0; i < s1.size(); i++) {
            System.out.println(s1.get(i).getText());
        }
        driver.quit();
    }

    @Test
    public void verify() {
        Select s = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        List<WebElement> s1 = s.getOptions();
        Assert.assertTrue(s1.stream().anyMatch(t -> t.getText().contains("Option 2")));
    }

    @Test
    public void printFirstSelectedOptionTest() {
        Select s = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        s.selectByIndex(1);
        s.selectByIndex(0);
        System.out.println(s.getFirstSelectedOption().getText());

    }

    @Test
    public void sizeExp() {
        Select s = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        if (s.getOptions().size() != 3) {
            System.out.println("Expected Is Not Equal Actual");
        }
    }
}
