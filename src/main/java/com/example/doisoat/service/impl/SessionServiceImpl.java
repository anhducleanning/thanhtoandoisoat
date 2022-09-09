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
@NoArgsConstructor
public class SessionServiceImpl implements SessionSerivce {

    @Autowired
    SessionReponsitory sessionReponsitory;


    @Autowired
    private JdbcTemplate jdbcTemplate;
    RowMapper<SessionEntity> rowMapper = (rs, rowNum) -> {
        SessionEntity sessionModel = new SessionEntity();
        sessionModel.setId(rs.getInt("id"));
        sessionModel.setPeriodDate(rs.getString("period_date"));
        sessionModel.setCreatedAt(rs.getTimestamp("created_at"));
        sessionModel.setUpdatedAt(rs.getTimestamp("updated_at"));
        sessionModel.setStatus(rs.getByte("status"));
        sessionModel.setSystemId1(rs.getInt("system_id_1"));
        sessionModel.setSystemId2(rs.getInt("system_id_2"));
        return sessionModel;
    };



    public SessionServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SessionEntity> getAllSessions() {
        String sql = "select * from  `session` ";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public Integer create(SessionEntity sessionModel)  {
        String sql = "INSERT INTO `session`(period_date, created_at, updated_at, status, system_id_1, system_id_2)" +
                "VALUES(?, ?, ?, ?, ?, ?);";

        int id = 0;
        // Create GeneratedKeyHolder object
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        int insert = jdbcTemplate.update(conn -> {
        // Pre-compiling SQL
        conn.setAutoCommit(true);
        PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        // Set parameters
        preparedStatement.setString(1, sessionModel.getPeriodDate());
        preparedStatement.setTimestamp(2,  sessionModel.getCreatedAt());
        preparedStatement.setTimestamp(3, sessionModel.getUpdatedAt());
        preparedStatement.setInt(4, sessionModel.getStatus());
        preparedStatement.setInt(5, sessionModel.getSystemId1());
        preparedStatement.setInt(6,sessionModel.getSystemId2());
//        conn.commit();
        return preparedStatement;

    }, generatedKeyHolder);

          if(insert == 1){
              id = generatedKeyHolder.getKey().intValue();
              log.info("id={}", id);
          }

        return id;
    }

    RowMapper<PartnerSystemEntity> rowMapPartner = (rs, rowNum) -> {
        PartnerSystemEntity partnerSystemModel = new PartnerSystemEntity();
        partnerSystemModel.setId(rs.getInt("id"));
        partnerSystemModel.setCode(rs.getString("code"));
        partnerSystemModel.setName(rs.getString("name"));
        partnerSystemModel.setDescription(rs.getString("description"));
        partnerSystemModel.setCreatedAt(rs.getTimestamp("created_at"));
        partnerSystemModel.setUpdatedAt(rs.getTimestamp("updated_at"));
        partnerSystemModel.setStatus(rs.getByte("status"));
        partnerSystemModel.setPartnerId(rs.getInt("partner_id"));
        return partnerSystemModel;
    };
    @Override
    public List<PartnerSystemEntity> getPartnerSystem() {
        String sql = "SELECT * FROM  partner_system";
        return jdbcTemplate.query(sql,rowMapPartner);
    }

    @Override
    public Integer getPartnerId(String codePartner) {
        int id = 0;
        String sql = "SELECT ID FROM  partner_system WHERE code = ? ";
        PartnerSystemEntity partnerSystemModel ;
        try {
            id = (int) jdbcTemplate.queryForObject(sql,new Object[] { codePartner },  Integer.class);
        }catch (DataAccessException ex){
            System.out.println(ex);
            log.info("Không tồn tài id đối tác" + codePartner);
        }
        return id;
    }

    @Override
    public SessionEntity getSessionById(int id) {
        String sql = "";
        try {
            sql = "SELECT * FROM `session` s WHERE ID = " + id;

        }catch (Exception e){
            System.out.println(e);
        }
        return  jdbcTemplate.queryForObject(sql,rowMapper);
    }

    @Override
    public void createTest(SessionEntity session) {
        sessionReponsitory.save(session);
    }


}
