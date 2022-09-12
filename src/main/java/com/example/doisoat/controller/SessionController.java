package com.example.doisoat.controller;

import com.example.doisoat.model.SessionEntity;
import com.example.doisoat.service.SessionSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/session")
@Slf4j
public class SessionController {


    @Autowired
    private SessionSerivce sessionSerivce;


    @GetMapping ("/create")
    public SessionEntity createSession() throws SQLException {
        //Cần nhận Code Partner để biết đối tác nào
        SessionEntity sessionModel = new SessionEntity();
        sessionModel.setPeriodDate("Theo ngày");
        sessionModel.setStatus((byte) 1);
        sessionModel.setSystemId1(2);
        sessionModel.setSystemId2(2);
        sessionSerivce.create(sessionModel);
        System.out.println(sessionModel.getId());
        return  sessionModel;
    }


}
