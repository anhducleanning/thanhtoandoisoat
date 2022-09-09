package com.example.doisoat.demo;

import com.example.doisoat.until.GlobalConfig;
import com.example.doisoat.until.Until;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {

    public static void main(String[] args){
        String timeDate = Until.convertTimeImedia( GlobalConfig.DATE_FORMAT_IMEDIA,GlobalConfig.DATE_FORMAT_ATOMI,"25/08/2022 00:00:31");
        System.out.println(timeDate);

    }
}

