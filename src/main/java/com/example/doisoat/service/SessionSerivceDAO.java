package com.example.doisoat.service;

import com.example.doisoat.model.PartnerSystemEntity;
import com.example.doisoat.model.SessionEntity;

import java.sql.SQLException;
import java.util.List;

public interface SessionSerivceDAO {


    List<SessionEntity> getAllSessions();
    Integer create(SessionEntity sessionModel) throws SQLException;

    List<PartnerSystemEntity> getPartnerSystem();

    Integer getPartnerId(String codePartner);
}
