package com.meyoung.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {

    WebDriver webDriver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\chromedriver.exe");
        webDriver= new ChromeDriver();
    }

    /**
     * 1.打开“UI自动化测试”主页
     * 2.下拉框选择vivo
     * 3.第二次选择huawei
     * 4.第三次选择iphone
     */
    @Test
    public void selectTest() throws InterruptedException {
//      打开“UI自动化测试”主页
        webDriver.get("file:///C:/Users/ah/Desktop/selenium_html/index.html");
        WebElement se = webDriver.findElement(By.id("moreSelect"));
//        实例化select类
        Select select = new Select(se);
//        通过索引
        select.selectByIndex(0);
        Thread.sleep(3000);
//        通过属性
        select.selectByValue("huawei");
        Thread.sleep(3000);
//        通过文本值
        select.selectByVisibleText("iphone");
    }

    @AfterMethod
    public void closedChrome() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }

}
