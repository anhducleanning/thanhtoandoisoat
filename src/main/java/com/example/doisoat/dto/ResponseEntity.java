package com.example.doisoat.dto;

import com.example.doisoat.model.TransEntity;

public class ResponseEntity {
    private String reponseCode;
    private String reponseMessage;

    public ResponseEntity(String reponseCode, String reponseMessage) {
        this.reponseCode = reponseCode;
        this.reponseMessage = reponseMessage;
    }

    public ResponseEntity() {
    }

    public String getReponseCode() {
        return reponseCode;
    }

    public void setReponseCode(String reponseCode) {
        this.reponseCode = reponseCode;
    }

    public String getReponseMessage() {
        return reponseMessage;
    }

    public void setReponseMessage(String reponseMessage) {
        this.reponseMessage = reponseMessage;
    }
}
