package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayed {
    static WebDriver driver;
    @BeforeClass//annotation
    public static void setUp(){
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test//annotation
    public void test01(){
       //google.com a gidiyoruz
       driver.get("http://google.com");
        WebElement logo = driver.findElement(By.id("hplogo"));

        boolean gorunuyormu = logo.isDisplayed();
        Assert.assertTrue(gorunuyormu);
    }
    @AfterClass//annotation
    public static void tearDown(){
       //driver.quit();
    }
}
