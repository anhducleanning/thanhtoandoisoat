package com.example.doisoat;

import com.example.doisoat.ReadDataAtomi;
import com.example.doisoat.ReadImediaTxt;
import com.example.doisoat.model.SessionEntity;
import com.example.doisoat.model.TransEntity;
import com.example.doisoat.service.SessionSerivce;
import com.example.doisoat.service.impl.ImportDataServiceImpl;
import com.example.doisoat.service.impl.SessionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class CompareDemo {
    @Autowired
    SessionSerivce service;
    public static void main(String[] args) throws IOException, ParseException {
        ReadImediaTxt imedias = new ReadImediaTxt();
        ReadDataAtomi atomi = new ReadDataAtomi();
        Timestamp ts = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")));


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
        f_writer.write("Atomi tổng: "+mapTransImedia.size()+ " Atomi Lệch : " + uniqueListAtomi.size());
        f_writer.newLine();
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


        //Check  Imedia- > Atomi
        List<String> uniqueListImedia = new ArrayList<>();

        for (String keyImedia :  mapTransImedia.keySet()) {
            if (mapTransAtomi.keySet().contains(keyImedia)) {
                continue;
            } else if(mapTransImedia.get(keyImedia).getTRANG_THAI().equals("Thanh Cong")){
                uniqueListImedia.add(keyImedia);
            }
        }


        System.out.println("Imedia tổng: "+mapTransImedia.size()+" Imedia Lệch : " + uniqueListImedia.size() );
        f_writer.write("Imedia tổng: "+mapTransImedia.size()+" Imedia Lệch : " + uniqueListImedia.size() );
        f_writer.newLine();
        for (String key: uniqueListImedia) {
            System.out.println(mapTransImedia.get(key));
            try {
                if(mapTransImedia.get(key).getTRANG_THAI().equals("Thanh Cong")){
                    f_writer.write( "**" + String.valueOf(mapTransImedia.get(key)+"=>Cần xem xét lại"));
                    f_writer.newLine();
                }
            }catch (IOException e){
                System.out.println(e);
            }
        }
        f_writer.close();
    }
}
