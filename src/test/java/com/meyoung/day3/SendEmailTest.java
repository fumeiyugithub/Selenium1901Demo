package com.meyoung.day3;

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

public class SendEmailTest {

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
     * 1.登录邮箱
     * 2.发送邮件
     */
    @Test
    public void sendEmailTest(){
        //        显示等待
        WebDriverWait webDriverWait = new WebDriverWait(driver,30);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[starts-with(@id,'x-URS-iframe')]")));
//        定位iframe
        WebElement frame = driver.findElement(By.xpath("//*[starts-with(@id,'x-URS-iframe')]"));
//        将控制权转交给
        driver.switchTo().frame(frame);
        driver.findElement(By.name("email")).sendKeys("15764250110");
        driver.findElement(By.name("password")).sendKeys("57102388");
        driver.findElement(By.id("dologin")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='_mail_component_24_24']/span[2]")));
        driver.findElement(By.xpath(".//*[@id='_mail_component_24_24']/span[2]")).click();
//        邮件接收人
        driver.findElement(By.xpath(".//*[starts-with(@id,'_mail_emailinput')]/input")).sendKeys("15764250110@163.com");
//        邮件标题
        driver.findElement(By.xpath("//input[contains(@id,'subjectInput')]")).sendKeys("自动化测试发邮件");
//        上传文件
        driver.findElement(By.xpath(".//*[@title='一次可发送2000张照片，600首MP3，一部高清电影']/input")).sendKeys("C:\\Users\\ah\\Desktop\\500d1302bb089.jpg");
//        转交控制权
        WebElement iframe = driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(iframe);
//        输入发送的内容
        driver.findElement(By.xpath("/html/body")).sendKeys("自动化测试练习发带有附件的邮件！");
//        控制权转交
        driver.switchTo().defaultContent();
//        点击发送按钮
        driver.findElement(By.xpath(".//*[text()='发送']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='发送成功']")));
        Boolean result = driver.findElement(By.xpath("//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(result);
    }

    @AfterMethod
    public void closedChrome() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
