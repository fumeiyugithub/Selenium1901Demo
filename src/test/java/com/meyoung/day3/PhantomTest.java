package com.meyoung.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class PhantomTest {
    @Test
    public void pjsTest() throws InterruptedException {
        System.setProperty("phantomjs.binary.path","D:\\IdeaProjects\\seleniumDemo1701\\drivers\\phantomjs.exe");
        PhantomJSDriver phantomJSDriver = new PhantomJSDriver();
        phantomJSDriver.get("https://www.baidu.com");
        phantomJSDriver.findElement(By.id("kw")).sendKeys("你哈");
        Thread.sleep(3000);

        System.out.println("或取得title是："+phantomJSDriver.getTitle());
        phantomJSDriver.quit();
    }
}
