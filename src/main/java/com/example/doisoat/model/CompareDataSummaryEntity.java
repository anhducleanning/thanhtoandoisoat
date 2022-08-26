package com.example.doisoat.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "compare_data_summary", schema = "doisoat_vv_te", catalog = "")
public class CompareDataSummaryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "compare_data_sum_id")
    private int compareDataSumId;
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
    @Column(name = "sys1_records")
    private int sys1Records;
    @Basic
    @Column(name = "sys2_records")
    private int sys2Records;
    @Basic
    @Column(name = "sys1_equal_records")
    private int sys1EqualRecords;
    @Basic
    @Column(name = "sys1_equal_amount")
    private Long sys1EqualAmount;
    @Basic
    @Column(name = "diff_status_records")
    private int diffStatusRecords;
    @Basic
    @Column(name = "diff_amount_records")
    private int diffAmountRecords;
    @Basic
    @Column(name = "sys1_minus_sys2")
    private int sys1MinusSys2;
    @Basic
    @Column(name = "sys2_minus_sys1")
    private int sys2MinusSys1;
    @Basic
    @Column(name = "trans_date")
    private Date transDate;
    @Basic
    @Column(name = "create_by")
    private String createBy;
    @Basic
    @Column(name = "create_datetime")
    private Timestamp createDatetime;
    @Basic
    @Column(name = "compare_status")
    private String compareStatus;
    @Basic
    @Column(name = "compare_id")
    private int compareId;

    public int getCompareDataSumId() {
        return compareDataSumId;
    }

    public void setCompareDataSumId(int compareDataSumId) {
        this.compareDataSumId = compareDataSumId;
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

    public int getSys1Records() {
        return sys1Records;
    }

    public void setSys1Records(int sys1Records) {
        this.sys1Records = sys1Records;
    }

    public int getSys2Records() {
        return sys2Records;
    }

    public void setSys2Records(int sys2Records) {
        this.sys2Records = sys2Records;
    }

    public int getSys1EqualRecords() {
        return sys1EqualRecords;
    }

    public void setSys1EqualRecords(int sys1EqualRecords) {
        this.sys1EqualRecords = sys1EqualRecords;
    }

    public Long getSys1EqualAmount() {
        return sys1EqualAmount;
    }

    public void setSys1EqualAmount(Long sys1EqualAmount) {
        this.sys1EqualAmount = sys1EqualAmount;
    }

    public int getDiffStatusRecords() {
        return diffStatusRecords;
    }

    public void setDiffStatusRecords(int diffStatusRecords) {
        this.diffStatusRecords = diffStatusRecords;
    }

    public int getDiffAmountRecords() {
        return diffAmountRecords;
    }

    public void setDiffAmountRecords(int diffAmountRecords) {
        this.diffAmountRecords = diffAmountRecords;
    }

    public int getSys1MinusSys2() {
        return sys1MinusSys2;
    }

    public void setSys1MinusSys2(int sys1MinusSys2) {
        this.sys1MinusSys2 = sys1MinusSys2;
    }

    public int getSys2MinusSys1() {
        return sys2MinusSys1;
    }

    public void setSys2MinusSys1(int sys2MinusSys1) {
        this.sys2MinusSys1 = sys2MinusSys1;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Timestamp getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Timestamp createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getCompareStatus() {
        return compareStatus;
    }

    public void setCompareStatus(String compareStatus) {
        this.compareStatus = compareStatus;
    }

    public int getCompareId() {
        return compareId;
    }

    public void setCompareId(int compareId) {
        this.compareId = compareId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompareDataSummaryEntity that = (CompareDataSummaryEntity) o;
        return compareDataSumId == that.compareDataSumId && sys1Records == that.sys1Records && sys2Records == that.sys2Records && sys1EqualRecords == that.sys1EqualRecords && diffStatusRecords == that.diffStatusRecords && diffAmountRecords == that.diffAmountRecords && sys1MinusSys2 == that.sys1MinusSys2 && sys2MinusSys1 == that.sys2MinusSys1 && compareId == that.compareId && Objects.equals(compareDate, that.compareDate) && Objects.equals(sys1Id, that.sys1Id) && Objects.equals(sys2Id, that.sys2Id) && Objects.equals(sys1Code, that.sys1Code) && Objects.equals(sys2Code, that.sys2Code) && Objects.equals(sys1EqualAmount, that.sys1EqualAmount) && Objects.equals(transDate, that.transDate) && Objects.equals(createBy, that.createBy) && Objects.equals(createDatetime, that.createDatetime) && Objects.equals(compareStatus, that.compareStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compareDataSumId, compareDate, sys1Id, sys2Id, sys1Code, sys2Code, sys1Records, sys2Records, sys1EqualRecords, sys1EqualAmount, diffStatusRecords, diffAmountRecords, sys1MinusSys2, sys2MinusSys1, transDate, createBy, createDatetime, compareStatus, compareId);
    }
}
