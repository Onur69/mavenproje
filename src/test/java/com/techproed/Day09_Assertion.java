package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day09_Assertion {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test1(){
        driver.get("https://google.com");
        //Test Case: google.com'un basligi "Google Arama Sayfasi" olsun
        String title = driver.getTitle();

        //Google'in titlei "Google Arama Sayfasi" na esit mi degilmi?'
        Assert.assertEquals("Google Arama Sayfasi",title);
        //Assert.assertEquals(6,5);
        //Assert.assertEquals(true ,false); sekillerinde de olabilir.
    }
    @Test
    public void test2(){
        driver.get("http://amazon.com");
        //amazon.com'un basligi "Amazon" kelimesini icermesi lazim
        String title = driver.getTitle();

        boolean iceriyormu = title.contains("Amazon");
        //boolean veri tipinde deger giriyoruz.
        Assert.assertTrue(iceriyormu);//true oldugunu dogrula
        //parantezin ici dogruysa true ise test basarili
    }
    @Test
    public void test3(){
        driver.get("http://facebook.com");
        String title = driver.getTitle();

        boolean iceriyormu = title.contains("Youtube");
        Assert.assertFalse(iceriyormu);//false oldugunu dogrula
        //parantezin ici yanlissa false ise test basarili
       }
       @Test
       public void test4(){
           driver.get("https://google.com");
           String title = driver.getTitle();

           System.out.println("merhabalar");

           Assert.assertEquals("Google Arama Sayfasi",title);

           //eger test basarisiz ise methodun kalanini calistirmiyor
           //yani asagidaki sout calismayacak
           System.out.println("test dogrulama islemi bitti");
       }
    @Test
    public void test5(){
        driver.get("http://facebook.com");
        String title = driver.getTitle();

        boolean iceriyormu = title.contains("Youtube");
        Assert.assertFalse(iceriyormu);//false oldugunu dogrula

        //eger test basarili ise methodun kalanini calistiriyor
        //yani asagidaki sout calisacak
        System.out.println("test dogrulama islemi bitti");
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
