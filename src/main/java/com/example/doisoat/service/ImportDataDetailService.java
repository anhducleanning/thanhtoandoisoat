package com.example.doisoat.service;

import com.example.doisoat.model.ImportDataDetailEntity;
import com.example.doisoat.model.TransEntity;

import java.util.HashMap;
import java.util.List;

public interface ImportDataDetailService {
    public void create(HashMap<String, TransEntity> trans, int idImport);
}
