package com.meyoung.day3;

import com.pro.day4.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.163.com/");
    }
    /**
     *
     *163邮箱登陆
     * 1.输入正确的邮箱名
     * 2.输入正确的密码
     * 3.点击登陆
     */
    @Test
    public void  loginTest(){
        //        显示等待
        WebDriverWait webDriverWait = new WebDriverWait(driver,30);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[starts-with(@id,'x-URS-iframe')]")));
//        定位iframe
        WebElement frame = driver.findElement(By.xpath("//*[starts-with(@id,'x-URS-iframe')]"));
//        将控制权转交给
       driver.switchTo().frame(frame);
       driver.findElement(LoginPage.loginName).sendKeys("15764250110");
       driver.findElement(LoginPage.password).sendKeys("57102388");
       driver.findElement(LoginPage.loginButton).click();
       webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
       String text =driver.findElement(By.linkText("退出")).getText();
       Assert.assertEquals(text,"退出");
    }

    /**
     *163邮箱登陆
     * 1.输入正确的邮箱名
     * 2.输入错误的密码
     * 3.点击登陆
     */
    @Test
    public void  loginFailTest(){
        //        显示等待
        WebDriverWait webDriverWait = new WebDriverWait(driver,30);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[starts-with(@id,'x-URS-iframe')]")));
//        定位iframe
        WebElement frame = driver.findElement(By.xpath("//*[starts-with(@id,'x-URS-iframe')]"));
//        将控制权转交给
        driver.switchTo().frame(frame);
        driver.findElement(By.name("email")).sendKeys("15764250110");
        driver.findElement(By.name("password")).sendKeys("57102388123");
        driver.findElement(By.id("dologin")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("ferrorhead")));
        String error = driver.findElement(By.className("ferrorhead")).getText();
        Assert.assertEquals(error,"帐号或密码错误");
    }


    @AfterMethod
    public void closedChrome() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
