package com.example.doisoat.service.impl;

import com.example.doisoat.model.ImportDataEntity;
import com.example.doisoat.reponsitory.ImportDataReponsitory;
import com.example.doisoat.service.ImportDataSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ImportDataServiceImpl implements ImportDataSerivce {

    @Autowired
    ImportDataReponsitory importDataReponsitory;

    @Override
    public void createImportData(ImportDataEntity importData) {
            importDataReponsitory.save(importData);
    }
}
