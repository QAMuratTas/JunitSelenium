
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_JunitAssertions {

        //    Go to Amazon homepage.
//    Do the following tasks by creating 3 different test methods.
//    1- Test if the URL contains Amazon.
//    2- Test if the title does not contain Facebook.
//    3- Test that the Amazon logo appears in the upper left corner.

    WebDriver driver;


    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    public void after(){
        driver.quit();
    }


    public void URLTest(){
        driver.get("https://www.amazon.com/");
        String currentUrl = driver.getCurrentUrl();

        // URL amazon kelimesini iceriyor mu kontrol saglaniyor
        Assert.assertTrue("URL 'amazon' icermiyor", currentUrl.contains("Amazon"));
    }


    public void titleTest(){
        driver.get("https://www.amazon.com/");
        String title = driver.getTitle();
        Assert.assertFalse(title.contains("Facebook"));

    }

    //TO BE CONTINUED


}
