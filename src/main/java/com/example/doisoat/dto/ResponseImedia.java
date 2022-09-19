package com.example.doisoat.dto;

import com.example.doisoat.model.TransEntity;

import java.util.List;

public class ResponseImedia extends ResponseEntity{
    private List<TransEntity> transEntities;

    private DataDetail dataDetail;

    public ResponseImedia(String reponseCode, String reponseMessage) {
        super(reponseCode, reponseMessage);
    }

    public ResponseImedia(String reponseCode, String reponseMessage, List<TransEntity> transEntities, DataDetail dataDetail) {
        super(reponseCode, reponseMessage);
        this.transEntities = transEntities;
        this.dataDetail = dataDetail;
    }

    public ResponseImedia() {

    }

    public List<TransEntity> getTransEntities() {
        return transEntities;
    }

    public void setTransEntities(List<TransEntity> transEntities) {
        this.transEntities = transEntities;
    }

    public DataDetail getDataDetail() {
        return dataDetail;
    }

    public void setDataDetail(DataDetail dataDetail) {
        this.dataDetail = dataDetail;
    }
}
