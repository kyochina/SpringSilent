package com.china.utils.Date;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

    /***
     * 判断字符串是否是yyyyMMdd格式
     * @param mes 字符串
     * @return boolean 是否是日期格式
     */
    public static boolean isDayFormat(String mes){
        String format = "([0-9]{4})(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])";
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(mes);
        if (matcher.matches()) {
            pattern = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})");
            matcher = pattern.matcher(mes);
            if (matcher.matches()) {
                int y = Integer.valueOf(matcher.group(1));
                int m = Integer.valueOf(matcher.group(2));
                int d = Integer.valueOf(matcher.group(3));
                if (d > 28) {
                    Calendar c = Calendar.getInstance();
                    c.set(y, m-1, 1); //每个月的最大天数
                    int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                    return (lastDay >= d);
                }
            }
            return true;
        }
        return false;

    }
    /***
     * 判断字符串是否是HHmmss格式
     * @param mes 字符串
     * @return boolean 是否是日期格式
     */
    public static boolean isTimeFormat(String mes){
        if(mes.length()!=6){
            return false;
        }
        String regex="^\\d+$";
        if(!mes.matches(regex)){
            return false;
        }
        int h;
        int m;
        int s;
        try {
            h=Integer.parseInt(mes.substring(0, 2));
            m=Integer.parseInt(mes.substring(2,4));
            s=Integer.parseInt(mes.substring(4, 6));
            if(h>23||h<0||m>59||m<0||s>59||s<0){
                return false;
            }
        } catch (Exception e) {
            System.out.println(mes+"不是HHmmss时间格式的字符串");
            return false;
        }
        return true;
    }
}
