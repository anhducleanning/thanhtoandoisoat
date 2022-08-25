package com.example.doisoat;

import com.example.doisoat.model.TransEntity;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CompareIMEDIA_ATOMI {


    public static void main(String[] args) throws IOException, ParseException {
            DemoReadImedia imedias = new DemoReadImedia();
            DemoReadAtomi atomi = new DemoReadAtomi();

        final String excelFilePath = "C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\imediaTopupTest.xls";
        String TimeS = "24/08/2022 00:00:46";
        String TimeE = "24/08/2022 23:59:59";

        //Get file Imedia Topup
        Map<String, TransEntity> mapTransImediaTopup = imedias.readInmedia(excelFilePath,TimeS,TimeE);
//        for (String key : mapTransImedia.keySet()) {
//            System.out.println("key Imedia: "+key);
//        }


        //Get file Imedia BuyCard
        final String path = "C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\imediaBuyCardTest.xls";
        Map<String, TransEntity> mapTransImediaBuyCard = imedias.readInmedia(path,TimeS,TimeE);
//        for (String key : mapTransImedia.keySet()) {
//            System.out.println("key Imedia: "+key);
//        }

        //Get File Atomi
        String link = "C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\testAtomi.tsv";
        String timeS = "2022-08-24 00:00:33";
        String timeE = "2022-08-24 23:59:00";
        Map<String,TransEntity> mapTransAtomi =  atomi.readFileAtomi(link,timeS,timeE);
//        for (String key : mapTransAtomi.keySet()) {
//            System.out.println("key Atomi: "+key);
//        }


        //temp Atomi
        Map<String,TransEntity> tempAtomiTopUp = new LinkedHashMap<>();
        tempAtomiTopUp.putAll(mapTransAtomi);

        //temp Imedia
        Map<String,TransEntity> tempImedia = new LinkedHashMap<>();
        tempImedia.putAll(mapTransImediaTopup);
        tempImedia.putAll(mapTransImediaBuyCard);

        //Clone Imedia
        Map<String,TransEntity> temResult = new LinkedHashMap<>();
        temResult.putAll(tempImedia);

        //Check
//        for (String keyImedia :  tempImedia.keySet()) {
//            for (String keyAtomi : mapTransAtomi.keySet()) {
//                if (keyImedia.equals(keyAtomi)){
//                    temResult.remove(keyImedia);
//                    break;
//                }
//            }
//        }

        for (String key : temResult.keySet()) {
            System.out.println("key Imedia: " + key);
        }

    }
}
