package com.example.doisoat.service.impl;

import com.example.doisoat.ReadDataAtomi;
import com.example.doisoat.ReadImediaTxt;
import com.example.doisoat.common.until.Constant;
import com.example.doisoat.model.*;
import com.example.doisoat.reponsitory.CompareResponsitory;
import com.example.doisoat.service.*;
import com.example.doisoat.common.until.GlobalConfig;
import com.example.doisoat.common.until.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CompareDataSerivceImpl implements CompareDataSerivce {

    @Autowired
    private CompareResponsitory compareResponsitory;

    @Autowired
    SessionSerivce sessionSerivce;

    @Autowired
    ImportDataSerivce importDataSerivce;

    @Autowired
    ImportDataDetailService detailService;

    @Autowired
    CompareDataSummarySerivce dataSummarySerivce;




    @Override
    @Transactional
    public List<TransEntity> compare() throws IOException {
        ReadImediaTxt imedias = new ReadImediaTxt();
        ReadDataAtomi atomi = new ReadDataAtomi();
        int sessionId = 0;
        int idImport =0;
        int totalAtomi = 0;
        int totalImedia = 0;
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
            throw new RuntimeException(ex.getMessage());
        }


        final String link1 = "C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\file25\\DownloadSoftpin20222608.tsv";
        final String link2 = "C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\file25\\Direct-Topup20222608.tsv";
        String TimeS = "25/08/2022 00:00:00";
        String TimeE = "25/08/2022 23:59:59";
        Map<String, TransEntity> mapTransImedia = imedias.readImedia(TimeS,TimeE,link1,link2);
        totalImedia = mapTransImedia.size();

        //Get File Atomi
        String linkAtomi = "C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\file25\\atmd_pg_20220826.tsv";
        String timeS = "2022-08-25 00:00:00";
        String timeE = "2022-08-25 23:59:59";
        Map<String,TransEntity> mapTransAtomi =  atomi.readFileAtomi(timeS,timeE,linkAtomi);
        totalAtomi = mapTransAtomi.size();
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
            idImport = data.getImportId();
            log.info("id ImportData - {} ", data.getImportId());

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }


        //Save Import Data detail
