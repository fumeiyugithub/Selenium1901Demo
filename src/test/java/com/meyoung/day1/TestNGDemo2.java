package com.meyoung.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo2 {
    //校验 a == a;
    @Test
    public  void assertEqualTest(){
        String a="asdf1111";
        String b="asdf";
//        if(a.equals(b)){
//            System.out.println("正确");
//        }else{
//            System.out.println("错误");
//        }
//        a 实际值  b预期值
//        Assert.assertEquals(a,b,"a不等于b");
//        assert校验之后如果错误代码不会再往下执行  所以assert之后不要放别的操作
        Assert.assertEquals(a,b);
    }
    @Test
    public void assertNotEqualTest(){
        int a = 2;
        int b = 1;
        Assert.assertNotEquals(a,b);
    }
    @Test
    public  void assertNullTest(){//校验为空
//       String a=null;
       String a="";
       Assert.assertNull(a);
    }
    @Test
    public  void assertNotNullTest(){//校验不为空
//       String a=null;
        String a="";
        Assert.assertNotNull(a);
    }
}
