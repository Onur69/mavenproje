package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayedoOrnek {
    static WebDriver driver;
    @BeforeClass//annotation
    public static void setUp(){
        WebDriverManager.chromedriver().setup();

    }
    @Before
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://bestbuy.com/");
    }
    @After
    public void after(){
        driver.quit();
    }
    @Test//annotation
    public void titleTest()  {

        String sayfaBasligi = driver.getTitle();
        boolean varmi = sayfaBasligi.contains("Best");
        Assert.assertTrue(varmi);

    }

    @Test//annotation
    public void logoTest()  {

        driver.get("http://bestbuy.com/");
        WebElement logo = driver.findElement(By.className("logo"));
        boolean varmi = logo.isDisplayed();
        Assert.assertTrue(varmi);

    }
    @Test//annotation
    public void mexicoLinkTest() {

        driver.get("http://bestbuy.com/");
        WebElement link = driver.findElement(By.partialLinkText("Mexico"));
        boolean varmi = link.isDisplayed();
        Assert.assertTrue(varmi);

    }
}
