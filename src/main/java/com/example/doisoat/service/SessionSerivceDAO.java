package com.example.doisoat.service;

import com.example.doisoat.model.PartnerModel;
import com.example.doisoat.model.PartnerSystemModel;
import com.example.doisoat.model.SessionModel;
import org.apache.poi.ss.formula.functions.T;

import java.sql.SQLException;
import java.util.List;

public interface SessionSerivceDAO {


    List<SessionModel> getAllSessions();
    Integer create(SessionModel sessionModel) throws SQLException;

    List<PartnerSystemModel> getPartnerSystem();

    Integer getPartnerId(String codePartner);
}
