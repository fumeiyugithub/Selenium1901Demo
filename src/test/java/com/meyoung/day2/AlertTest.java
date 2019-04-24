package com.meyoung.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {

//js的警告弹窗才能用webDriver.switchTo().alert()
    WebDriver webDriver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\chromedriver.exe");
        webDriver= new ChromeDriver();
    }

    /**
     * 1.打开“UI自动化测试”主页
     * 2.点击alert按钮
     * 3.在alert警告框点击“确定”按钮
     */
    @Test
    public void alertTest() throws InterruptedException {
//      打开“UI自动化测试”主页
        webDriver.get("file:///C:/Users/ah/Desktop/selenium_html/index.html");
//       点击alert按钮
        webDriver.findElement(By.className("alert")).click();
//        webDriver把控制权转交给alert(弹窗)
        Alert alert = webDriver.switchTo().alert();
        Thread.sleep(3000);
//        获取警告框的文本值
        String text = alert.getText();
//        在alert警告框点击“确定”按钮
        alert.accept();
        Assert.assertEquals(text,"请点击确定");
        Thread.sleep(3000);
    }

    /**
     * 1.打开“UI自动化测试”主页
     * 2.点击confirm按钮
     * 3.在confirm警告框点取消按钮
     * 4.再次点击确定按钮
     */
    @Test
    public void confirmTest() throws InterruptedException {
//      打开“UI自动化测试”主页
        webDriver.get("file:///C:/Users/ah/Desktop/selenium_html/index.html");
//       点击confirm按钮
        webDriver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
//        webDriver把控制权转交给alert(弹窗)
        Alert alert = webDriver.switchTo().alert();
        Thread.sleep(3000);
//       点击取消
        alert.dismiss();
        Thread.sleep(3000);
//        点击确定
        alert.accept();
        Thread.sleep(3000);
    }

    /**
     * 1.打开“UI自动化测试”主页
     * 2.点击prompt按钮
     * 3.在prompt弹窗中，输入“这个是prompt”
     * 4.点击确定按钮
     * 5.再次点击确定
     */
    @Test
    public void promptTest() throws InterruptedException {
//      打开“UI自动化测试”主页
        webDriver.get("file:///C:/Users/ah/Desktop/selenium_html/index.html");
//       点击prompt按钮
        webDriver.findElement(By.className("prompt")).click();
//        webDriver把控制权转交给alert(弹窗)
        Alert alert = webDriver.switchTo().alert();
//      在prompt弹窗中，输入“这个是prompt”
        alert.sendKeys("这个是prompt");
        Thread.sleep(6000);
//        点击确定
        alert.accept();
        Thread.sleep(3000);
//        点击确定
        alert.accept();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void closedChrome(){
        webDriver.quit();
    }
}
