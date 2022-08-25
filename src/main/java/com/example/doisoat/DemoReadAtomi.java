package com.example.doisoat;

import com.example.doisoat.model.AtomiEntity;
import com.example.doisoat.model.TransEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DemoReadAtomi {
    public static void main(String[] args) throws IOException, ParseException {
        String path = "C:\\Users\\Administrator\\Desktop\\fileExcel\\AtomiClone.tsv";
        String timeS = "2022-08-23 00:00:33";
        String timeE = "2022-08-23 23:59:00";


        Map<String,TransEntity> maps =  readFileAtomi(path,timeS,timeE);
        for (String key : maps.keySet()) {
            TransEntity value = maps.get(key);
            System.out.println(key + " = " + value);
        }

    }
    public static Map<String,TransEntity> readFileAtomi(String path, String timeS, String timeE) throws IOException, ParseException {

        int n =  ReadDataAtomi.countLine(path);
        TransEntity[] atomiTran = new TransEntity[n];

        List<TransEntity> list = new ArrayList<>();
        Map<String,TransEntity> map = new LinkedHashMap <String, TransEntity>();
        for (int i = 1; i < n; i++) {

            Scanner sc = new Scanner(Files.readAllLines(Paths.get(path)).get(i));
            String[] split = sc.nextLine().split("\t");
            atomiTran[i] = new TransEntity(split[0],split[1],split[3],split[6]);

            String datetime =atomiTran[i].getDATETIME_LOG();
            if(CompareBetweenDateTime(timeS,timeE,datetime)==true){
                map.put(split[1], atomiTran[i]);
            }
        }
        return map;
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
