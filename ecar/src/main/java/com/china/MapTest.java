package com.china;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Long begin = System.currentTimeMillis();
        String resblockName = "韵园一号";
        Map<String,String> map = new HashMap<String,String>();
        map.put("1","壹");
        map.put("2","贰");
        map.put("3","叁");
        map.put("4","肆");
        map.put("5","伍");
        map.put("6","陆");
        map.put("7","柒");
        map.put("8","捌");
        map.put("9","玖");
        map.put("一","壹");
        map.put("二","贰");
        map.put("三","叁");
        map.put("四","肆");
        map.put("五","伍");
        map.put("六","陆");
        map.put("七","柒");
        map.put("八","捌");
        map.put("九","玖");

        String result = "";

        for(char a:resblockName.toCharArray()){
            if(map.containsKey(String.valueOf(a))){
                result+=map.get(String.valueOf(a));
            }else{
                result+=a;
            }
        }
        System.out.println("结果："+result);
        Long end = System.currentTimeMillis();
        System.out.println(end-begin);  //2毫秒   无视
    }
}
