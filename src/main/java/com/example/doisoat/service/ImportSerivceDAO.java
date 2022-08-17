package com.example.doisoat.service;

import com.example.doisoat.model.ImportDataModel;
import com.example.doisoat.model.PartnerSystemModel;
import com.example.doisoat.model.SessionModel;

import java.sql.SQLException;
import java.util.List;

public interface ImportSerivceDAO {


    List<ImportDataModel> getListImportData();
    Integer create(ImportDataModel importDataModel) throws SQLException;

}
