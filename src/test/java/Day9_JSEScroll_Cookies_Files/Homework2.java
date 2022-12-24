package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.BaseTest;

import java.util.Set;

public class Homework2 extends BaseTest {

//    Go to URL: http://facebook.com
//    getCookies,
//    addCookie,
//    deleteCookieNamed,
//    deleteAllCookies.
    @Test
    public void cookies() {
        driver.get("http://facebook.com");
        Set<Cookie> all = driver.manage().getCookies();
        System.out.println("Cookiler :"+all);
        System.out.println("Bütün cookie lerin sayısı :"+all.size());
        Cookie add =new Cookie("face","book");
        driver.manage().addCookie(add);
        System.out.println("eklendikten sonra : " + driver.manage().getCookies());
        System.out.println("Eklendikten sonra sayısı : " + driver.manage().getCookies().size());
        driver.manage().deleteCookieNamed(add.getName());
        System.out.println(driver.manage().getCookies());
        driver.manage().deleteAllCookies();
        System.out.println("Son olarak cookie sayısı : " + driver.manage().getCookies().size());


    }
}
