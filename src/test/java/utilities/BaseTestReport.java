package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseTestReport {
    protected WebDriver driver;

    protected ExtentReports extentReports;// rapormlama işlemini gerçekleştirir

    protected ExtentHtmlReporter extentHtmlReporter; //raporu HTML olarak düzenler

    protected ExtentTest extentTest;// testimizin pass veya fail saklayan objemiz.Ekran görüntüleri için de kullanılır.






    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Extend reoprt objelerimizi de oluşturuyoruz

        extentReports = new ExtentReports();
        String currentDay =new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
        String filePath = System.getProperty("user.dir")+"/test-output/reports/testreport_"+currentDay+".html";
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);

        extentReports.setSystemInfo("Environment ","QA");
        extentReports.setSystemInfo("Browser","chrome");

        extentHtmlReporter.config().setDocumentTitle("CWreport");

        extentHtmlReporter.config().setReportName(" Test run reoprt");




    }
    @After
    public void teardown (){
        driver.quit();
    }



}
