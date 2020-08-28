package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08_IlkOrnek {
        /*
        WebDriver'i neden burada tanımladık ?
        Cünkü, diğer merhodlardan da, yani tüm merhodlardan bu nesneye erişmek istiyoruz.
        Cünkü, findElement gibi methodları ister istemez test'lerin içerisnde kullanağız.
        Bu yuzden instance ve static variable olarak burda tanimladik.Ay gibi en tepeye asmis olduk.
         */
        static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test1(){
        driver.get("https://google.com");
    }
    @AfterClass
    public static void tearDown(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
