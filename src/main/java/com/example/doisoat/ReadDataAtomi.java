package com.example.doisoat;

import com.example.doisoat.model.AtomiEntity;
import com.example.doisoat.model.TransEntity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReadDataAtomi {
    public static void main(String[] args) throws IOException, ParseException {
        String path = "C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\atmd_pg_2022-08-24.tsv";
        String timeS = "2022-08-24 00:00:33";
        String timeE = "2022-08-24 8:59:59";


        Map<String,TransEntity> maps =  ReadFileAtomi(path,timeS,timeE);
        for (String key : maps.keySet()) {
            TransEntity value = maps.get(key);
            System.out.println(key + " = " + value);
        }
    }
    public static Map<String,TransEntity> ReadFileAtomi(String path,String timeS, String timeE) throws IOException, ParseException {


        int n =  ReadDataAtomi.countLine(path);
        TransEntity[] atomiTran = new TransEntity[n];

        List<TransEntity> list = new ArrayList<>();
        Map<String,TransEntity> map = new LinkedHashMap <String, TransEntity>();

//        while (sc.hasNextLine()) {
//            String[] split = sc.nextLine().split("\t");
//            atomiEntity[0] = new AtomiEntity(split[0], split[1], split[2], split[3], split[4], split[5],
//                    split[6], split[7], split[8], split[9], split[10], split[11], split[12]);
//
//            System.out.println(atomiEntity[0].getTID() + "-" + atomiEntity[0].getSERVICE_CODE());
//            System.out.println(atomiEntity[0].toString());
//        }


        for (int i = 1; i < n; i++) {

            Scanner sc = new Scanner(Files.readAllLines(Paths.get(path)).get(i));
            String[] split = sc.nextLine().split("\t");
            atomiTran[i] = new TransEntity(split[0],split[1],split[3],split[6]);

            String datetime =atomiTran[i].getDATETIME_LOG();
            if(CompareBetweenDateTime(timeS,timeE,datetime)==true){
                map.put(split[1], atomiTran[i]);
            }
        }
        System.out.println("Tổng: " + map.size());
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
