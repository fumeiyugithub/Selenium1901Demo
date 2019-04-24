package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest {

    WebDriver webDriver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\chromedriver.exe");
        webDriver= new ChromeDriver();
//        全局等待  每个fandElement都会用到这个等待
//        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
    }

    /**
     * 1.打开“UI自动化测试”主页
     * 2.点击wait按钮
     * 3.获取文本并判断是否是“wait for display”
     */
    @Test
    public void waitTest(){
//      打开“UI自动化测试”主页
        webDriver.get("file:///C:/Users/ah/Desktop/selenium_html/index.html");
//      点击wait按钮
        webDriver.findElement(By.className("wait")).click();


//        智能等待/显示等待
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,10);
//        传值是定位方式  若没找到要找的元素则timeout报错
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div111")));


        String text = webDriver.findElement(By.xpath("//*[@id=\"display\"]/div111")).getText();
        Assert.assertEquals(text,"wait for display");

    }

    @AfterMethod
    public void closedChrome() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }

}
