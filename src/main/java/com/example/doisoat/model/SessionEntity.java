package com.example.doisoat.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "session", schema = "doisoat_vv_te", catalog = "")
public class SessionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "period_date")
    private String periodDate;
    @Basic
    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at")
    @CreationTimestamp
    private Timestamp updatedAt;
    @Basic
    @Column(name = "status")
    private byte status;
    @Basic
    @Column(name = "system_id_1")
    private int systemId1;
    @Basic
    @Column(name = "system_id_2")
    private int systemId2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodDate() {
        return periodDate;
    }

    public void setPeriodDate(String periodDate) {
        this.periodDate = periodDate;
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

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public int getSystemId1() {
        return systemId1;
    }

    public void setSystemId1(int systemId1) {
        this.systemId1 = systemId1;
    }

    public int getSystemId2() {
        return systemId2;
    }

    public void setSystemId2(int systemId2) {
        this.systemId2 = systemId2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionEntity that = (SessionEntity) o;
        return id == that.id && status == that.status && systemId1 == that.systemId1 && systemId2 == that.systemId2 && Objects.equals(periodDate, that.periodDate) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, periodDate, createdAt, updatedAt, status, systemId1, systemId2);
    }
}
