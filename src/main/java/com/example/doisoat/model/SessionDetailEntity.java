package com.example.doisoat.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "session_detail", schema = "doisoat_vv_te", catalog = "")
public class SessionDetailEntity {
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
    @Column(name = "action")
    private String action;
    @Basic
    @Column(name = "start_at")
    private Timestamp startAt;
    @Basic
    @Column(name = "finish_at")
    private Timestamp finishAt;
    @Basic
    @Column(name = "status")
    private byte status;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Timestamp getStartAt() {
        return startAt;
    }

    public void setStartAt(Timestamp startAt) {
        this.startAt = startAt;
    }

    public Timestamp getFinishAt() {
        return finishAt;
    }

    public void setFinishAt(Timestamp finishAt) {
        this.finishAt = finishAt;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
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
        SessionDetailEntity that = (SessionDetailEntity) o;
        return id == that.id && status == that.status && sessionId == that.sessionId && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(description, that.description) && Objects.equals(action, that.action) && Objects.equals(startAt, that.startAt) && Objects.equals(finishAt, that.finishAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, description, action, startAt, finishAt, status, sessionId);
    }
}
