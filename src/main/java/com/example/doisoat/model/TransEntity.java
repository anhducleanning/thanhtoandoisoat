package com.example.doisoat.model;

public class TransEntity {
    private String ID;
    private String TRANS_ID;
    private String DATETIME_LOG;
    private String CUSTOMER_CODE;


    public TransEntity(String ID, String TRANS_ID, String DATETIME_LOG, String CUSTOMER_CODE) {
        this.ID = ID;
        this.TRANS_ID = TRANS_ID;
        this.DATETIME_LOG = DATETIME_LOG;
        this.CUSTOMER_CODE = CUSTOMER_CODE;
    }

    @Override
    public String toString() {
        return "TransEntity{" +
                "ID='" + ID + '\'' +
                ", TRANS_ID='" + TRANS_ID + '\'' +
                ", DATETIME_LOG='" + DATETIME_LOG + '\'' +
                ", CUSTOMER_CODE='" + CUSTOMER_CODE + '\'' +
                '}';
    }

    public TransEntity() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTRANS_ID() {
        return TRANS_ID;
    }

    public void setTRANS_ID(String TRANS_ID) {
        this.TRANS_ID = TRANS_ID;
    }

    public String getDATETIME_LOG() {
        return DATETIME_LOG;
    }

    public void setDATETIME_LOG(String DATETIME_LOG) {
        this.DATETIME_LOG = DATETIME_LOG;
    }

    public String getCUSTOMER_CODE() {
        return CUSTOMER_CODE;
    }

    public void setCUSTOMER_CODE(String CUSTOMER_CODE) {
        this.CUSTOMER_CODE = CUSTOMER_CODE;
    }
}
