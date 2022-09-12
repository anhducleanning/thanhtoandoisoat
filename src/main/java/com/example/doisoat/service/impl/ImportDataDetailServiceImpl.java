package com.example.doisoat.service.impl;

import com.example.doisoat.model.ImportDataDetailEntity;
import com.example.doisoat.reponsitory.ImportDataDetailRepository;
import com.example.doisoat.service.ImportDataDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ImportDataDetailServiceImpl implements ImportDataDetailService {

    @Autowired
    ImportDataDetailRepository repository;

    @Override
    public void create(List<ImportDataDetailEntity> data) {
        repository.saveAll(data);
    }
}
