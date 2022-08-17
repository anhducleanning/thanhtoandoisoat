package com.example.doisoat.controller;

import com.example.doisoat.model.ImportDataModel;
import com.example.doisoat.model.SessionModel;
import com.example.doisoat.service.ImportDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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



    @GetMapping("/add")
    public ImportDataModel add() throws SQLException {
        Timestamp ts = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")));
        ImportDataModel importDataModel = new ImportDataModel();

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
        importDataModel.setPartnerSystemId(2);
        importDataModel.setSessionId(48);
        importDataModel.setEvidenceFile("");

        int a =  importDataService.create(importDataModel);
        log.info("ID = {}",a);
        return importDataModel;
    }

    @GetMapping("/")
    public List<ImportDataModel> getAllImportData(){
        return importDataService.getListImportData();
    }
}
