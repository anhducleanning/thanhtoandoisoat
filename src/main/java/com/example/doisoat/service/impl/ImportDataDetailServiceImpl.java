package com.example.doisoat.service.impl;

import com.example.doisoat.model.ImportDataDetailEntity;
import com.example.doisoat.model.TransEntity;
import com.example.doisoat.reponsitory.ImportDataDetailRepository;
import com.example.doisoat.service.ImportDataDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class ImportDataDetailServiceImpl implements ImportDataDetailService {

    @Autowired
    ImportDataDetailRepository repository;

    @Override
    public void create(HashMap<String, TransEntity> trans, int idImport) {
        try {
            //ImportDataDetaild
            ImportDataDetailEntity dataDetail = new ImportDataDetailEntity();
            List<ImportDataDetailEntity> list = new ArrayList<>();
            for (String keyAtm : trans.keySet()) {
                dataDetail.setImportDetailId(Long.valueOf(trans.get(keyAtm).getTRANS_ID()));
                dataDetail.setImportCode("IMPORTCODE"+Math.random());
                dataDetail.setRefId(trans.get(keyAtm).getTRANS_ID());
                dataDetail.setAmount(Integer.valueOf(trans.get(keyAtm).getAMOUNT()));
                dataDetail.setTransName(trans.get(keyAtm).getSERVICE_CODE());
                dataDetail.setTransStatus(trans.get(keyAtm).getTRANG_THAI());
                dataDetail.setTransTime(trans.get(keyAtm).getDATETIME_LOG());
                dataDetail.setTransType("D");
                dataDetail.setImportId(idImport);
                list.add(dataDetail);

            }
            repository.saveAll(list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
