package day06_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertions {
    /*
    1) Bir class oluşturun: BestBuyAssertions
2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
 ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
 ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
 ○ logoTest => BestBuy logosunun görüntülendigini test edin
 ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */
    WebDriver driver;
    public void mahserinDortAtlisi(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com");

    }

    @Test
    public void test01(){
        //○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
        mahserinDortAtlisi();
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);



    }
    @Test
    public void test02(){
        mahserinDortAtlisi();
        driver.get("https://www.bestbuy.com/");
        //titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String unExpectedIcerik="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(unExpectedIcerik));


    }
    @Test
    public void test03(){
        //logoTest => BestBuy logosunun görüntülendigini test edin
        mahserinDortAtlisi();
        driver.get("https://www.bestbuy.com/ ");
        WebElement logo= driver.findElement(By.xpath("//img[@alt='Best Buy Logo' ][1]"));
       boolean LogoTest= logo.isDisplayed();
       Assert.assertTrue(LogoTest);
       //Assert.assertTrue(logo.isDisplayed());

    }
    @Test
    public void test04(){
        mahserinDortAtlisi();
        // FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
       driver.get("https://www.bestbuy.com/ ");
        WebElement francaisLinkTest=driver.findElement(By.xpath("//button[@class='is-active']"));
        Assert.assertTrue(francaisLinkTest.isDisplayed());

    }
}
