package com.meyoung.day2;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionsTest {

    WebDriver webDriver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\chromedriver.exe");
        webDriver= new ChromeDriver();
    }

    /**
     * 打开百度首页点
     * 定位更多产品链接
     * 点击链接
     * 校验链接
     */
    @Test
    public void clickTest() throws InterruptedException {
//        打开百度
        webDriver.get("https://www.baidu.com/");

//        找到更多产品元素
        WebElement newsLink = webDriver.findElement(By.name("tj_briicon"));
//        点击更多产品
        newsLink.click();
        Thread.sleep(2000);
//        获取当前网址
        String url =webDriver.getCurrentUrl();
//        校验是否是新闻页面
        Assert.assertEquals(url,"https://www.baidu.com/");
    }
    /**sendkeys只能对文本框input操作
     * 打开百度首页点
     * 输入selenium 点击百度一下
     * 校验title是否等于selenium_百度搜索
     */
    @Test
    public void sendkeysTest() throws InterruptedException {
//        打开百度
        webDriver.get("https://www.baidu.com/");
//        定位输入框元素
        WebElement input = webDriver.findElement(By.id("kw"));
//        输入selenium
        input.sendKeys("selenium");
//        定位百度一下按钮定位
        WebElement button = webDriver.findElement(By.id("su"));
//        点击
        button.click();
//      获取页面title
        Thread.sleep(3000);
        String url =webDriver.getTitle();
//        校验是否是搜索了
        Assert.assertEquals(url,"selenium_百度搜索");
    }
    /**
     * 打开百度首页
     * 输入selenium
     * 清除selenium
     */
    @Test
    public void clearTest() throws InterruptedException {
//          打开百度
        webDriver.get("https://www.baidu.com/");
//        定位输入框元素
        WebElement input = webDriver.findElement(By.id("kw"));
//        输入selenium
        input.sendKeys("selenium");
        Thread.sleep(2000);
//        清空文本框
        input.clear();
        Thread.sleep(2000);
    }

    /** 打开百度首页点
     * 获取更多产品文本
     */
    @Test
    public void getTextTest() {
//          打开百度
        webDriver.get("https://www.baidu.com/");
//        找到更多产品元素
        WebElement newsLink = webDriver.findElement(By.name("tj_briicon"));
//      获取文本框内容
       String text1 = newsLink.getText();
//     校验是否是更多产品
        Assert.assertEquals(text1,"更多产品");
    }

    /**
     * 打开百度首页
     * 获取文本框的tagname
     * 校验一下是否是input
     */
    @Test
    public void tagNameTest() {
//          打开百度
        webDriver.get("https://www.baidu.com/");
//        找到更多产品元素
        WebElement input = webDriver.findElement(By.id("kw"));
//        获取tagName
        String tagName = input.getTagName();
//     校验是否是否是input
       Assert.assertEquals(tagName,"input");
    }

    /**
     * 1.打开百度首页
     * 2.搜索框输入abc
     * 3.获取搜索框的value属性值
     * 4. 校验是否是abc
     */
    @Test
    public void getAttribute(){
//       打开百度
        webDriver.get("https://www.baidu.com/");
//        定位搜索框
        WebElement input = webDriver.findElement(By.id("kw"));
//        输入abc
        input.sendKeys("abc");
//        获取搜索框的value属性值
        String value = input.getAttribute("value");
        System.out.println(value);
//        校验是否是abc
        Assert.assertEquals(value,"abc");
    }

    /**
     * 1.打开百度首页
     * 2.判断百度一下按钮是否显示
     */
    @Test
    public void isDesplayedTest(){
//        打开百度
        webDriver.get("https://www.baidu.com/");
//      定位百度一下按钮定位
        WebElement button = webDriver.findElement(By.id("su"));
        Boolean result = button.isDisplayed();
        Assert.assertTrue(result);
    }

    /**
     * 1.打开“UI自动化测试”主页
     * 2.校验“Volvo"单选框已经选中
     */
    @Test
    public void isSelectedTest(){
//      打开“UI自动化测试”主页
        webDriver.get("file:///C:/Users/ah/Desktop/selenium_html/index.html");
//       webDriver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]")).click();
//      校验“Volvo"单选框已经选中
        Boolean a = webDriver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]")).isSelected();
        Assert.assertTrue(a);
    }

    /**isEnabled判断是否为激活状态
     * 1.打开“UI自动化测试”主页
     * 2.校验submit按钮为不点击状态
     */
    @Test
    public void isEnabledTest(){
        //      打开“UI自动化测试”主页
        webDriver.get("file:///C:/Users/ah/Desktop/selenium_html/index.html");
//        校验submit按钮为不点击状态
        Boolean a =webDriver.findElement(By.name("buttonhtml")).isEnabled();
        Assert.assertTrue(a);
    }

    /**getScreenshotAs只截取当前窗口
     * 1.打开百度首页
     * 2.截图
     */
    @Test
    public void screenShotTest(){
//        打开百度
        webDriver.get("https://www.baidu.com/");
//     把webDriver强制转换成TakesScreenshot类型
        File file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
//            将截图的文件cop到新建文件
            FileUtils.copyFile(file,new File("D:\\test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void closedChrome(){
        webDriver.quit();
    }
}
