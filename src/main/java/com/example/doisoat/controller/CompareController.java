package com.example.doisoat.controller;

import com.example.doisoat.ReadDataAtomi;
import com.example.doisoat.ReadImediaTxt;
import com.example.doisoat.model.*;
import com.example.doisoat.reponsitory.ImportDataDetailRepository;
import com.example.doisoat.service.CompareDataSerivce;
import com.example.doisoat.service.ImportDataDetailService;
import com.example.doisoat.service.ImportDataSerivce;
import com.example.doisoat.service.SessionSerivce;
import com.example.doisoat.service.impl.SessionServiceImpl;
import com.example.doisoat.until.GlobalConfig;
import com.example.doisoat.until.Until;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@RestController
@Slf4j
public class CompareController {
    @Autowired
    SessionSerivce sessionSerivce;

    @Autowired
    CompareDataSerivce compareDataSerivce;

    @Autowired
    ImportDataSerivce importDataSerivce;

    @Autowired
    ImportDataDetailService detailService;

   @GetMapping("/compare")
    public void compare() throws IOException {
       ReadImediaTxt imedias = new ReadImediaTxt();
       ReadDataAtomi atomi = new ReadDataAtomi();
       int sessionId = 0;
       int idImport =0;
       Timestamp ts = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")));
       try {
           SessionEntity session = new SessionEntity();
           //Create Session
           session.setPeriodDate("Theo ngày");
           session.setStatus((byte) 1);
           session.setSystemId1(GlobalConfig.SYS1_ATOMI);
           session.setSystemId2(GlobalConfig.SYS1_IMEDIA);
           sessionSerivce.create(session);
           sessionId = session.getId();
           log.info("id session - {} ", sessionId);
       }catch (Exception ex){
           log.error("Message error - {}", ex.getMessage());
       }


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

        try {
            //Create ImportData
            ImportDataEntity data = new ImportDataEntity();
            Date date = new Date(System.currentTimeMillis());
            data.setImportType(GlobalConfig.FILE);
            data.setImportCode("CODE"+Math.random());
            data.setSystemCode("SYSTEMCODE"+Math.random());
            data.setNumberOfTotal(mapTransAtomi.size());
            data.setNumberOfSuccess(0000000000);
            data.setNumberOfFail(1);
            data.setImportBy("Anh Duc");
            data.setPeriodDate(String.valueOf(date));
            data.setStatus(GlobalConfig.FILE_WORK);
            data.setPartnerSystemId(GlobalConfig.PARTNER_ATOMI);
            data.setSessionId(sessionId);
            data.setEvidenceFile("File chứng cớ có thể mã hoá");
            importDataSerivce.createImportData(data);
            log.info("id ImportData - {} ", data.getImportId());
            idImport = data.getImportId();
        }catch (Exception e){
            e.printStackTrace();
        }


        //Save Import Data detail
//        List<ImportDataDetailEntity> listDataImedia = saveInListData((HashMap<String, TransEntity>) mapTransImedia,idImport);
//        detailService.create(listDataImedia);

//       List<ImportDataDetailEntity> listDataAtomi = saveInListData((HashMap<String, TransEntity>) mapTransAtomi,idImport);
//       detailService.create(listDataAtomi);



       System.out.println("-----------Compare-----------------");
       //Check Atomi - > Imedia
       List<String> uniqueListAtomi = new ArrayList<>();
       for (String keyAtomi :  mapTransAtomi.keySet()) {
           if (mapTransImedia.keySet().contains(keyAtomi)) {
               continue;
           } else if(mapTransAtomi.get(keyAtomi).getTRANG_THAI().equals("EXT-0000")) {
               uniqueListAtomi.add(keyAtomi);
           }else {
               uniqueListAtomi.add(keyAtomi);
           }
       }

       System.out.println("Atomi tổng: "+mapTransAtomi.size()+ " Atomi Lệch : " + uniqueListAtomi.size());
       BufferedWriter f_writer = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\file24\\doisoat.txt"));
       f_writer.write("Atomi tổng: "+mapTransAtomi.size()+ " Atomi Lệch : " + uniqueListAtomi.size());
       f_writer.newLine();


       for (String key: uniqueListAtomi) {
           try {
               if(mapTransAtomi.get(key).getTRANG_THAI().equals("EXT-0000")){
                   compareDataAtomi(mapTransAtomi.get(key),sessionId);
                   f_writer.write( "**" + String.valueOf(mapTransAtomi.get(key)+"=>Cần xem xét lại"));
                   f_writer.newLine();
               }else {
                   compareDataAtomi(mapTransAtomi.get(key),sessionId);
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
                   compareDataImedia(mapTransImedia.get(key),sessionId);
                   f_writer.write( "**" + String.valueOf(mapTransImedia.get(key)+"=>Cần xem xét lại"));
                   f_writer.newLine();
               }
           }catch (IOException e){
               System.out.println(e);
           }
       }
       f_writer.close();
   }


