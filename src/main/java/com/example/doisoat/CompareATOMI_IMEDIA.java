package com.example.doisoat;

import com.example.doisoat.model.TransEntity;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class CompareATOMI_IMEDIA {


    public static void main(String[] args) throws IOException, ParseException {
            ReadImedia imedias = new ReadImedia();
            ReadDataAtomi atomi = new ReadDataAtomi();

        final String excelFilePath = "C:\\Users\\saotr\\Desktop\\fileDoiSoat\\topup1.xls";
        String TimeS = "24/08/2022 00:00:00";
        String TimeE = "24/08/2022 23:59:59";
        //Get file Imedia Topup
        Map<String, TransEntity> mapTransImediaTopup = imedias.readInmedia(excelFilePath,TimeS,TimeE);


        //Get File Atomi
        String link = "C:\\Users\\saotr\\Desktop\\fileDoiSoat\\atmd_pg_2022-08-24.tsv";
        String timeS = "2022-08-24 00:00:33";
        String timeE = "2022-08-24 23:59:00";

        Map<String,TransEntity> mapTransAtomi =  atomi.readFileAtomi(timeS,timeE,link);


        Map<String,TransEntity> tempAtomiTopUp = new HashMap<>();
        tempAtomiTopUp.putAll(mapTransAtomi);


        //Check
        for (String keyAtomi :  mapTransAtomi.keySet()) {
            for (String keyImedia : mapTransImediaTopup.keySet()) {
                if (keyAtomi.equals(keyImedia)){
                    tempAtomiTopUp.remove(keyAtomi);
                }
            }
        }

        for (String key : tempAtomiTopUp.keySet()) {
            System.out.println("key Atomi: " + key);
        }

    }
}
