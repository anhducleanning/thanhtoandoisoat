package com.example.doisoat.controller;

import com.example.doisoat.model.PartnerSystemEntity;
import com.example.doisoat.model.SessionEntity;
import com.example.doisoat.service.SessionSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
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
    List<SessionEntity> getAll(){
        return sessionSerivce.getAllSessions();
    }

    @GetMapping("/create")
    public SessionEntity createSession() throws SQLException {
        //Cần nhận Code Partner để biết đối tác nào
        Timestamp ts = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")));
        SessionEntity sessionModel = new SessionEntity();

        int systemId2 = sessionSerivce.getPartnerId("IMEDIA");
        sessionModel.setPeriodDate("Theo ngày");
        sessionModel.setCreatedAt(ts);
        sessionModel.setUpdatedAt(ts);
        sessionModel.setStatus((byte) 1);
        sessionModel.setSystemId1(2);
        sessionModel.setSystemId2(systemId2);

        int id =  sessionSerivce.create(sessionModel);
        log.info("ID = {}",id);
        return   sessionSerivce.getSessionById(id);
    }


}
