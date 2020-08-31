package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day10_DropDown {
    static WebDriver driver;
    @BeforeClass//annotation
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

        Select select = new Select(dropDown);

        Thread.sleep(2000);

        select.selectByVisibleText("Baby");

        Thread.sleep(2000);

        select.selectByValue("search-alias=automotive-intl-ship");

        Thread.sleep(2000);

        select.selectByIndex(5);

        WebElement secim = select.getFirstSelectedOption();
        System.out.println(secim.getText());

        List<WebElement> liste = select.getOptions();
        for (WebElement w: liste ) {
            System.out.println(w.getText());
        }
        int toplamSecenekSayisi = liste.size();
        System.out.println("toplamSecenekSayisi:" + toplamSecenekSayisi);


    }
}
