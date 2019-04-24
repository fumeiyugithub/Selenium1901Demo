package com.meyoung.day1;

import org.testng.annotations.*;

/**
 * Created by fumy on 2019/04/06
 */
public class TestNGDemo1 {
    @BeforeTest
    public void beforeTest01(){
        System.out.println("这个是@BeforeTest的注解,beforeTest01");
    }
    @BeforeMethod
    public  void beforeMethod01(){
        System.out.println("这个是@BeforeMethod的注解,beforeMethod01");
    }
    //标记方法或者一个类作为测试的一部分
    /*
     有多个case 按照方法名的ASCII码执行的  不建议两个case之间相关联
     */
     @Test
    public  void testCase1(){
         System.out.println("这个是@test的注解,case1");
     }
     @Test
    public void testCase2(){
         System.out.println("这个是@test的注解,case2");
     }
     @AfterMethod
    public  void afterMethod1(){
         System.out.println("这个是@AfterMethod的注解,afterMethod1");
     }
    @AfterTest
    public void afterTest1(){
        System.out.println("这个是@AfterTest的注解,afterTest1");
    }
}

