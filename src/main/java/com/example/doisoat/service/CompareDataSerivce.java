package com.example.doisoat.service;

import com.example.doisoat.dto.RequestEntity;
import com.example.doisoat.model.CompareDataEntity;
import com.example.doisoat.model.TransEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;



public interface CompareDataSerivce {

    List<TransEntity> compare(MultipartFile fileAtomi,MultipartFile fileImedia1,MultipartFile fileImedia2) throws IOException;
    void saveCompareDataAtomi(TransEntity transEntity, int idSession);
    void saveCompareDataImedia(TransEntity transEntity, int idSession);

}
