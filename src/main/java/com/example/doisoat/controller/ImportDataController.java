package com.example.doisoat.controller;

import com.example.doisoat.model.ImportDataEntity;
import com.example.doisoat.service.ImportDataService;
import com.example.doisoat.service.SessionSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/import")
@Slf4j
public class ImportDataController {

    @Autowired
    ImportDataService importDataService;

    @Autowired
    SessionSerivce sessionSerivce;



    @GetMapping("/add")
    public ImportDataEntity add() throws SQLException {
        Timestamp ts = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")));
        int partnerId = sessionSerivce.getPartnerId("ATOMI");

        ImportDataEntity importDataModel = new ImportDataEntity();

        importDataModel.setImportCode("31232");
        importDataModel.setImportType("f");
        importDataModel.setSystemCode("321321");
        importDataModel.setFileName("doi_soat_thang_8.xlsx");
        importDataModel.setTotalAmount(900000000L);
        importDataModel.setNumberOfTotal(450548);
        importDataModel.setNumberOfSuccess(450000);
        importDataModel.setNumberOfFail(548);
        importDataModel.setImportDate(ts);
        importDataModel.setImportBy("Anh Duc");
        importDataModel.setDescription("Noi dung");
        importDataModel.setOrderNo(0);
        importDataModel.setPeriodDate("16-08-2022");
        importDataModel.setActionCode("");
        importDataModel.setStatus(1);
        importDataModel.setPartnerSystemId(partnerId);
        importDataModel.setSessionId(48);
        importDataModel.setEvidenceFile("");

        int a =  importDataService.create(importDataModel);
        log.info("ID = {}",a);
        return importDataModel;
    }

    @GetMapping("/")
    public List<ImportDataEntity> getAllImportData(){
        return importDataService.getListImportData();
    }
}
