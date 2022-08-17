package com.example.doisoat.controller;

import com.example.doisoat.model.PartnerSystemModel;
import com.example.doisoat.model.SessionModel;
import com.example.doisoat.service.SessionSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/session")
@Slf4j
public class SessionController {

    @Autowired
    SessionSerivce sessionSerivce;

    @GetMapping("/all")
    List<SessionModel> getAll(){
        return sessionSerivce.getAllSessions();
    }

    @GetMapping("/add")
    public SessionModel add() throws SQLException {
        Timestamp ts = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")));
        SessionModel sessionModel = new SessionModel();

        int systemId2 = sessionSerivce.getPartnerId("IMEDIA");
        sessionModel.setPeriodDate("Khum biết");
        sessionModel.setCreated_at(ts);
        sessionModel.setUpdated_at(ts);
        sessionModel.setStatus(1);
        sessionModel.setSystemId1(2);
        sessionModel.setSystemId2(systemId2);

        int a =  sessionSerivce.create(sessionModel);
        log.info("ID = {}",a);
        return sessionModel;
    }

    @GetMapping("/getListPartner")
    public List<PartnerSystemModel> getAllPartner(){
        return sessionSerivce.getPartnerSystem();
    }

    @GetMapping("/getIdPartner")
    public Integer getIdPartner(){
        return  sessionSerivce.getPartnerId("IMEDIA");
    }

}
