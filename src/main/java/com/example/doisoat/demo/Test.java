package com.example.doisoat.demo;

import com.example.doisoat.until.GlobalConfig;
import com.example.doisoat.until.Until;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {

    public static void main(String[] args){
        String str = "50000";
        String[] arr = str.replaceAll(",","").split("[ ,]");
        String s = str.replaceAll(",","");
        System.out.println(s);

    }
}

