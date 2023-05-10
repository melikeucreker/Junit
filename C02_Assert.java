package day06_JunitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class C02_Assert {

    //Amazon'a gidip title'in AMAZON icerdigini test edin.

    @Test
    public void test01(){
        /*
        Junit calistirilan test method(lar)indan kac tanesinin passed,failed veya ignore oldugunu otomatik olarak raporlar
        Eger Junitin test sonuclarini dogru olarak raporlamasini istiyorsak
        Assert classından hazır methodlar kullanarak test yapmalıyız.


         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

        String expectedIcerik="AMAZON";
        String actualTitle=driver.getTitle();
       //if(actualTitle.contains(expectedIcerik)){
            System.out.println("Amazon title testi PASSED");
       // }else {
        //    System.out.println("Actual Title: "+actualTitle);
            System.out.println("Amazon title testi FAILED");
       // }
       assertTrue(actualTitle.contains(expectedIcerik));
        driver.close();


    }

}
