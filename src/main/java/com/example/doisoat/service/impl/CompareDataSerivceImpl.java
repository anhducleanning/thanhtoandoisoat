package com.example.doisoat.service.impl;

import com.example.doisoat.model.CompareDataEntity;
import com.example.doisoat.reponsitory.CompareResponsitory;
import com.example.doisoat.service.CompareDataSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Service
@Slf4j
public class CompareDataSerivceImpl implements CompareDataSerivce {

    @Autowired
    CompareResponsitory compareResponsitory;
    @Autowired
    JdbcTemplate jdbcTemplate=new JdbcTemplate();
    @Override
    public Integer saveCompareDataAtomi(CompareDataEntity compareDataEntity,int idSession) {
        String sql = "INSERT INTO compare_data (compare_date,sys1_id ,sys2_id ,sys1_trans_id,sys1_trans_time,sys1_trans_type ,session_id) " +
                "VALUES(?,?,?,?,?,?,?)";

        int id = 0;
        // Create GeneratedKeyHolder object
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();


        int insert = jdbcTemplate.update(conn -> {
            // Pre-compiling SQL
            conn.setAutoCommit(true);
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // Set parameters
            preparedStatement.setDate(1, compareDataEntity.getCompareDate());
            preparedStatement.setInt(2,  compareDataEntity.getSys1Id());
            preparedStatement.setInt(3,  compareDataEntity.getSys2Id());
            preparedStatement.setLong(4,compareDataEntity.getSys1TransId());
            preparedStatement.setTimestamp(5,compareDataEntity.getSys1TransTime());
            preparedStatement.setString(6,compareDataEntity.getSys1TransStatus());
            preparedStatement.setInt(7,idSession);
//            conn.commit();
            return preparedStatement;

        }, generatedKeyHolder);

        if(insert == 1){
            id = generatedKeyHolder.getKey().intValue();
//            log.info("id={}", id);
        }
        return id;

    }

    @Override
    public Integer saveCompareDataImedia(CompareDataEntity compareDataEntity, int idSession) {
        String sql = "INSERT INTO compare_data (compare_date,sys1_id ,sys2_id , sys2_trans_id,sys2_trans_time ,sys2_trans_type,session_id) " +
                "VALUES(?,?,?,?,?,?,?)";

        int id = 0;
        // Create GeneratedKeyHolder object
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();


        int insert = jdbcTemplate.update(conn -> {
            // Pre-compiling SQL
            conn.setAutoCommit(true);
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // Set parameters
            preparedStatement.setDate(1, compareDataEntity.getCompareDate());
            preparedStatement.setInt(2,  compareDataEntity.getSys1Id());
            preparedStatement.setInt(3,  compareDataEntity.getSys2Id());
            preparedStatement.setLong(4,compareDataEntity.getSys2TransId());
            preparedStatement.setTimestamp(5,compareDataEntity.getSys2TransTime());
            preparedStatement.setString(6,compareDataEntity.getSys2TransStatus());
            preparedStatement.setInt(7,idSession);
//            conn.commit();
            return preparedStatement;

        }, generatedKeyHolder);

        if(insert == 1){
            id = generatedKeyHolder.getKey().intValue();
        }
        return id;
    }
}
