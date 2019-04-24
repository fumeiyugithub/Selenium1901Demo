package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowSelectTest {

    WebDriver webDriver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\chromedriver.exe");
        webDriver= new ChromeDriver();
    }

    /**
     * 1.打开“UI自动化测试”主页
     * 2.点击open new window
     * 3.点击百度
     */
    @Test
    public void selectTest() throws InterruptedException {
//      打开“UI自动化测试”主页
        webDriver.get("file:///C:/Users/ah/Desktop/selenium_html/index.html");
        webDriver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);
//        当前所在页面的 句柄值
        String handle1 = webDriver.getWindowHandle();
//        for循环判断  获取的handles是否等于handle
        for(String handles:webDriver.getWindowHandles()){
            if(handles.equals(handle1)){
                continue;
            }else {
                webDriver.switchTo().window(handles);
            }
        }
        webDriver.findElement(By.linkText("baidu")).click();
    }

    @AfterMethod
    public void closedChrome() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }

}
