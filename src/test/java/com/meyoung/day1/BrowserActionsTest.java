package com.meyoung.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserActionsTest {
    WebDriver webDriver;
    @BeforeMethod
    public void openBrowse(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\chromedriver.exe");
        webDriver= new ChromeDriver();
    }
    /**
     * 打开chrome浏览器
     * 浏览器窗口大小300x300
     * 等待2s
     * 打开百度首页
     * 等待2s
     * 窗口最大化
     * 等待2s
     * 关闭浏览器
     */
    @Test
    public void openaidu() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\chromedriver.exe");
//         webDriver= new ChromeDriver();
        Dimension dimension = new Dimension(300,300);
        webDriver.manage().window().setSize(dimension);
        //等待2s
        Thread.sleep(2000);
        //打开百度首页
        webDriver.get("https://www.baidu.com");
        //等待2s
        Thread.sleep(2000);
        //设置窗口最大化
        webDriver.manage().window().maximize();
        //等待2s
        Thread.sleep(2000);
//        webDriver.quit();
    }

    /**
     * 打开chrome浏览器
     * 打开百度首页
     * 获取当前路径的url
     * 等待3s
     * 校验当前地址是不是百度地址
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void backTest() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\chromedriver.exe");
//         webDriver= new ChromeDriver();
        //打开百度首页
        webDriver.get("https://www.baidu.com");
        String url = webDriver.getCurrentUrl();
        String title =webDriver.getTitle();
        System.out.println("当前地址是:"+url+";当前的title是：");
        Assert.assertEquals(url,"https://www.baidu.com/");
        //等待5s
        Thread.sleep(3000);
        //后退
        webDriver.navigate().back();
        Thread.sleep(3000);
//        webDriver.quit();
    }


    /**
     * 打开chrome浏览器
     * 打开百度首页
     * 等待3s
     * 后退
     * 等待3s
     * 前进
     * 关闭浏览器
     */
    @Test
    public void forwardTest() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\chromedriver.exe");
//        webDriver= new ChromeDriver();
        //打开百度首页
        webDriver.get("https://www.baidu.com");
        //等待5s
        Thread.sleep(3000);
        //后退
        webDriver.navigate().back();
        Thread.sleep(3000);
        //前进
        webDriver.navigate().forward();
        Thread.sleep(3000);
//        webDriver.quit();
    }

    /**getAttribute获取属性的值
     * 打开chrome浏览器
     * 打开百度首页
     * 等待3s
     * 刷新
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void refreshTest() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\chromedriver.exe");
//         webDriver= new ChromeDriver();
        //打开百度首页
        webDriver.get("https://www.google.com.hk/");
        //等待5s
        Thread.sleep(3000);
        webDriver.navigate().refresh();
        //刷新
        Thread.sleep(3000);
//        webDriver.quit();
    }

    @AfterMethod
    public void closedBrowse(){
        webDriver.quit();
    }
}
