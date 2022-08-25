package com.example.doisoat;

import com.example.doisoat.model.AtomiEntity;
import com.example.doisoat.model.TransEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class DemoReadAtomi {
    public static void main(String[] args) throws IOException, ParseException {

        String link = "C:\\Users\\saotr\\Desktop\\fileDoiSoat\\atmd_pg_2022-08-24.tsv";
        String timeS = "2022-08-24 00:00:33";
        String timeE = "2022-08-24 23:59:59";




        Map<String,TransEntity> map = new LinkedHashMap <String, TransEntity>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(link))) {
            List<String>  lists = br.lines().skip(1).collect(Collectors.toList());
            for (String list: lists) {
                String[] split = list.split("\t");
                TransEntity atomiTrans = new TransEntity(split[0],split[1],split[3],split[6]);
                if(CompareBetweenDateTime(timeS,timeE,atomiTrans.getDATETIME_LOG())){
                    map.put(split[1], atomiTrans);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String key : map.keySet()) {
            TransEntity value = map.get(key);
            System.out.println(key + " = " + value);
        }

    }
    public static boolean CompareBetweenDateTime(String timeStart, String timeEnd, String timeRow) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date timeS = sdf.parse(timeStart);
        Date timeE= sdf.parse(timeEnd);
        Date timeR = sdf.parse(timeRow);

        // compareTo
        int diffStart = timeS.compareTo(timeR);
        int diffEnd = timeE.compareTo(timeR);

        if(diffStart <0 &&diffEnd >0) {
            return true;
        } else if(diffStart == 0 || diffEnd ==0) {
            return true;
        }else {
            return false;
        }
}
}