//        detailService.create((HashMap<String, TransEntity>) mapTransImedia,idImport);
//        detailService.create((HashMap<String, TransEntity>) mapTransAtomi,idImport);


        System.out.println("-----------Compare-----------------");
        //Check Atomi - > Imedia
        List<String> uniqueListAtomi = new ArrayList<>();

        int countAtomi = compareAndAdd(mapTransAtomi,mapTransImedia,uniqueListAtomi,Constant.Status.STATUS_SUCCES_ATOMI);


        System.out.println("Tổng tiền Atomi: "  + countAtomi);
        System.out.println("Atomi tổng: "+totalAtomi+ " Atomi Lệch : " + uniqueListAtomi.size());
        BufferedWriter f_writer = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\file24\\doisoat.txt"));
        f_writer.write("Atomi tổng: "+totalAtomi+ " Atomi Lệch : " + uniqueListAtomi.size());
        f_writer.newLine();

        //Writer file and add db after compare atomi
        writeFileAtomi(uniqueListAtomi,f_writer,mapTransAtomi,sessionId);


        //Check  Imedia- > Atomi
        List<String> uniqueListImedia = new ArrayList<>();
        int countImedia = compareAndAdd(mapTransImedia,mapTransAtomi,uniqueListImedia, Constant.Status.STATUS_SUCCES_IMEDIA);


        System.out.println("Tổng tiền Imedia: " + countImedia);
        System.out.println("Imedia tổng: "+totalImedia+" Imedia Lệch : " + uniqueListImedia.size() );
        f_writer.write("Imedia tổng: "+totalImedia+" Imedia Lệch : " + uniqueListImedia.size() );
        f_writer.newLine();

        //Writer file and add db after compare imedia
        writeFileImedia(uniqueListImedia,f_writer,mapTransImedia,sessionId);
        f_writer.close();

        //Import Compare Data Summary
        try {
            CompareDataSummaryEntity entity = new CompareDataSummaryEntity();
            Date date = new Date(System.currentTimeMillis());
            String meomeo= "123sadas";
            entity.setCompareDate(date);
            entity.setSys1Records(totalAtomi);
            entity.setSys2Records(totalImedia);
            entity.setSys1EqualRecords((totalAtomi-uniqueListAtomi.size()));
            entity.setDiffStatusRecords(totalAtomi); //=====>Test Loi
            entity.setDiffAmountRecords(countAtomi); //tổng tiền của atomi
            entity.setSys1MinusSys2(uniqueListAtomi.size());
            entity.setSys2MinusSys1(uniqueListImedia.size());
            dataSummarySerivce.create(entity);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        List<TransEntity> list = new ArrayList<>();
        return list ;
    }

    public Integer compareAndAdd(Map<String,TransEntity> partner1, Map<String,TransEntity> partner2,  List<String> uniqueList, String status){
        int countAtomi = 0;
        for (String keyAtomi :  partner1.keySet()) {
            countAtomi+= partner1.get(keyAtomi).getAMOUNT();
            if (partner2.keySet().contains(keyAtomi)) {
                continue;
            } else if(partner1.get(keyAtomi).getTRANG_THAI().equals(status)) {
                uniqueList.add(keyAtomi);
            }else {
                uniqueList.add(keyAtomi);
            }
        }
        return countAtomi;
    }


   public void writeFileAtomi(List<String> uniqueListAtomi ,  BufferedWriter f_writer,   Map<String,TransEntity> mapTransAtomi, int sessionId){
        for (String key: uniqueListAtomi) {
            try {
                if(mapTransAtomi.get(key).getTRANG_THAI().equals("EXT-0000")){
                    saveCompareDataAtomi(mapTransAtomi.get(key),sessionId);
                    f_writer.write( "**" + String.valueOf(mapTransAtomi.get(key)+"=>Cần xem xét lại"));
                    f_writer.newLine();
                }else {
                    saveCompareDataAtomi(mapTransAtomi.get(key),sessionId);
                    f_writer.write(String.valueOf(mapTransAtomi.get(key)+"=>Thất bại"));
                    f_writer.newLine();
                }
            }catch (IOException e){
                System.out.println(e);
            }

        }
    }

    public void writeFileImedia(List<String> uniqueListImedia,BufferedWriter f_writer,Map<String,TransEntity> mapTransImedia, int sessionId){
        for (String key: uniqueListImedia) {
            try {
                if(mapTransImedia.get(key).getTRANG_THAI().equals("Thanh Cong")){
                    saveCompareDataImedia(mapTransImedia.get(key),sessionId);
                    f_writer.write( "**" + String.valueOf(mapTransImedia.get(key)+"=>Cần xem xét lại"));
                    f_writer.newLine();
                    System.out.println(mapTransImedia.get(key));
                }
            }catch (IOException e){
                System.out.println(e);
            }
        }
    }

    @Override
    public void saveCompareDataAtomi(TransEntity transEntity,int idSession) {
        Date date = new Date(System.currentTimeMillis());
        CompareDataEntity compareData = new CompareDataEntity();
        compareData.setCompareDate(date);
        compareData.setSys1Id(GlobalConfig.SYS1_ATOMI);
        compareData.setSys2Id(GlobalConfig.SYS1_IMEDIA);
        compareData.setSys1TransId(Long.valueOf(transEntity.getTRANS_ID()));
        compareData.setSys1TransTime(Timestamp.valueOf(transEntity.getDATETIME_LOG()));
        compareData.setSys1TransType(transEntity.getTRANG_THAI());
        compareData.setSessionId(idSession);
        compareResponsitory.save(compareData);
    }

    @Override
    public void saveCompareDataImedia(TransEntity transEntity, int idSession) {
        Date date = new Date(System.currentTimeMillis());
        CompareDataEntity compareData = new CompareDataEntity();
        compareData.setCompareDate(date);
        compareData.setSys1Id(GlobalConfig.SYS1_ATOMI);
        compareData.setSys2Id(GlobalConfig.SYS1_IMEDIA);
        compareData.setSys2TransId(Long.valueOf(transEntity.getTRANS_ID()));
        compareData.setSys2TransTime(Timestamp.valueOf(Util.convertTimeImedia( Constant.FomartDate.DATE_FORMAT_IMEDIA,Constant.FomartDate.DATE_FORMAT_ATOMI,transEntity.getDATETIME_LOG())));
        compareData.setSys2TransStatus(transEntity.getTRANG_THAI());
        compareData.setSessionId(idSession);
        compareResponsitory.save(compareData);
    }

}
