package TestEyp;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Testamazon {

    WebDriver driver;

    @Before
    public void setup(){

        //Driver olusturuldu
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //sayfanin yuklenmesi beklendi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //LinkedIn sitesine gidildi
        driver.get("https://www.amazon.com.tr/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com.tr%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=trflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");

        // driver imiz maximize edildi
        driver.manage().window().maximize();


    }

    @After
    public void tearDown(){

        // driver imiz kapatildi
       // driver.quit();
    }



    @Test
    public void idLocator(){
        // id Locator -> "session_key"

        WebElement email = driver.findElement(By.id("ap_email"));
        email.sendKeys("Eyüp ve Murat tan selamlar ne email i istiyorsun bizden?");

    }

    @Test
    public void nameLocator(){
        // name locator -> "session_password"

        WebElement password = driver.findElement(By.name("session_password"));

        password.sendKeys("Sifre");
    }


    @Test
    public void classLocator(){

        // class locator -> "input__input"

        WebElement email = driver.findElement(By.className("a-button-input"));
       email.sendKeys("Tıklıyorum");

        email.click();
    }

    @Test
    public void tagLocator(){

        // tag locator -> "input"

        List<WebElement> emailList = driver.findElements(By.tagName("input"));


        // 2. elementimiz email text alanimiz. Bu yuzden bu elemani email degiskenine assign ettik.
        WebElement email = emailList.get(9);

        email.sendKeys("      Zehra ve Eyüp");

    }

    @Test
    public void linkTextLocator(){
        // link text -> "Forgot password?"

        WebElement forgotPwd = driver.findElement(By.linkText("Yardıma mı ihtiyacınız var?"));
        forgotPwd.click();
        WebElement forgotPwd1 = driver.findElement(By.linkText("Şifremi unuttum"));

        forgotPwd1.click();

    }

    @Test
    public void partialLinkTextLocator(){
        // link text -> "Forgot password?"

        WebElement forgotPwd = driver.findElement(By.partialLinkText("Şifrenizi"));
        forgotPwd.click();

    }

    @Test
    public void absoluteXpath(){
        WebElement email = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[2]/div[1]/input"));
        email.sendKeys("Karl absolute xpath konusunu gayet basirili tamamladi");
    }


    @Test
    public void relativeXpath(){
        // xpath locator -> //input[@name='session_key']

        WebElement email = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
        email.sendKeys("Eyüp ve Zehra dan selamlar");
    }
    @Test
    public void relativeXpath1(){

        WebElement sifre1 = driver.findElement(By.className("a-expander-prompt"));
sifre1.click();
        WebElement sifre = driver.findElement(By.xpath("//*[@id=\"auth-fpp-link-bottom\"]"));

        sifre.click();
    }

}