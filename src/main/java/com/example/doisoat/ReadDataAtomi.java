package com.example.doisoat;

import com.example.doisoat.model.AtomiEntity;
import com.example.doisoat.model.TransEntity;
import com.example.doisoat.until.GlobalConfig;
import com.example.doisoat.until.Until;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ReadDataAtomi {
    public static void main(String[] args) throws IOException, ParseException {

        String link = "C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\file25\\atmd_pg_20220826.tsv";
        String timeS = "2022-08-25 00:00:00";
        String timeE = "2022-08-25 23:59:59";


        Map<String,TransEntity> maps = readFileAtomi(timeS,timeE,link);
        System.out.println(maps.get("1111111111111111").getTRANG_THAI());


    }


    public static Map<String,TransEntity> readFileAtomi(String timeS, String timeE, String link){
        Map<String,TransEntity> map = new LinkedHashMap<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(link))) {
            List<String>  lists = br.lines().skip(1).collect(Collectors.toList());
            for (String list: lists) {
                String[] split = list.split("\t");
                TransEntity atomiTrans = new TransEntity(split[0],split[1],split[3],split[2]);
                if(Until.CompareBetweenDateTime(timeS,timeE,atomiTrans.getDATETIME_LOG(),GlobalConfig.DATE_FORMAT_ATOMI)){
                    map.put(split[1], atomiTrans);
                }

            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

      return map;
    }

//    public static boolean CompareBetweenDateTime(String timeStart, String timeEnd, String timeRow) throws ParseException {
//
//        try {
//            if(timeRow==null||timeStart.equals("")){
//                return false;
//            }
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date timeS = sdf.parse(timeStart);
//            Date timeE= sdf.parse(timeEnd);
//            Date timeR = sdf.parse(timeRow);
//
//            // compareTo
//            int diffStart = timeS.compareTo(timeR);
//            int diffEnd = timeE.compareTo(timeR);
//
//            if(diffStart <0 &&diffEnd >0) {
//                return true;
//            } else if(diffStart == 0 || diffEnd ==0) {
//                return true;
//            }else {
//                return false;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return false;
//    }
}
