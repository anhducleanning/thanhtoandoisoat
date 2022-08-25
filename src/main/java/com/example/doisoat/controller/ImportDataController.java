package com.example.doisoat.controller;

import com.example.doisoat.Order_Id_Random;
import com.example.doisoat.model.ImportDataDetailEntity;
import com.example.doisoat.model.ImportDataEntity;
import com.example.doisoat.service.ImportDataService;
import com.example.doisoat.service.SessionSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    Order_Id_Random random = new Order_Id_Random();
    Timestamp ts = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")));

    @GetMapping("/addData/{id}")
    public ImportDataEntity createImportData(@PathVariable int id) throws SQLException {

        int partnerId = sessionSerivce.getPartnerId("ATOMI");

        ImportDataEntity importDataModel = new ImportDataEntity();
        importDataModel.setImportCode(random.genOderId());
        importDataModel.setImportType("f");
        importDataModel.setSystemCode(random.genOderId());
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
        importDataModel.setSessionId(83);
        importDataModel.setEvidenceFile("");

        int idImportData =  importDataService.create(importDataModel);
        log.info("ID = {}",idImportData);
        return  importDataService.getFindById(idImportData);
    }

    @GetMapping("/")
    public List<ImportDataEntity> getAllImportData(){
        return importDataService.getListImportData();
    }

    @GetMapping("/addDataDetail/{id}")
    public ImportDataDetailEntity createImportDataDetail(@PathVariable int id){
        ImportDataDetailEntity data = new ImportDataDetailEntity();
        data.setImportCode(String.valueOf(random.genOderId()));
        data.setRefId(String.valueOf(random.genOderId()));
        data.setTransType("D");
        data.setAmount(50000);
        data.setTransName("BUYCARD");
        data.setTransStatus("Thành Công");
        data.setTransTime(ts);
        data.setTransId(String.valueOf(random.genOderId()));
        data.setImportId(id);
        return importDataService.create(data);
    }
}
