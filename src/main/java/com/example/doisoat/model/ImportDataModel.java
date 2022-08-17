package com.example.doisoat.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "import_data")
public class ImportDataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "import_id", unique = true, nullable = false)
    private int id;

    @Column(name = "import_code")
    private String importCode;

    @Column(name = "import_type")
    private String importType;

    @Column(name = "system_code")
    private String systemCode;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "total_amount")
    private int totalAmount;

    @Column(name = "number_of_total")
    private int numberOfTotal;

    @Column(name = "number_of_success")
    private int numberOfSuccess;

    @Column(name = "number_of_fail")
    private int numberOfFail;

    @Column(name = "import_date")
    private Timestamp importDate;

    @Column(name = "import_by")
    private String importBy;

    @Column(name = "description")
    private String description;

    @Column(name = "order_no")
    private int orderNo;

    @Column(name = "period_date")
    private String periodDate;

    @Column(name = "action_code")
    private String actionCode;

    @Column(name = "status")
    private int status;

    @Column(name = "partner_system_id")
    private int partnerSystemId;

    @Column(name = "session_id")
    private int sessionId;

    @Column(name = "evidence_file")
    private String evidenceFile;
}
