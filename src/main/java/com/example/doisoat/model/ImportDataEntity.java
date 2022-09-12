package com.example.doisoat.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "import_data", schema = "doisoat_vv_te", catalog = "")
public class ImportDataEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "import_id")
    private int importId;
    @Basic
    @Column(name = "import_code")
    private String importCode;
    @Basic
    @Column(name = "import_type")
    private String importType;
    @Basic
    @Column(name = "system_code")
    private String systemCode;
    @Basic
    @Column(name = "file_name")
    private String fileName;
    @Basic
    @Column(name = "total_amount")
    private Long totalAmount;
    @Basic
    @Column(name = "number_of_total")
    private Integer numberOfTotal;
    @Basic
    @Column(name = "number_of_success")
    private Integer numberOfSuccess;
    @Basic
    @Column(name = "number_of_fail")
    private Integer numberOfFail;
    @Basic
    @Column(name = "import_date")
    @CreationTimestamp
    private Timestamp importDate;
    @Basic
    @Column(name = "import_by")
    private String importBy;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "order_no")
    private Integer orderNo;
    @Basic
    @Column(name = "period_date")
    private String periodDate;
    @Basic
    @Column(name = "action_code")
    private String actionCode;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "partner_system_id")
    private int partnerSystemId;
    @Basic
    @Column(name = "session_id")
    private int sessionId;
    @Basic
    @Column(name = "evidence_file")
    private String evidenceFile;

    public int getImportId() {
        return importId;
    }

    public void setImportId(int importId) {
        this.importId = importId;
    }

    public String getImportCode() {
        return importCode;
    }

    public void setImportCode(String importCode) {
        this.importCode = importCode;
    }

    public String getImportType() {
        return importType;
    }

    public void setImportType(String importType) {
        this.importType = importType;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getNumberOfTotal() {
        return numberOfTotal;
    }

    public void setNumberOfTotal(Integer numberOfTotal) {
        this.numberOfTotal = numberOfTotal;
    }

    public Integer getNumberOfSuccess() {
        return numberOfSuccess;
    }

    public void setNumberOfSuccess(Integer numberOfSuccess) {
        this.numberOfSuccess = numberOfSuccess;
    }

    public Integer getNumberOfFail() {
        return numberOfFail;
    }

    public void setNumberOfFail(Integer numberOfFail) {
        this.numberOfFail = numberOfFail;
    }

    public Timestamp getImportDate() {
        return importDate;
    }

    public void setImportDate(Timestamp importDate) {
        this.importDate = importDate;
    }

    public String getImportBy() {
        return importBy;
    }

    public void setImportBy(String importBy) {
        this.importBy = importBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getPeriodDate() {
        return periodDate;
    }

    public void setPeriodDate(String periodDate) {
        this.periodDate = periodDate;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getPartnerSystemId() {
        return partnerSystemId;
    }

    public void setPartnerSystemId(int partnerSystemId) {
        this.partnerSystemId = partnerSystemId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getEvidenceFile() {
        return evidenceFile;
    }

    public void setEvidenceFile(String evidenceFile) {
        this.evidenceFile = evidenceFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImportDataEntity that = (ImportDataEntity) o;
        return importId == that.importId && partnerSystemId == that.partnerSystemId && sessionId == that.sessionId && Objects.equals(importCode, that.importCode) && Objects.equals(importType, that.importType) && Objects.equals(systemCode, that.systemCode) && Objects.equals(fileName, that.fileName) && Objects.equals(totalAmount, that.totalAmount) && Objects.equals(numberOfTotal, that.numberOfTotal) && Objects.equals(numberOfSuccess, that.numberOfSuccess) && Objects.equals(numberOfFail, that.numberOfFail) && Objects.equals(importDate, that.importDate) && Objects.equals(importBy, that.importBy) && Objects.equals(description, that.description) && Objects.equals(orderNo, that.orderNo) && Objects.equals(periodDate, that.periodDate) && Objects.equals(actionCode, that.actionCode) && Objects.equals(status, that.status) && Objects.equals(evidenceFile, that.evidenceFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(importId, importCode, importType, systemCode, fileName, totalAmount, numberOfTotal, numberOfSuccess, numberOfFail, importDate, importBy, description, orderNo, periodDate, actionCode, status, partnerSystemId, sessionId, evidenceFile);
    }
}
