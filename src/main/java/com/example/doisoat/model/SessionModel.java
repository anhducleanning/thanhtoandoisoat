package com.example.doisoat.model;

import lombok.Data;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "session")
public class SessionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "period_date")
    private String periodDate;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    @LastModifiedDate
    @LastModifiedBy
    private Timestamp updated_at;

    @Column(name = "status")
    private int status;

    @Column(name = "system_id_1")
    private int SystemId1;

    @Column(name = "system_id_2")
    private int SystemId2;


}
