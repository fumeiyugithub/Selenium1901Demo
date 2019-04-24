package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsTwoTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
//        System.setProperty("webdriver.ie.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\IEDriverServer.exe");
//        driver = new InternetExplorerDriver();
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\chromedriver.exe");
         driver = new ChromeDriver();
//         全局等待
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    /**
     * 打开百度首页
     * 按鼠标右键点击百度按钮/双击
     */
    @Test
    public void  rightClickTest(){
      driver.get("https://www.baidu.com/");
      WebElement button = driver.findElement(By.id("su"));
//      实例化Actions这个类
      Actions actions = new Actions(driver);
//      点击右键
        actions.contextClick(button).perform();
//      actions.contextClick().build().perform();网上很多也这样写
//        双击百度一下按钮  perform执行
        actions.doubleClick(button).perform();


    }
    /**
     * 1.打开“UI自动化测试”主页
     * 2.鼠标移动到action元素上
     * 3.那么现实Hello World!
     */
    @Test
    public void moveToTest(){
//      打开“UI自动化测试”主页
        driver.get("file:///C:/Users/ah/Desktop/selenium_html/index.html");
//        定位到元素action
        WebElement button = driver.findElement(By.className("over"));
        Actions actions = new Actions(driver);
        actions.moveToElement(button).perform();
        String  test = driver.findElement(By.xpath("//*[text()='Hello World!']")).getText();
        Assert.assertEquals(test,"Hello World!");

    }
    /**
     * 元素拖动
     */
    @Test
    public void dropTest() throws InterruptedException {
//      打开页面
        driver.get("file:///C:/Users/ah/Desktop/selenium_html/dragAndDrop.html");
//        定位到元素
        WebElement div = driver.findElement(By.id("drag"));
//        实例化
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(div,500,500).perform();
        Thread.sleep(3000);
    }
    /**
     * 元素拖动到另一个元素上
     */
    @Test
    public void dropTwoTest() throws InterruptedException {
//      打开页面
        driver.get("file:///C:/Users/ah/Desktop/selenium_html/dragAndDrop.html");
//        定位到第一个元素
        WebElement div = driver.findElement(By.id("drag"));
//        定位到第二个元素
        WebElement div2 =driver.findElement(By.xpath("/html/body/h1"));
//        实例化
        Actions actions = new Actions(driver);
//                按住第一个元素     拖到第二个元素      放开       执行
        actions.clickAndHold(div).moveToElement(div2).release().perform();
        Thread.sleep(3000);
    }


    /**
     * 下拉框多选
     */
    @Test
    public void moreSelectTest() throws InterruptedException {
//      打开“UI自动化测试”主页
        driver.get("file:///C:/Users/ah/Desktop/selenium_html/index.html");
        Thread.sleep(3000);
//        定位元素
        WebElement div = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement>  list = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
//        实例化actions
        Actions actions = new Actions(driver);
//                   按住shift键       选择第一个         再选择第三个        放开shift键       执行
        actions.keyDown(Keys.SHIFT).click(list.get(2)).keyUp(Keys.SHIFT).perform();
//        actions.keyDown(Keys.CONTROL).click(list.get(2)).keyUp(Keys.CONTROL).perform();
//        Keys这里面没有字母只有外围的哪些键  java的Robot类则提供了键盘和鼠标的所有操作如下saveHtml()方法
        Thread.sleep(3000);
    }

    /**
     * 1.打开百度首页
     * 2.按住contrl+S保存网页
     * 3.按enter键保存
     * @throws AWTException
     * @throws InterruptedException
     */
    @Test
    public void saveHtml() throws AWTException, InterruptedException {
        driver.get("https://www.baidu.com/");
//        实例化robot
        Robot robot = new Robot();
//            按住control；
        robot.keyPress(KeyEvent.VK_CONTROL);
//        按住S
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
//        按住回车键
        robot.keyPress(KeyEvent.VK_ENTER);
//        将相应按键转化成ascii码
//        int keys =(int)new Character('A');
//        释放control；
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
    }

    /**
     * 1.打开“UI自动化测试”主页
     * 2.上传文件
     */
    @Test
    public void uploadTest() throws InterruptedException {
//      打开“UI自动化测试”主页
        driver.get("file:///C:/Users/ah/Desktop/selenium_html/index.html");
//        定位到元素上传按钮
        driver.findElement(By.id("load")).sendKeys("C:\\Users\\ah\\Desktop\\新建文本文档.txt");
        Thread.sleep(3000);
    }
    @AfterMethod
    public void closedChrome(){
        driver.quit();
    }
}
