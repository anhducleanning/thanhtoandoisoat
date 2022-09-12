package com.example.doisoat;

import com.example.doisoat.model.TransEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ReadImediaTxt {
    public static void main(String[] args) {
        String link1 = "C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\file25\\DownloadSoftpin20222608.tsv";
        String link2 = "C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\file25\\Direct-Topup20222608.tsv";
        String timeS = "25/08/2022 00:00:00";
        String timeE = "25/08/2022 23:59:59";



        Map<String, TransEntity> map = readImedia(timeS, timeE,link1,link2);;
        Set<String> set = map.keySet();
        for (String key : set) {
            System.out.println(key + " " + map.get(key));
        };


    }

    public static Map<String, TransEntity> readImedia(String timeS, String timeE, String pathFile,String path) {
        Map<String, TransEntity> map = new HashMap<>();
        List<String> link = new ArrayList<>();
        link.add(pathFile);
        link.add(path);

        for (int i = 0; i <=1 ; i++) {
            String serviceCode = i==1?"topup":"buycard";
            try (BufferedReader br = Files.newBufferedReader(Paths.get(link.get(i)))) {
                List<String> lists = br.lines().skip(7).collect(Collectors.toList());
                for (String list : lists) {
                    String[] split = list.split("\t");
                    TransEntity atomiTrans = new TransEntity(split[0], split(split[5]), split[1], split[7],split[3],serviceCode);
                    if (CompareBetweenDateTime(timeS, timeE, atomiTrans.getDATETIME_LOG())) {
                        map.put(split(split[5]), atomiTrans);
                    }
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }

        return map;
    }

//    public static Map<String, TransEntity> readFileImedia(String timeS, String timeE, String pathFile) {
//        Map<String, TransEntity> map = new HashMap<>();
//        try (BufferedReader br = Files.newBufferedReader(Paths.get(pathFile))) {
//            List<String> lists = br.lines().skip(7).collect(Collectors.toList());
//            for (String list : lists) {
//                String[] split = list.split("\t");
//                TransEntity atomiTrans = new TransEntity(split[0], split(split[5]), split[1], split[7]);
//                if (CompareBetweenDateTime(timeS, timeE, atomiTrans.getDATETIME_LOG())) {
//
//                    map.put(split(split[5]), atomiTrans);
//                }
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//
//        return map;
//    }

    public static boolean CompareBetweenDateTime(String timeStart, String timeEnd, String timeRow) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date timeS = sdf.parse(timeStart);
        Date timeE = sdf.parse(timeEnd);
        Date timeR = sdf.parse(timeRow);

        // compareTo
        int diffStart = timeS.compareTo(timeR);
        int diffEnd = timeE.compareTo(timeR);

        if (diffStart < 0 && diffEnd > 0) {
            return true;
        } else if (diffStart == 0 || diffEnd == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String split(String text) {
        if (text.trim().startsWith("'")) {
            String[] part = text.split("'");
            String part1 = part[1];
            return part1;
        }
        return text;
    }
}
