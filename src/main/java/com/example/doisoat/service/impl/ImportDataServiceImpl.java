package com.example.doisoat.service.impl;

import com.example.doisoat.model.ImportDataDetailEntity;
import com.example.doisoat.model.ImportDataEntity;
import com.example.doisoat.service.ImportSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
@Slf4j
public class ImportDataServiceImpl implements ImportSerivce {

    private JdbcTemplate jdbcTemplate;

    public ImportDataServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<ImportDataEntity> rowMapper = (rs, rowNum) -> {
        ImportDataEntity importDataModel = new ImportDataEntity();

        importDataModel.setImportId(rs.getInt("import_id"));
        importDataModel.setImportCode(rs.getString("import_code"));
        importDataModel.setImportType(rs.getString("import_type"));
        importDataModel.setSystemCode(rs.getString("system_code"));
        importDataModel.setFileName(rs.getString("file_name"));
        importDataModel.setTotalAmount(rs.getLong("total_amount"));
        importDataModel.setNumberOfTotal(rs.getInt("number_of_total"));
        importDataModel.setNumberOfSuccess(rs.getInt("number_of_success"));
        importDataModel.setNumberOfFail(rs.getInt("number_of_fail"));
        importDataModel.setImportDate(rs.getTimestamp("import_date"));
        importDataModel.setImportBy(rs.getString("import_by"));
        importDataModel.setDescription(rs.getString("description"));
        importDataModel.setOrderNo(rs.getInt("order_no"));
        importDataModel.setPeriodDate(rs.getString("period_date"));
        importDataModel.setActionCode(rs.getString("action_code"));
        importDataModel.setStatus(rs.getInt("status"));
        importDataModel.setPartnerSystemId(rs.getInt("partner_system_id"));
        importDataModel.setSessionId(rs.getInt("session_id"));
        importDataModel.setEvidenceFile(rs.getString("evidence_file"));
        return importDataModel;
    };


    @Override
    public List<ImportDataEntity> getListImportData() {
        String sql = "SELECT * FROM import_data id ";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public Integer create(ImportDataEntity importDataModel) throws SQLException {
        String sql = "INSERT INTO doisoat_vv_te.import_data\n" +
                "(import_code, import_type, system_code, file_name, total_amount, number_of_total, number_of_success, number_of_fail, import_date, import_by, description, order_no, period_date, action_code, status, partner_system_id, session_id, evidence_file)\n" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int id = 0;
        // Create GeneratedKeyHolder object
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        int insert = jdbcTemplate.update(conn -> {
            // Pre-compiling SQL
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // Set parameters
            preparedStatement.setString(1, importDataModel.getImportCode());
            preparedStatement.setString(2,  importDataModel.getImportType());
            preparedStatement.setString(3, importDataModel.getSystemCode());
            preparedStatement.setString(4, importDataModel.getFileName());
            preparedStatement.setLong(5, importDataModel.getTotalAmount());
            preparedStatement.setInt(6,importDataModel.getNumberOfTotal());
            preparedStatement.setInt(7,importDataModel.getNumberOfSuccess());
            preparedStatement.setInt(8,importDataModel.getNumberOfFail());
            preparedStatement.setTimestamp(9,importDataModel.getImportDate());
            preparedStatement.setString(10,importDataModel.getImportBy());
            preparedStatement.setString(11,importDataModel.getDescription());
            preparedStatement.setInt(12,importDataModel.getOrderNo());
            preparedStatement.setString(13,importDataModel.getPeriodDate());
            preparedStatement.setString(14,importDataModel.getActionCode());
            preparedStatement.setInt(15,importDataModel.getStatus());
            preparedStatement.setInt(16,importDataModel.getPartnerSystemId());
            preparedStatement.setInt(17,importDataModel.getSessionId());
            preparedStatement.setString(18,importDataModel.getEvidenceFile());

            return preparedStatement;

        }, generatedKeyHolder);
        if(insert == 1){
            id = generatedKeyHolder.getKey().intValue();
            log.info("id={}", id);
        }
        return id;

    }


    @Override
    public ImportDataEntity getFindById(int id) {
        String sql = "SELECT * FROM import_data id WHERE import_id = " + id;
        return  jdbcTemplate.queryForObject(sql,rowMapper);
    }


    RowMapper<ImportDataDetailEntity> rowMapperDataDetail = (rs, rowNum) -> {
        ImportDataDetailEntity importDataModel = new ImportDataDetailEntity();

        importDataModel.setImportDetailId(rs.getLong("import_detail_id"));
        importDataModel.setImportCode(rs.getString("import_code"));
        importDataModel.setRefId(rs.getString("ref_id"));
        importDataModel.setTransType(rs.getString("trans_type"));
        importDataModel.setAmount(rs.getInt("amount"));
        importDataModel.setTransName(rs.getString("trans_name"));
        importDataModel.setTransStatus(rs.getString("trans_status"));
        importDataModel.setTransTime(rs.getTimestamp("trans_time"));
        importDataModel.setTransId(rs.getString("trans_id"));
        importDataModel.setImportId(rs.getInt("import_id"));
        return importDataModel;
    };

    @Override
    public ImportDataDetailEntity create(ImportDataDetailEntity importDataDetailEntity) {
        String sql = "INSERT INTO doisoat_vv_te.import_data_detail\n" +
                "(import_code, ref_id, trans_type, amount, trans_name, trans_status, trans_time, trans_id, import_id)\n" +
                "VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        int insert = jdbcTemplate.update(sql,
                importDataDetailEntity.getImportCode(),
                importDataDetailEntity.getRefId(),
                importDataDetailEntity.getTransType(),
                importDataDetailEntity.getAmount(),
                importDataDetailEntity.getTransName(),
                importDataDetailEntity.getTransStatus(),
                importDataDetailEntity.getTransTime(),
                importDataDetailEntity.getTransId(),
                importDataDetailEntity.getImportId()
                );
        if(insert == 1){
            log.info("ImportDataDetailEntity Susess" );
        }
        return importDataDetailEntity;
    }
}
