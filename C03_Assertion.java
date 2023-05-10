package day06_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertion {
    /*
    bir assertion failed olursa assertion'ın oldugu satirda exception olusur ve assertion satırından sonraki kodlar
    calismaz
     */
    WebDriver driver;
    @Test
    public void googleTest(){
        // 1-google ana sayfaya gidip url'in google icerdigini test edin
        mahserinDortAtlisi();
        driver.get("https://www.google.com");
        String expectedIcerik="google";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));

            driver.close();
        }

    @Test
    public void wiseTest(){
        // 2-wise quarter ana sayfaya gidip url'in wise quarter icerdigini test edin
        mahserinDortAtlisi();
        driver.get("https://www.wisequarter.com");
        String expectedIcerik="wisequarter";
        String acturalUrl=driver.getCurrentUrl();

        Assert.assertTrue(acturalUrl.contains(expectedIcerik));
        driver.close();

    }
    @Test
    public void amazonTest(){
        // 3-amazon ana sayfaya gidip amazon logosunun göründügünü test edin.
        mahserinDortAtlisi();
        driver.get("https://www.amazon.com");
        WebElement amazonLogoElementi=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(amazonLogoElementi.isDisplayed());
        driver.close();



    }
    public void mahserinDortAtlisi(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}
