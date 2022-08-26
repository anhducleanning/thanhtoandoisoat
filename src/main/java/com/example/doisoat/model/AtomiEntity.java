package com.example.doisoat.model;

import javax.persistence.*;

@Entity
public class AtomiEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "compare_id")
    private int id;

    private String LV24H_REF_NO;
    private String ATMD_TRANS_ID;
    private String RESPONSE_CODE;
    private String DATETIME_LOG;
    private String TRANS_TYPE;
    private String CUSTOMER_CODE;
    private String SERVICE_CODE;
    private String SERVICE_PROVIDER;
    private String AMOUNT;
    private String RESPONSE_CODE_PROVIDER;
    private String PROVIDER_CODE;
    private String QUANTITY;
    private String PARTNER_TRANS_ID;


    public AtomiEntity( String LV24H_REF_NO, String ATMD_TRANS_ID, String RESPONSE_CODE, String DATETIME_LOG, String TRANS_TYPE, String CUSTOMER_CODE, String SERVICE_CODE, String SERVICE_PROVIDER, String AMOUNT, String RESPONSE_CODE_PROVIDER, String PROVIDER_CODE, String QUANTITY, String PARTNER_TRANS_ID) {

        this.LV24H_REF_NO = LV24H_REF_NO;
        this.ATMD_TRANS_ID = ATMD_TRANS_ID;
        this.RESPONSE_CODE = RESPONSE_CODE;
        this.DATETIME_LOG = DATETIME_LOG;
        this.TRANS_TYPE = TRANS_TYPE;
        this.CUSTOMER_CODE = CUSTOMER_CODE;
        this.SERVICE_CODE = SERVICE_CODE;
        this.SERVICE_PROVIDER = SERVICE_PROVIDER;
        this.AMOUNT = AMOUNT;
        this.RESPONSE_CODE_PROVIDER = RESPONSE_CODE_PROVIDER;
        this.PROVIDER_CODE = PROVIDER_CODE;
        this.QUANTITY = QUANTITY;
        this.PARTNER_TRANS_ID = PARTNER_TRANS_ID;

    }

    @Override
    public String toString() {
        return "AtomiEntity{" +
                ", LV24H_REF_NO='" + LV24H_REF_NO + '\'' +
                ", ATMD_TRANS_ID='" + ATMD_TRANS_ID + '\'' +
                ", RESPONSE_CODE='" + RESPONSE_CODE + '\'' +
                ", DATETIME_LOG='" + DATETIME_LOG + '\'' +
                ", TRANS_TYPE='" + TRANS_TYPE + '\'' +
                ", CUSTOMER_CODE='" + CUSTOMER_CODE + '\'' +
                ", SERVICE_CODE='" + SERVICE_CODE + '\'' +
                ", SERVICE_PROVIDER='" + SERVICE_PROVIDER + '\'' +
                ", AMOUNT='" + AMOUNT + '\'' +
                ", RESPONSE_CODE_PROVIDER='" + RESPONSE_CODE_PROVIDER + '\'' +
                ", PROVIDER_CODE='" + PROVIDER_CODE + '\'' +
                ", QUANTITY='" + QUANTITY + '\'' +
                ", PARTNER_TRANS_ID='" + PARTNER_TRANS_ID + '\'' +
                '}';
    }

    public AtomiEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLV24H_REF_NO() {
        return LV24H_REF_NO;
    }

    public void setLV24H_REF_NO(String LV24H_REF_NO) {
        this.LV24H_REF_NO = LV24H_REF_NO;
    }

    public String getATMD_TRANS_ID() {
        return ATMD_TRANS_ID;
    }

    public void setATMD_TRANS_ID(String ATMD_TRANS_ID) {
        this.ATMD_TRANS_ID = ATMD_TRANS_ID;
    }

    public String getRESPONSE_CODE() {
        return RESPONSE_CODE;
    }

    public void setRESPONSE_CODE(String RESPONSE_CODE) {
        this.RESPONSE_CODE = RESPONSE_CODE;
    }

    public String getDATETIME_LOG() {
        return DATETIME_LOG;
    }

    public void setDATETIME_LOG(String DATETIME_LOG) {
        this.DATETIME_LOG = DATETIME_LOG;
    }

    public String getTRANS_TYPE() {
        return TRANS_TYPE;
    }

    public void setTRANS_TYPE(String TRANS_TYPE) {
        this.TRANS_TYPE = TRANS_TYPE;
    }

    public String getCUSTOMER_CODE() {
        return CUSTOMER_CODE;
    }

    public void setCUSTOMER_CODE(String CUSTOMER_CODE) {
        this.CUSTOMER_CODE = CUSTOMER_CODE;
    }

    public String getSERVICE_CODE() {
        return SERVICE_CODE;
    }

    public void setSERVICE_CODE(String SERVICE_CODE) {
        this.SERVICE_CODE = SERVICE_CODE;
    }

    public String getSERVICE_PROVIDER() {
        return SERVICE_PROVIDER;
    }

    public void setSERVICE_PROVIDER(String SERVICE_PROVIDER) {
        this.SERVICE_PROVIDER = SERVICE_PROVIDER;
    }

    public String getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(String AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public String getRESPONSE_CODE_PROVIDER() {
        return RESPONSE_CODE_PROVIDER;
    }

    public void setRESPONSE_CODE_PROVIDER(String RESPONSE_CODE_PROVIDER) {
        this.RESPONSE_CODE_PROVIDER = RESPONSE_CODE_PROVIDER;
    }

    public String getPROVIDER_CODE() {
        return PROVIDER_CODE;
    }

    public void setPROVIDER_CODE(String PROVIDER_CODE) {
        this.PROVIDER_CODE = PROVIDER_CODE;
    }

    public String getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(String QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public String getPARTNER_TRANS_ID() {
        return PARTNER_TRANS_ID;
    }

    public void setPARTNER_TRANS_ID(String PARTNER_TRANS_ID) {
        this.PARTNER_TRANS_ID = PARTNER_TRANS_ID;
    }


}
