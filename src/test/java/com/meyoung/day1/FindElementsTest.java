package com.meyoung.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\chromedriver.exe");
         driver = new ChromeDriver();
    }
    /**
     * 打开百度首页
     * 定位搜索文本框
     */
    @Test
    public void  findTest(){
      driver.get("https://www.baidu.com");
//      id
      WebElement keyField = driver.findElement(By.id("kw"));
//      name
      WebElement keyField2 = driver.findElement(By.name("wd"));
//      className
      WebElement a =driver.findElement(By.className("soutu-btn"));
//      linkText
      WebElement b = driver.findElement(By.linkText("贴吧"));
//      partialLinkText
      WebElement c = driver.findElement(By.partialLinkText("贴"));
//      tagName 极少用到
       List<WebElement> d = driver.findElements(By.tagName("a"));
       System.out.println(d.size());
//       通过XPath来定位元素
        WebElement e = driver.findElement(By.xpath(".//*[@id='kw']"));
//      通过cssSelector
        WebElement f = driver.findElement(By.cssSelector("#lg"));
//      通过XPath来定位一个列表
        List<WebElement>  list1 = driver.findElements(By.xpath(".//*[@id='u1']/a"));
        System.out.println(list1.size()+"第一个文本是："+list1.get(0).getText());
    }
    @AfterMethod
    public void closedChrome(){
        driver.quit();
    }
}
