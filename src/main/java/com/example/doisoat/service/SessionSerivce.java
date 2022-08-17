package com.example.doisoat.service;

import com.example.doisoat.model.PartnerSystemModel;
import com.example.doisoat.model.SessionModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class SessionSerivce implements SessionSerivceDAO {

    private JdbcTemplate jdbcTemplate;
    RowMapper<SessionModel> rowMapper = (rs, rowNum) -> {
        SessionModel sessionModel = new SessionModel();
        sessionModel.setId(rs.getInt("id"));
        sessionModel.setPeriodDate(rs.getString("period_date"));
        sessionModel.setCreated_at(rs.getTimestamp("created_at"));
        sessionModel.setUpdated_at(rs.getTimestamp("updated_at"));
        sessionModel.setStatus(rs.getInt("status"));
        sessionModel.setSystemId1(rs.getInt("system_id_1"));
        sessionModel.setSystemId2(rs.getInt("system_id_2"));
        return sessionModel;
    };



    public SessionSerivce(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SessionModel> getAllSessions() {
        String sql = "select * from  `session` ";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public Integer create(SessionModel sessionModel)  {
        String sql = "INSERT INTO `session`(period_date, created_at, updated_at, status, system_id_1, system_id_2)" +
                "VALUES(?, ?, ?, ?, ?, ?);";
        int id = 0;
        // Create GeneratedKeyHolder object
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        int insert = jdbcTemplate.update(conn -> {
            // Pre-compiling SQL
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // Set parameters
            preparedStatement.setString(1, sessionModel.getPeriodDate());
            preparedStatement.setTimestamp(2,  sessionModel.getCreated_at());
            preparedStatement.setTimestamp(3, sessionModel.getUpdated_at());
            preparedStatement.setInt(4, sessionModel.getStatus());
            preparedStatement.setInt(5, sessionModel.getSystemId1());
            preparedStatement.setInt(6,sessionModel.getSystemId2());
            return preparedStatement;

        }, generatedKeyHolder);
        if(insert == 1){
             id = generatedKeyHolder.getKey().intValue();
            log.info("id={}", id);
        }
        return id;
    }

    RowMapper<PartnerSystemModel> rowMapPartner = (rs, rowNum) -> {
        PartnerSystemModel partnerSystemModel = new PartnerSystemModel();
        partnerSystemModel.setId(rs.getInt("id"));
        partnerSystemModel.setCode(rs.getString("code"));
        partnerSystemModel.setName(rs.getString("name"));
        partnerSystemModel.setDescription(rs.getString("description"));
        partnerSystemModel.setCreated_at(rs.getTimestamp("created_at"));
        partnerSystemModel.setUpdated_at(rs.getTimestamp("updated_at"));
        partnerSystemModel.setStatus(rs.getInt("status"));
        partnerSystemModel.setPartnerId(rs.getInt("partner_id"));
        return partnerSystemModel;
    };
    @Override
    public List<PartnerSystemModel> getPartnerSystem() {
        String sql = "SELECT * FROM  partner_system";
        return jdbcTemplate.query(sql,rowMapPartner);
    }

    @Override
    public Integer getPartnerId(String codePartner) {
        int id = 0;
        String sql = "SELECT ID FROM  partner_system WHERE code = ? ";
        PartnerSystemModel partnerSystemModel ;
        try {
            id = (int) jdbcTemplate.queryForObject(sql,new Object[] { codePartner },  Integer.class);
        }catch (DataAccessException ex){
            System.out.println(ex);
            log.info("Không tồn tài id đối tác" + codePartner);
        }
        return id;
    }


}
