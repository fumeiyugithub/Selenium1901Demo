package com.meyoung.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {

    WebDriver webDriver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\chromedriver.exe");
        webDriver= new ChromeDriver();
    }

    /**
     * 1.打开“UI自动化测试”主页
     * 2.点击百度链接
     */
    @Test
    public void iframeTest() throws InterruptedException {
//      打开“UI自动化测试”主页
        webDriver.get("file:///C:/Users/ah/Desktop/selenium_html/index.html");
//        通过id或者name的方式转交控制权
//        webDriver.switchTo().frame("aa");
//      通过元素将控制权转交
        WebElement iframe= webDriver.findElement(By.tagName("iframe"));
        webDriver.switchTo().frame(iframe);
        webDriver.findElement(By.linkText("baidu")).click();
//        webdriver转交到原来的界面
        webDriver.switchTo().defaultContent();
        Thread.sleep(3000);
        webDriver.findElement(By.linkText("登陆界面")).click();
    }

    @AfterMethod
    public void closedChrome() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
}
