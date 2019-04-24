package com.meyoung.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenBrowserTest {
//    打开火狐浏览器
    @Test
    public void openFF(){
//        启动火狐浏览器当火狐是默认安装路径的时候
        WebDriver webDriver = new FirefoxDriver();

    }
    @Test
    public void openFF2(){
//        启动火狐浏览器当火狐不是默认安装路径的时候
        System.setProperty("webDriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();

    }
    @Test
    public void openChrome(){
//        启动谷歌浏览器
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\chromedriver.exe");
            WebDriver webDriver= new ChromeDriver();
    }
    @Test
    public void openie(){
        System.setProperty("webdriver.ie.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\IEDriverServer.exe");
        WebDriver webDriver = new InternetExplorerDriver();
    }
}