    public void compareDataAtomi (TransEntity transEntity, int idSesion){
       Date date = new Date(System.currentTimeMillis());
       CompareDataEntity compareData = new CompareDataEntity();
       compareData.setCompareDate(date);
       compareData.setSys1Id(GlobalConfig.SYS1_ATOMI);
       compareData.setSys2Id(GlobalConfig.SYS1_IMEDIA);
       compareData.setSys1TransId(Long.valueOf(transEntity.getTRANS_ID()));
       compareData.setSys1TransTime(Timestamp.valueOf(transEntity.getDATETIME_LOG()));
       compareData.setSys1TransType(transEntity.getTRANG_THAI());
       int id = compareDataSerivce.saveCompareDataAtomi(compareData,idSesion);
   }

    public void compareDataImedia (TransEntity transEntity, int idSesion){
        Date date = new Date(System.currentTimeMillis());
        CompareDataEntity compareData = new CompareDataEntity();
        compareData.setCompareDate(date);
        compareData.setSys1Id(GlobalConfig.SYS1_ATOMI);
        compareData.setSys2Id(GlobalConfig.SYS1_IMEDIA);
        compareData.setSys2TransId(Long.valueOf(transEntity.getTRANS_ID()));
        compareData.setSys2TransTime(Timestamp.valueOf(Until.convertTimeImedia( GlobalConfig.DATE_FORMAT_IMEDIA,GlobalConfig.DATE_FORMAT_ATOMI,transEntity.getDATETIME_LOG())));
        compareData.setSys2TransStatus(transEntity.getTRANG_THAI());
        int id = compareDataSerivce.saveCompareDataImedia(compareData,idSesion);
    }




    public List<ImportDataDetailEntity> saveInListData(HashMap<String, TransEntity> trans, int idImport){
        try {
            //ImportDataDetaild
            ImportDataDetailEntity dataDetail = new ImportDataDetailEntity();
            List<ImportDataDetailEntity> list = new ArrayList<>();
            for (String keyAtm : trans.keySet()) {
                dataDetail.setImportDetailId(Long.valueOf(trans.get(keyAtm).getTRANS_ID()));
                dataDetail.setImportCode("IMPORTCODE"+Math.random());
                dataDetail.setRefId(trans.get(keyAtm).getTRANS_ID());
                dataDetail.setAmount(Integer.valueOf(trans.get(keyAtm).getAMOUNT().replaceAll(",","")));
                dataDetail.setTransName(trans.get(keyAtm).getSERVICE_CODE());
                dataDetail.setTransStatus(trans.get(keyAtm).getTRANG_THAI());
                dataDetail.setTransTime(trans.get(keyAtm).getDATETIME_LOG());
                dataDetail.setTransType("D");
                dataDetail.setImportId(idImport);
                list.add(dataDetail);

            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
