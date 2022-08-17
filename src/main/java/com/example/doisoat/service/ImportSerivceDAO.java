package com.example.doisoat.service;

import com.example.doisoat.model.ImportDataEntity;

import java.sql.SQLException;
import java.util.List;

public interface ImportSerivceDAO {


    List<ImportDataEntity> getListImportData();
    Integer create(ImportDataEntity importDataModel) throws SQLException;

}
