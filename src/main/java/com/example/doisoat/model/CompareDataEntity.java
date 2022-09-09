package com.example.doisoat.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "compare_data", schema = "doisoat_vv_te", catalog = "")
public class CompareDataEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "compare_id")
    private int compareId;
    @Basic
    @Column(name = "compare_date")
    private Date compareDate;
    @Basic
    @Column(name = "sys1_id")
    private Integer sys1Id;
    @Basic
    @Column(name = "sys2_id")
    private Integer sys2Id;
    @Basic
    @Column(name = "sys1_code")
    private String sys1Code;
    @Basic
    @Column(name = "sys2_code")
    private String sys2Code;
    @Basic
    @Column(name = "data_type")
    private String dataType;
    @Basic
    @Column(name = "sys1_trans_id")
    private Long sys1TransId;
    @Basic
    @Column(name = "sys1_trans_time")
    private Timestamp sys1TransTime;
    @Basic
    @Column(name = "sys1_amount")
    private Long sys1Amount;
    @Basic
    @Column(name = "sys1_trans_type")
    private String sys1TransType;
    @Basic
    @Column(name = "sys1_trans_status")
    private String sys1TransStatus;
    @Basic
    @Column(name = "sys1_partner_trans_id")
    private Integer sys1PartnerTransId;
    @Basic
    @Column(name = "sys2_trans_id")
    private Long sys2TransId;
    @Basic
    @Column(name = "sys2_trans_time")
    private Timestamp sys2TransTime;
    @Basic
    @Column(name = "sys2_amount")
    private Long sys2Amount;
    @Basic
    @Column(name = "sys2_trans_type")
    private String sys2TransType;
    @Basic
    @Column(name = "sys2_trans_status")
    private String sys2TransStatus;
    @Basic
    @Column(name = "sys2_partner_trans_id")
    private Integer sys2PartnerTransId;
    @Basic
    @Column(name = "compare_status")
    private String compareStatus;
    @Basic
    @Column(name = "compare_status_by_routine")
    private Byte compareStatusByRoutine;
    @Basic
    @Column(name = "create_by")
    private String createBy;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Basic
    @Column(name = "session_id")
    private int sessionId;

    public int getCompareId() {
        return compareId;
    }

    public void setCompareId(int compareId) {
        this.compareId = compareId;
    }

    public Date getCompareDate() {
        return compareDate;
    }

    public void setCompareDate(Date compareDate) {
        this.compareDate = compareDate;
    }

    public Integer getSys1Id() {
        return sys1Id;
    }

    public void setSys1Id(Integer sys1Id) {
        this.sys1Id = sys1Id;
    }

    public Integer getSys2Id() {
        return sys2Id;
    }

    public void setSys2Id(Integer sys2Id) {
        this.sys2Id = sys2Id;
    }

    public String getSys1Code() {
        return sys1Code;
    }

    public void setSys1Code(String sys1Code) {
        this.sys1Code = sys1Code;
    }

    public String getSys2Code() {
        return sys2Code;
    }

    public void setSys2Code(String sys2Code) {
        this.sys2Code = sys2Code;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Long getSys1TransId() {
        return sys1TransId;
    }

    public void setSys1TransId(Long sys1TransId) {
        this.sys1TransId = sys1TransId;
    }

    public Timestamp getSys1TransTime() {
        return sys1TransTime;
    }

    public void setSys1TransTime(Timestamp sys1TransTime) {
        this.sys1TransTime = sys1TransTime;
    }

    public Long getSys1Amount() {
        return sys1Amount;
    }

    public void setSys1Amount(Long sys1Amount) {
        this.sys1Amount = sys1Amount;
    }

    public String getSys1TransType() {
        return sys1TransType;
    }

    public void setSys1TransType(String sys1TransType) {
        this.sys1TransType = sys1TransType;
    }

    public String getSys1TransStatus() {
        return sys1TransStatus;
    }

    public void setSys1TransStatus(String sys1TransStatus) {
        this.sys1TransStatus = sys1TransStatus;
    }

    public Integer getSys1PartnerTransId() {
        return sys1PartnerTransId;
    }

    public void setSys1PartnerTransId(Integer sys1PartnerTransId) {
        this.sys1PartnerTransId = sys1PartnerTransId;
    }

    public Long getSys2TransId() {
        return sys2TransId;
    }

    public void setSys2TransId(Long sys2TransId) {
        this.sys2TransId = sys2TransId;
    }

    public Timestamp getSys2TransTime() {
        return sys2TransTime;
    }

    public void setSys2TransTime(Timestamp sys2TransTime) {
        this.sys2TransTime = sys2TransTime;
    }

    public Long getSys2Amount() {
        return sys2Amount;
    }

    public void setSys2Amount(Long sys2Amount) {
        this.sys2Amount = sys2Amount;
    }

    public String getSys2TransType() {
        return sys2TransType;
    }

    public void setSys2TransType(String sys2TransType) {
        this.sys2TransType = sys2TransType;
    }

    public String getSys2TransStatus() {
        return sys2TransStatus;
    }

    public void setSys2TransStatus(String sys2TransStatus) {
        this.sys2TransStatus = sys2TransStatus;
    }

    public Integer getSys2PartnerTransId() {
        return sys2PartnerTransId;
    }

    public void setSys2PartnerTransId(Integer sys2PartnerTransId) {
        this.sys2PartnerTransId = sys2PartnerTransId;
    }

    public String getCompareStatus() {
        return compareStatus;
    }

    public void setCompareStatus(String compareStatus) {
        this.compareStatus = compareStatus;
    }

    public Byte getCompareStatusByRoutine() {
        return compareStatusByRoutine;
    }

    public void setCompareStatusByRoutine(Byte compareStatusByRoutine) {
        this.compareStatusByRoutine = compareStatusByRoutine;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompareDataEntity that = (CompareDataEntity) o;
        return compareId == that.compareId && sessionId == that.sessionId && Objects.equals(compareDate, that.compareDate) && Objects.equals(sys1Id, that.sys1Id) && Objects.equals(sys2Id, that.sys2Id) && Objects.equals(sys1Code, that.sys1Code) && Objects.equals(sys2Code, that.sys2Code) && Objects.equals(dataType, that.dataType) && Objects.equals(sys1TransId, that.sys1TransId) && Objects.equals(sys1TransTime, that.sys1TransTime) && Objects.equals(sys1Amount, that.sys1Amount) && Objects.equals(sys1TransType, that.sys1TransType) && Objects.equals(sys1TransStatus, that.sys1TransStatus) && Objects.equals(sys1PartnerTransId, that.sys1PartnerTransId) && Objects.equals(sys2TransId, that.sys2TransId) && Objects.equals(sys2TransTime, that.sys2TransTime) && Objects.equals(sys2Amount, that.sys2Amount) && Objects.equals(sys2TransType, that.sys2TransType) && Objects.equals(sys2TransStatus, that.sys2TransStatus) && Objects.equals(sys2PartnerTransId, that.sys2PartnerTransId) && Objects.equals(compareStatus, that.compareStatus) && Objects.equals(compareStatusByRoutine, that.compareStatusByRoutine) && Objects.equals(createBy, that.createBy) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compareId, compareDate, sys1Id, sys2Id, sys1Code, sys2Code, dataType, sys1TransId, sys1TransTime, sys1Amount, sys1TransType, sys1TransStatus, sys1PartnerTransId, sys2TransId, sys2TransTime, sys2Amount, sys2TransType, sys2TransStatus, sys2PartnerTransId, compareStatus, compareStatusByRoutine, createBy, createdAt, sessionId);
    }
}
