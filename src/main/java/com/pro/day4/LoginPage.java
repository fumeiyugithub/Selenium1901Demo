package com.pro.day4;

import org.openqa.selenium.By;
//在loginTest文件中练习这个了
public class LoginPage {//集中管理元素对象

//    定位输入框
    public static By loginName = By.name("email");
//    定位密码输入
    public  static By password = By.name("password");
//    定位登陆按钮
    public static By loginButton =By.id("dologin");
}
