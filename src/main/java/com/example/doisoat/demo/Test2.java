package com.example.doisoat.demo;
import com.example.doisoat.model.TransEntity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Test2 {




    public static void main(String[] args) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter dateFormatterNew = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = "25/08/2022 00:00:31";
        LocalDateTime ldateTime = LocalDateTime.parse(date, dateFormatter);
        System.out.println(dateFormatterNew.format(ldateTime));

    }

}

