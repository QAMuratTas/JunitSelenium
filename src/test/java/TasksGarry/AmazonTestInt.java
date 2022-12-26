package TasksGarry;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

public class AmazonTestInt extends BaseTest {
    @Override
    public void tearDown() {

    }

    @Test
    public void testAmazon() throws InterruptedException {
        driver.get("https://www.amazon.com.tr/");

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.amazon.com"));
        WebElement CookiesButtonOk = driver.findElement(By.id("a-autoid-0"));
        CookiesButtonOk.click();
        WebElement girisYap = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        girisYap.click();

        WebElement email = driver.findElement(By.id("ap_email"));
        email.sendKeys("email@amazon.com" + Keys.ENTER);
        WebElement password = driver.findElement(By.id("ap_password"));
        password.sendKeys("emailpassword12345" + Keys.ENTER);
        //login olunmadığı
        WebElement loginKontrol = driver.findElement(By.xpath("//h4[@class='a-alert-heading']"));
        Assert.assertEquals("Bir sorun oluştu",loginKontrol.getText());// -->Burada bir defa test true dedi ondan sonra false veriyor. Anlam veremedim
        WebElement anasayfayaDon = driver.findElement(By.xpath("//i[@class='a-icon a-icon-logo']"));
        anasayfayaDon.click();
        WebElement kategoriSec = driver.findElement(By.id("searchDropdownBox"));
        // Kategori olarak Bilgisayarlar seçiliyor
        Select s = new Select(kategoriSec);
        s.selectByIndex(3);
        //Bilgisayarlar kategorisi seçilip seçilmedği kontrol ediliyor...
        Assert.assertTrue(kategoriSec.getText().contains("Bilgisayarlar"));

        //MSI aranıyor
        WebElement aramaMsi = driver.findElement(By.id("twotabsearchtextbox"));
        aramaMsi.sendKeys("MSI" + Keys.ENTER);
        WebElement MSIkonrol = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]"));
        //listeleme kontrol ediliyor
        Assert.assertTrue(MSIkonrol.getText().contains("Aranan ürün"));
        Actions act = new Actions(driver);
        //1.sayfanın sonuna gidiliyor...
        act.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        //2. sayafaya gidiliyor..
        WebElement ikinciSayfa = driver.findElement(By.xpath("//a[@aria-label='2 sayfasına git']"));
        ikinciSayfa.click();
        //2. sayfada olmamız kontrol ediliyor
        Assert.assertTrue(driver.getCurrentUrl().contains("page=2"));
        //2. ürün tıklanıyor
        WebElement ikinciUrunTik = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));
        ikinciUrunTik.click();
        // üyeliğim olmadığı için sepete ekledim
        WebElement sepeteEkle =driver.findElement(By.id("add-to-cart-button"));
        sepeteEkle.click();
        // Sepete eklendiği kontrol ediliyor...
        WebElement sepetKontrol =driver.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']"));
        Assert.assertTrue(sepetKontrol.isDisplayed());
        // sepete gidiliyor
        WebElement sepeteGit =driver.findElement(By.id("nav-cart-count"));
        sepeteGit.click();
        // alışveriş sepeti nde oldugu komntrol ediliyor
        WebElement sepet= driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(sepet.getText().contains("Alışveriş Sepeti"));
        // ürün sepetten silinyior
        WebElement sil =driver.findElement(By.xpath("//input[@data-action='delete']"));
        sil.click();
        // silme işlemi kontrol ediliyor
        WebElement silKontrol =driver.findElement(By.xpath("//h1[@class='a-spacing-mini a-spacing-top-base']"));
        Assert.assertTrue(silKontrol.getText().contains("Amazon sepetiniz boş."));
        // Üye çıkış olmadığı için ana sayfaya dönüldü...
        WebElement anaSayfagit = driver.findElement(By.id("nav-logo-sprites"));
        anaSayfagit.click();
        // Anasayfaya gidildiği kontrol ediliyor
        Assert.assertEquals("https://www.amazon.com.tr/ref=nav_logo",driver.getCurrentUrl());

    }


}
