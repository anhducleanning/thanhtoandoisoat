package com.example.doisoat.demo;

import com.example.doisoat.model.TransEntity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class ReadDataTSV {
    public static void main(String[] args) throws FileNotFoundException {

        String link = "C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\atmd_pg_2022-08-24.tsv";
//        int n = countLine(link);
        List<String> lists = new ArrayList<>();
//        TransEntity[] atomiTran = new TransEntity[n];
        Map<String,TransEntity> map = new LinkedHashMap <String, TransEntity>();
        try (Scanner scanner = new Scanner(new File(link))) {
            while (scanner.hasNext()){
                lists.add(scanner.nextLine());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String list: lists) {
            String[] split = list.split("\t");
            TransEntity atomiTrans = new TransEntity(split[0],split[1],split[3],split[6]);
                map.put(split[1], atomiTrans);

        }


        for (String key : map.keySet()) {
            TransEntity value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
    public static int countLine(String path){
        Path pathFile = Paths.get(path);
        int lines = 0;

        try {
            lines = (int) Files.lines(pathFile).count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}