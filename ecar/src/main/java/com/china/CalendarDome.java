package com.china;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class CalendarDome {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println(cal.getTime());
        LocalDateTime dateTime = LocalDateTime.now(); // gets the current date and time
        if(cal.getTime().after(new Date())){
            System.out.println("before");
        }else{
            System.out.println("after");
        }

    }
}
