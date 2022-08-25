package com.example.doisoat;

import com.example.doisoat.model.TransEntity;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class CompareIMEDIA_ATOMI {


    public static void main(String[] args) throws IOException, ParseException {
        ReadImedia imedias = new ReadImedia();
        ReadDataAtomi atomi = new ReadDataAtomi();


        final String excelFilePath = "C:\\Users\\saotr\\Desktop\\fileDoiSoat\\imediaTopupTest.xls";
        String TimeS = "24/08/2022 00:00:00";
        String TimeE = "24/08/2022 23:59:59";
        //Get file Imedia Topup
        Map<String, TransEntity> mapTransImediaTopup = imedias.readInmedia(excelFilePath,TimeS,TimeE);



        final String link = "C:\\Users\\saotr\\Desktop\\fileDoiSoat\\imediaBuyCardTest.xls";
        //Get file Imedia Topup
        Map<String, TransEntity> mapTransImediaBuyCard = imedias.readInmedia(link,TimeS,TimeE);


        Map<String, TransEntity> tenpImedia = new HashMap<>();
        tenpImedia.putAll(mapTransImediaTopup);
        tenpImedia.putAll(mapTransImediaBuyCard);

//        System.out.println("-----------Imedia-----------------");
//        for (String key : tenpImedia.keySet()) {
//            System.out.println("key Imedia: " + key);
//        }

        //Get File Atomi
        String linkAtomi = "C:\\Users\\saotr\\Desktop\\fileDoiSoat\\testAtomi.tsv";
        String timeS = "2022-08-24 00:00:33";
        String timeE = "2022-08-24 23:59:00";
        Map<String,TransEntity> mapTransAtomi =  atomi.readFileAtomi(timeS,timeE,linkAtomi);


//        System.out.println("-----------Atomi-----------------");
//        for (String key : mapTransAtomi.keySet()) {
//            System.out.println("key Imedia: " + key);
//        }

        System.out.println("-----------Compare-----------------");
        Map<String,TransEntity> tempAtomi = new HashMap<>();
        tempAtomi.putAll(mapTransAtomi);


        //Check
        List<String> lists = new ArrayList<>();
        for (String keyAtomi :  mapTransAtomi.keySet()) {
            for (String keyImedia : tenpImedia.keySet()) {
                if (keyAtomi.equals(keyImedia)){
                    lists.add(keyAtomi);
                    break;
                }
            }
        }

        System.out.println("Số lượng: " + tempAtomi.size());
        for (String list:lists) {
            System.out.println(list);
        }

    }

}
