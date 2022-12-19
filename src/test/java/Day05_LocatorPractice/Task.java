package Day05_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverInfo;

public class Task {
//https://www.teknosa.com/ adresine gidiniz.
// Arama çubuğuna ''oppo'’ yazıp ENTER tıklayınız.
// Sonuç sayısını yazdırınız.
// Çıkan ilk ürüne tıklayınız.
// Sepete ekleyiniz.
// Sepetime gite tıklayınız.
// Konsolda "Sipariş Özeti" WebElement'inin text'ini yazdırınız.
// Alışverişi tamamlayınız.
// Son olarak "Teknosa'ya Hoş Geldiniz" WebElement'inin text'ini yazdırınız.
// Driver'ı kapatınız.

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

@After
    public void tearDown(){
        driver.quit();
}
@Test
    public void teknosaTest (){
        driver.get("https://www.teknosa.com/");
    //WebElement reddet = driver.findElement(By.className("banner__reject-button"));
    //reddet.click();


        WebElement search = driver.findElement(By.xpath("//input[@name='s']"));//By.name('s')
    search.sendKeys("oppo"+ Keys.ENTER);
    //sonuc sayısı yazdırıldı
    WebElement result= driver.findElement(By.xpath("//div[@class='plp-info']"));
    System.out.println(result.getText());

    // ilk ürüne tikla sepete ekle. ilk ürün demeseyid list e atıp fori ile get() istenileni getirebilirdik
    WebElement firstPrd= driver.findElement(By.className("prd-link"));
    firstPrd.click();

    // Sepete ekle butonu tıklandı
   // WebElement button =driver.findElement(By.id("addToCartButton"));//15 tane var ilki istediği için sorun yok
    WebElement button =driver.findElement(By.xpath("(//button[@id='addToCartButton'])[1]])"));
    // [] sonunda kaçıncı sıradaki elementi alacaksak onun sırasını yazmalıyız. for i ye göre daha clean
    button.click();

    //sipariş özeti
    WebElement siparisOzet = driver.findElement(By.xpath("//div[@class='car-sum-body']"));
    System.out.println(siparisOzet.getText());

    // Alışverişi tamamla butonuna basıldı
    WebElement alisverisOk= driver.findElement(By.partialLinkText("Alışverişi Tamamla"));
    alisverisOk.click();

    // Teknosaya hoşgeldiniz texti yazdırıldı
    WebElement welcome =driver.findElement(By.xpath("//div[@class='lrp/title']"));
    System.out.println(welcome.getText());


}



}
