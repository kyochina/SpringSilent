package com.china;

public class SubstringTest {
    public static void main(String[] args) {
        /*String outputStr = "长沙市天心区高云路77号龙湾国际三期测试小区 ";
        //如果返回地址是以小区为结尾的，则去掉小区两个字
        if(outputStr.trim().endsWith("小区")){
            outputStr=outputStr.substring(0,outputStr.indexOf("小区"));
        }
        System.out.println(outputStr);*/
        String str= "0小区为空";
        System.out.println(str.substring(0,1));
        System.out.println(str.substring(1));
    }
}
