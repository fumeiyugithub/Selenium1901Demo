package com.meyoung.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {
    @Test
    public void testChrome() throws InterruptedException, MalformedURLException {
//        创建一个DesiredCapabilities类型
        DesiredCapabilities dc = DesiredCapabilities.chrome();
//        实例化一个driver                                       一个hub地址（若是指定node则可换成node的服务器地址）                    浏览器
        WebDriver webDriver = new RemoteWebDriver(new URL("http://192.168.0.113:4444/wd/hub"),dc);
        webDriver.get("https://www.baidu.com");
        Thread.sleep(5000);
        webDriver.quit();
    }


    @DataProvider(name = "data")
    public Object[][] test1(){
        return new Object[][]{
//                也可以跟路径指定node
                {"ie","http://192.168.0.113:5555/wd/hub"},
                {"chrome","http://192.168.0.113:4444/wd/hub"}
        };
    }
    @Test(dataProvider = "data")
    public void grid2Test(String browser,String url) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc=null;
        if(browser.equals("ie")){
            dc= DesiredCapabilities.internetExplorer();
        }else if (browser.equals("chrome")){
            dc = DesiredCapabilities.chrome();
        }else {
            System.out.println("error");
        }
        WebDriver webDriver = new RemoteWebDriver(new URL(url),dc);
        webDriver.get("https://www.baidu.com")   ;
        Thread.sleep(2000);
        webDriver.quit();
    }

}
