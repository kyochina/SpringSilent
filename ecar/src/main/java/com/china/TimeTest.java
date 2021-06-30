package com.china;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeTest {
    public static void main(String[] args) throws ParseException {
        /*DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        LocalDateTime tranData = LocalDateTime.parse("2021-06-01 17:16:02.0", df);*/

        SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sf.parse("2021/06/27 18:59:53");


        String busiDate = sf1.format(date);  //交易日期

        /*DateTimeFormatter sf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String busiDate = sf.format(verifyVo.getTranDate());  //交易日期

        DateTimeFormatter sf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String busiDate = sf.format(LocalDateTime.now());*/
        System.out.println(busiDate);
    }
}
