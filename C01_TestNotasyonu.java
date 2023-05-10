package day06_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.math.ec.ECLookupTable;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {
    /*
    bu class icerisinde 3 test calistialim
    1-google ana sayfaya gidip url'in google icerdigini test edin
    2-wise quarter ana sayfaya gidip url'in wise quarter icerdigini test edin
    3-amazon ana sayfaya gidip amazon logosunun göründügünü test edin.

    Juniit'in bize sagladigi en önemli özellik test methodlarının bagımsız olarak calistirilabilmesini saglayan
    @Test notasyonudur.
    ücünü birden calistirmak istersem class runner dan da calistirabilirim.
    Junit ile class leveldan birden fazla test methodu calistirirsak aynı sıralama ile calistiracagini öngöremeyiz ve
    yönetemeyiz.

     */
    /*
    diyelimki bir etst methodu üzerinde calisiyorsunuz ve o methodun toplu calistirmalarda kullanılmasını istemiyorsunuz
    o zaman @Ignore kullanılır.
     */
    WebDriver driver;
    @Test
    public void googleTest(){
        // 1-google ana sayfaya gidip url'in google icerdigini test edin
     mahserinDortAtlisi();
     driver.get("https://www.google.com");
     String expectedIcerik="google";
     String actualUrl=driver.getCurrentUrl();
     if(actualUrl.contains(expectedIcerik)){
         System.out.println("Google testi PASSED");
     }else{
         System.out.println("Url google icermiyor,Google testi fAILED");
         driver.close();
     }
    }
    @Test
    public void wiseTest(){
        // 2-wise quarter ana sayfaya gidip url'in wise quarter icerdigini test edin
        mahserinDortAtlisi();
        driver.get("https://www.wisequarter.com");
        String expectedIcerik="wise quarter";
        String acturalUrl=driver.getCurrentUrl();
        if(acturalUrl.contains(expectedIcerik)){
            System.out.println("wise quarter testi PASSED");
        }else {
            System.out.println("Wise testi FAILED");
        }
        driver.close();

    }
    @Test
    public void amazonTest(){
        // 3-amazon ana sayfaya gidip amazon logosunun göründügünü test edin.
        mahserinDortAtlisi();
        driver.get("https://www.amazon.com");
        WebElement amazonLogoElementi=driver.findElement(By.id("nav-logo-sprites"));
        if (amazonLogoElementi.isDisplayed()){
            System.out.println("Amazon logo test PASSED");
        }
        else {
            System.out.println("Amazon logo testi FAILED");
        }
        driver.close();



    }
    public void mahserinDortAtlisi(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}


