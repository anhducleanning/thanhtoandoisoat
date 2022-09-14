package com.example.doisoat;

import com.example.doisoat.model.TransEntity;
import com.example.doisoat.until.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
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
                    TransEntity atomiTrans = new TransEntity(split[0], Util.split(split[5]), split[1], split[7],Integer.valueOf(Util.splitComma(split[3])),serviceCode);
                    if (Util.compareBetweenDateTime(timeS, timeE, atomiTrans.getDATETIME_LOG())) {
                        map.put(Util.split(split[5]), atomiTrans);
                    }
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }

        return map;
    }




}
