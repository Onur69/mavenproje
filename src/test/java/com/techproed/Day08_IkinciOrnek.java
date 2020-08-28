package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08_IkinciOrnek {
        static WebDriver driver;

    @BeforeClass//class calisinca ilkonce calisacak
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass//class calismayi bitirince calisacak
    public static void tearDown(){
        driver.quit();
    }
    @Before//her testten once calisacak
    public void testtenOnce(){
       driver.get("http://google.com");
    }
    @After//her testten sonra calisacak
    public void testtenSonra(){
        WebElement sonucSayisi = driver.findElement(By.id("result-stats"));
        System.out.println(sonucSayisi.getText());
    }
    @Test
    public void test1(){
        WebElement aramakutusu = driver.findElement(By.name("q"));
        aramakutusu.sendKeys("elma");
        aramakutusu.submit();
    }
    @Test
    public void test2(){
        WebElement aramakutusu = driver.findElement(By.name("q"));
        aramakutusu.sendKeys("kulaklik");
        aramakutusu.submit();
    }
    @Test
    public void test3(){
        WebElement aramakutusu = driver.findElement(By.name("q"));
        aramakutusu.sendKeys("calisma sandalyesi");
        aramakutusu.submit();
    }
}
