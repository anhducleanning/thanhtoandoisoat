package com.example.doisoat.service.impl;

import com.example.doisoat.model.CompareDataSummaryEntity;
import com.example.doisoat.reponsitory.CompareDataSummaryReponsitory;
import com.example.doisoat.service.CompareDataSummarySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompareDataSummaryImpl implements CompareDataSummarySerivce {
    @Autowired
    CompareDataSummaryReponsitory reponsitory;

    @Override
    public void create(CompareDataSummaryEntity entity) {
        reponsitory.save(entity);
    }
}
