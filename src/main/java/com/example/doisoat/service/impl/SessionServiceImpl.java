package com.example.doisoat.service.impl;

import com.example.doisoat.model.PartnerSystemEntity;
import com.example.doisoat.model.SessionEntity;
import com.example.doisoat.reponsitory.SessionReponsitory;
import com.example.doisoat.service.SessionSerivce;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Service
@Slf4j
public class SessionServiceImpl implements SessionSerivce {

    @Autowired
    SessionReponsitory sessionReponsitory;

    @Override
    public void create(SessionEntity session) {
        sessionReponsitory.save(session);
    }


}
