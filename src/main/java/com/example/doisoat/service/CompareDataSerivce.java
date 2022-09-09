package com.example.doisoat.service;

import com.example.doisoat.model.CompareDataEntity;

public interface CompareDataSerivce {
    Integer saveCompareDataAtomi(CompareDataEntity compareDataEntity,int idSession);
    Integer saveCompareDataImedia(CompareDataEntity compareDataEntity,int idSession);
}
