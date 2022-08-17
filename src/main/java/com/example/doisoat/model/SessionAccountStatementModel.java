package com.example.doisoat.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "session_account_statement")
public class SessionAccountStatementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "acc_branch")
    private String accBranch;

    @Column(name = "acc_name")
    private String accName;

    @Column(name = "account_no")
    private String accountNo;

    @Column(name = "customer_no")
    private String customerNo;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "trn_date")
    private Timestamp trnDate;

    @Column(name = "value_date")
    private Timestamp valueDate;

    @Column(name = "check_time")
    private Timestamp checkTime;

    @Column(name = "trn_ref_no")
    private String trnRefNo;

    @Column(name = "narrative")
    private String narrative;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "drcr")
    private String drcr;

    @Column(name = "open_balance")
    private int openBalance;

    @Column(name = "close_balance")
    private int closeBalance;

    @Column(name = "current_balance")
    private int currentBalance;

    @Column(name = "session_id")
    private int sessionId;
}
