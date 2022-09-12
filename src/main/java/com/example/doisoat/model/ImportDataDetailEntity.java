package com.example.doisoat.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "import_data_detail", schema = "doisoat_vv_te", catalog = "")
public class ImportDataDetailEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "import_detail_id")
    private long importDetailId;
    @Basic
    @Column(name = "import_code")
    private String importCode;
    @Basic
    @Column(name = "ref_id")
    private String refId;
    @Basic
    @Column(name = "trans_type")
    private String transType;
    @Basic
    @Column(name = "amount")
    private int amount;
    @Basic
    @Column(name = "trans_name")
    private String transName;
    @Basic
    @Column(name = "trans_status")
    private String transStatus;
    @Basic
    @Column(name = "trans_time")
    private String transTime;
    @Basic
    @Column(name = "trans_id")
    private String transId;
    @Basic
    @Column(name = "import_id")
    private int importId;

    public long getImportDetailId() {
        return importDetailId;
    }

    public void setImportDetailId(long importDetailId) {
        this.importDetailId = importDetailId;
    }

    public String getImportCode() {
        return importCode;
    }

    public void setImportCode(String importCode) {
        this.importCode = importCode;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public int getImportId() {
        return importId;
    }

    public void setImportId(int importId) {
        this.importId = importId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImportDataDetailEntity that = (ImportDataDetailEntity) o;
        return importDetailId == that.importDetailId && amount == that.amount && importId == that.importId && Objects.equals(importCode, that.importCode) && Objects.equals(refId, that.refId) && Objects.equals(transType, that.transType) && Objects.equals(transName, that.transName) && Objects.equals(transStatus, that.transStatus) && Objects.equals(transTime, that.transTime) && Objects.equals(transId, that.transId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(importDetailId, importCode, refId, transType, amount, transName, transStatus, transTime, transId, importId);
    }
}
