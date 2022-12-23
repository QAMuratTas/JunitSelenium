package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.BaseTest;

import java.util.Set;

public class c4_Cookies extends BaseTest {
//    Go to URL: https://kitchen.applitools.com/ingredients/cookie
//    Get Cookie.
//    Find the total number of cookies.
//    Print all the cookies.
//    Add Cookie.
//    Edit Cookie.
//    Delete Cookie.
//    Delete All Cookies.


    @Test
    public void testCookie() {
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        System.out.println("test get cookie");
        Cookie cookie =driver.manage().getCookieNamed("protein");
        Assert.assertEquals("chicken",cookie.getValue());

        //Find the total number of cookies.
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numofCookies = allCookies.size();
        System.out.println("numofCookies = " + numofCookies);

        //print all cookies
        for (Cookie each:allCookies
             ) {
            System.out.println("each = " + each);
            System.out.println("each.getName() = " + each.getName());
            System.out.println("each.getValue() = " + each.getValue());

        }

        System.out.println("add cookies")        ;
    Cookie cookie1 =new Cookie("fruit","apple");
    driver.manage().addCookie(cookie1);
    Assert.assertEquals(cookie1.getValue(),driver.manage().getCookieNamed(cookie1.getName()).getValue());
allCookies =driver.manage().getCookies();
        System.out.println("allCookies.size() = " + allCookies.size());


        //edit cookies
        System.out.println("edit cookies");
        Cookie edited =new Cookie(cookie1.getName(),"mango");
        driver.manage().addCookie(edited);
        Assert.assertEquals(edited.getValue(),driver.manage().getCookieNamed(cookie1.getName()).getValue());

        System.out.println("driver.manage().getCookieNamed(cookie1.getName()).getValue() = " + driver.manage().getCookieNamed(cookie1.getName()).getValue());
    }
}
