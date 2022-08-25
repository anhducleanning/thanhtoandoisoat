package com.example.doisoat.demo;

import com.example.doisoat.DemoReadAtomi;
import com.example.doisoat.DemoReadImedia;
import com.example.doisoat.model.TransEntity;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class InventoryRow {
    public static void main(String[] args) throws IOException, ParseException {
        DemoReadImedia imedias = new DemoReadImedia();
        DemoReadAtomi atomi = new DemoReadAtomi();

        final String excelFilePath = "C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\topup.xls";
        String TimeS = "23/08/2022 00:00:46";
        String TimeE = "23/08/2022 23:59:59";

        //Get file Imedia Topup
        Map<String, TransEntity> mapTransImediaTopup = imedias.readInmedia(excelFilePath,TimeS,TimeE);
//        for (String key : mapTransImedia.keySet()) {
//            System.out.println("key Imedia: "+key);
//        }


        //Get file Imedia BuyCard
        final String path = "C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\buycard.xls";
        Map<String, TransEntity> mapTransImediaBuyCard = imedias.readInmedia(path,TimeS,TimeE);
//        for (String key : mapTransImedia.keySet()) {
//            System.out.println("key Imedia: "+key);
//        }

        //Get File Atomi
        String link = "C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\atmd_pg_2022-08-24.tsv";
        String timeS = "2022-08-23 00:00:33";
        String timeE = "2022-08-23 23:59:00";

        Map<String,TransEntity> mapTransAtomi =  atomi.readFileAtomi(link,timeS,timeE);
//        for (String key : mapTransAtomi.keySet()) {
//            System.out.println("key Atomi: "+key);
//        }


        Map<String,TransEntity> tempAtomi = new HashMap<>();
        tempAtomi.putAll(mapTransAtomi);

        //Check topup
        for (String keyAtomi :  mapTransAtomi.keySet()) {
            for (String keyImedia : mapTransImediaBuyCard.keySet()) {
                if (keyAtomi.equals(keyImedia)){
                    tempAtomi.remove(keyAtomi);
                }
            }
        }

        //Check Buy Card
//        Map<String,TransEntity> tempAtomiBuyCard = new HashMap<>();
//        tempAtomiBuyCard.putAll(tempAtomiTopUp);
//        for (String keyAtomi :  tempAtomiBuyCard.keySet()) {
//            for (String keyImedia : mapTransImediaBuyCard.keySet()) {
//                if (keyAtomi.equals(keyImedia)){
//                    tempAtomiBuyCard.remove(keyAtomi);
//                }
//            }
//        }

        for (String key : tempAtomi.keySet()) {
            System.out.println("key Atomi: " + key);
        }



    }
}
