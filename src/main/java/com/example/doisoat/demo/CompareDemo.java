package com.example.doisoat.demo;

import com.example.doisoat.ReadDataAtomi;
import com.example.doisoat.ReadImediaTxt;
import com.example.doisoat.model.TransEntity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompareDemo {
    public static void main(String[] args) throws IOException, ParseException {
        ReadImediaTxt imedias = new ReadImediaTxt();
        ReadDataAtomi atomi = new ReadDataAtomi();


        final String link1 = "C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\file25\\DownloadSoftpin20222608.tsv";
        final String link2 = "C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\file25\\Direct-Topup20222608.tsv";
        String TimeS = "25/08/2022 00:00:00";
        String TimeE = "25/08/2022 23:59:59";
        Map<String, TransEntity> mapTransImedia = imedias.readImedia(TimeS,TimeE,link1,link2);



        //Get File Atomi
        String linkAtomi = "C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\file25\\atmd_pg_20220826.tsv";
        String timeS = "2022-08-25 00:00:00";
        String timeE = "2022-08-25 23:59:59";
        Map<String,TransEntity> mapTransAtomi =  atomi.readFileAtomi(timeS,timeE,linkAtomi);


        System.out.println("-----------Compare-----------------");
        //Check Atomi - > Imedia
        List<String> uniqueListAtomi = new ArrayList<>();
        List<String> uniqueAtomiStart = new ArrayList<>();
        for (String keyAtomi :  mapTransAtomi.keySet()) {
            if (mapTransImedia.keySet().contains(keyAtomi)) {
              continue;
            } else if(mapTransAtomi.get(keyAtomi).getTRANG_THAI().equals("EXT-0000")) {
                uniqueListAtomi.add(keyAtomi);
            }else {
                uniqueListAtomi.add(keyAtomi);
            }
        }

        System.out.println("Atomi tổng: "+mapTransImedia.size()+ " Atomi Lệch : " + uniqueListAtomi.size());
        BufferedWriter f_writer = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\file24\\doisoat.txt"));
        for (String key: uniqueListAtomi) {
            try {
                if(mapTransAtomi.get(key).getTRANG_THAI().equals("EXT-0000")){
                    f_writer.write( "**" + String.valueOf(mapTransAtomi.get(key)+"=>Cần xem xét lại"));
                    f_writer.newLine();
                }else {
                    f_writer.write(String.valueOf(mapTransAtomi.get(key)+"=>Thất bại"));
                    f_writer.newLine();
                }
            }catch (IOException e){
                System.out.println(e);
            }

        }
        f_writer.close();


        //Check  Imedia- > Atomi
        List<String> uniqueListImedia = new ArrayList<>();

        for (String keyImedia :  mapTransImedia.keySet()) {
            if (mapTransAtomi.keySet().contains(keyImedia)) {
                continue;
            } else if(mapTransImedia.get(keyImedia).getTRANG_THAI().equals("Thanh Cong")){
                uniqueListImedia.add(keyImedia);
            }
        }


        System.out.println("Imedia tổng: "+mapTransImedia.size()+" Imedia Lệch : " + uniqueListImedia.size() + uniqueListImedia.toString());
        BufferedWriter writerImedia = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\file24\\doiSoatImedia.txt"));

        for (String key: uniqueListImedia) {
            System.out.println(mapTransImedia.get(key));
            try {
                if(mapTransImedia.get(key).getTRANG_THAI().equals("Thanh Cong")){
                    writerImedia.write( "**" + String.valueOf(mapTransImedia.get(key)+"=>Cần xem xét lại"));
                    writerImedia.newLine();
                }
            }catch (IOException e){
                System.out.println(e);
            }
        }
        writerImedia.close();

    }
}
