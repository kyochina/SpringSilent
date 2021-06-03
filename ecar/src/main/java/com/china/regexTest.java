package com.china;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexTest {
    public static void main(String[] args) {
        //String inputStr = "技术产业开发区银洲公寓R2栋，测试后面05单元，再来测试几号楼3号楼,接着测试2098幢，再来一个N栋";

        String inputStr = "0035楼技术产业开发区银洲公寓R2栋222333";

        //String regEx = "((\\d+)(单元|号楼)|(([a-z]|[A-Z])(\\d+))(幢|栋|期|区|号|楼)|(\\d+)(幢|栋|期|区|号|楼)|([a-z]|[A-Z])(幢|栋|期|区|楼))";
        String regEx = "(\\d+$)";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(inputStr);
        String outStr = m.replaceAll("");
        System.out.println(inputStr);
        System.out.println(outStr);

        //System.out.println("判断数字："+matchDecimal("-0.76"));
    }
    //去掉末尾是数字的字符串
    //技术产业开发区银洲公寓R2栋，测试后面05单元01102
    public static String checkLastNumb(String inputStr) {

        String regEx = "(\\d+$)";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(inputStr);
        String outStr = m.replaceAll("");
        System.out.println(outStr);
        return outStr;
    }
    //判断字符串为 数字（带小数点）
    public static boolean matchDecimal(String number) {
        boolean result = false;
        if (number!=null) {
            final String numberRegexp = "^[+-]?(0|([1-9]\\d*))(\\.\\d+)?$";
            try {
                Pattern pattern = Pattern.compile(numberRegexp);
                if (pattern.matcher(number.trim()).find()) {
                    result = true;
                }

            /*if (Pattern.matches(numberRegexp,number.trim())) {
                result = true;
            }*/
            } catch (Exception e) {
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }
}
