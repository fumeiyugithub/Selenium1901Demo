package com.meyoung.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {

    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.163.com/");
    }
    /**
     *
     *163邮箱注册
     */
    @Test
    public void  registerTest(){
        //        显示等待
        WebDriverWait webDriverWait = new WebDriverWait(driver,30);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[starts-with(@id,'x-URS-iframe')]")));
//        定位iframe
        WebElement frame = driver.findElement(By.xpath("//*[starts-with(@id,'x-URS-iframe')]"));
      driver.switchTo().frame(frame);

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("changepage")));
//     点击“注册”按钮
       driver.findElement(By.id("changepage")).click();
       String handle1 =driver.getWindowHandle();
//     driver切换新的handle值   到新的页面
         for(String handles:driver.getWindowHandles()){
             if(handles.equals(handle1)){
                 continue;
             }else{
                 driver.switchTo().window(handles);
             }
         }
//     时间戳13位
     String time = String.valueOf(System.currentTimeMillis());
//   输入邮箱名
     driver.findElement(By.id("nameIpt")).sendKeys("qaz123456");
//     输入密码
     driver.findElement(By.id("mainPwdIpt")).sendKeys("qaz123123");
//     再次输入密码
     driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("qaz123123");
//     验证码验证解决方法：1.找开发要个万能验证码   2.或者把验证码功能先注释掉   3.或者解析图片（这个成本太大不行）
     driver.findElement(By.id("vcodeIpt")).sendKeys("123456");
//     填写手机号码
     driver.findElement(By.id("mainMobileIpt")).sendKeys("12345678901");
//     点击注册
        driver.findElement(By.id("mainRegA")).click();


        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='m_vcode']/span")));
//     获取报错信息
     String  error = driver.findElement(By.xpath(".//*[@id='m_vcode']/span")).getText();
     Assert.assertEquals(error,"  验证码不正确，请重新填写");
    }
    @AfterMethod
    public void closedChrome(){
        driver.quit();
    }
}
