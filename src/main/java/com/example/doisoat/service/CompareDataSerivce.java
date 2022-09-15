package com.example.doisoat.service;

import com.example.doisoat.model.CompareDataEntity;
import com.example.doisoat.model.TransEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;



public interface CompareDataSerivce {

    List<TransEntity> compare() throws IOException;
    void saveCompareDataAtomi(TransEntity transEntity, int idSession);
    void saveCompareDataImedia(TransEntity transEntity, int idSession);

}
