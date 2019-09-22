package com.example.utils;



import org.apache.tomcat.util.codec.binary.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SEQUtil {
    private static final String HH="OO";
    public static String getSEQNum24(){
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        System.out.println(HH+time);
        return HH+time;
    }

}
