package com.meyoung.day3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class JSTest {

    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    /**
     * 打开百度首页
     * 定位搜索文本框
     */
    @Test
    public void  jsTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"baidu\");");
        Thread.sleep(3000);
    }
    @AfterMethod
    public void closedChrome(){
        driver.quit();
    }
}
