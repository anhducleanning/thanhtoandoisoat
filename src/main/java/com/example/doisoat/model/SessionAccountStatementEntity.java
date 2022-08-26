package com.example.doisoat.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "session_account_statement", schema = "doisoat_vv_te", catalog = "")
public class SessionAccountStatementEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "status")
    private byte status;
    @Basic
    @Column(name = "acc_branch")
    private String accBranch;
    @Basic
    @Column(name = "acc_name")
    private String accName;
    @Basic
    @Column(name = "account_no")
    private String accountNo;
    @Basic
    @Column(name = "customer_no")
    private String customerNo;
    @Basic
    @Column(name = "full_name")
    private String fullName;
    @Basic
    @Column(name = "trn_date")
    private Timestamp trnDate;
    @Basic
    @Column(name = "value_date")
    private Timestamp valueDate;
    @Basic
    @Column(name = "check_time")
    private Timestamp checkTime;
    @Basic
    @Column(name = "trn_ref_no")
    private String trnRefNo;
    @Basic
    @Column(name = "narrative")
    private String narrative;
    @Basic
    @Column(name = "amount")
    private long amount;
    @Basic
    @Column(name = "drcr")
    private String drcr;
    @Basic
    @Column(name = "open_balance")
    private long openBalance;
    @Basic
    @Column(name = "close_balance")
    private long closeBalance;
    @Basic
    @Column(name = "current_balance")
    private long currentBalance;
    @Basic
    @Column(name = "session_id")
    private int sessionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getAccBranch() {
        return accBranch;
    }

    public void setAccBranch(String accBranch) {
        this.accBranch = accBranch;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Timestamp getTrnDate() {
        return trnDate;
    }

    public void setTrnDate(Timestamp trnDate) {
        this.trnDate = trnDate;
    }

    public Timestamp getValueDate() {
        return valueDate;
    }

    public void setValueDate(Timestamp valueDate) {
        this.valueDate = valueDate;
    }

    public Timestamp getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Timestamp checkTime) {
        this.checkTime = checkTime;
    }

    public String getTrnRefNo() {
        return trnRefNo;
    }

    public void setTrnRefNo(String trnRefNo) {
        this.trnRefNo = trnRefNo;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getDrcr() {
        return drcr;
    }

    public void setDrcr(String drcr) {
        this.drcr = drcr;
    }

    public long getOpenBalance() {
        return openBalance;
    }

    public void setOpenBalance(long openBalance) {
        this.openBalance = openBalance;
    }

    public long getCloseBalance() {
        return closeBalance;
    }

    public void setCloseBalance(long closeBalance) {
        this.closeBalance = closeBalance;
    }

    public long getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(long currentBalance) {
        this.currentBalance = currentBalance;
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
        SessionAccountStatementEntity that = (SessionAccountStatementEntity) o;
        return id == that.id && status == that.status && amount == that.amount && openBalance == that.openBalance && closeBalance == that.closeBalance && currentBalance == that.currentBalance && sessionId == that.sessionId && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(description, that.description) && Objects.equals(accBranch, that.accBranch) && Objects.equals(accName, that.accName) && Objects.equals(accountNo, that.accountNo) && Objects.equals(customerNo, that.customerNo) && Objects.equals(fullName, that.fullName) && Objects.equals(trnDate, that.trnDate) && Objects.equals(valueDate, that.valueDate) && Objects.equals(checkTime, that.checkTime) && Objects.equals(trnRefNo, that.trnRefNo) && Objects.equals(narrative, that.narrative) && Objects.equals(drcr, that.drcr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, description, status, accBranch, accName, accountNo, customerNo, fullName, trnDate, valueDate, checkTime, trnRefNo, narrative, amount, drcr, openBalance, closeBalance, currentBalance, sessionId);
    }
}
