package com.example.doisoat.model;

public class TransEntity {
    private String ID;
    private String TRANS_ID;
    private String DATETIME_LOG;
    private String TRANG_THAI;

    private int AMOUNT;

    private String SERVICE_CODE;

    public TransEntity(String ID, String TRANS_ID, String DATETIME_LOG, String TRANG_THAI, int AMOUNT, String SERVICE_CODE) {
        this.ID = ID;
        this.TRANS_ID = TRANS_ID;
        this.DATETIME_LOG = DATETIME_LOG;
        this.TRANG_THAI = TRANG_THAI;
        this.AMOUNT = AMOUNT;
        this.SERVICE_CODE = SERVICE_CODE;
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

    public String getTRANG_THAI() {
        return TRANG_THAI;
    }

    public void setTRANG_THAI(String TRANG_THAI) {
        this.TRANG_THAI = TRANG_THAI;
    }

    public int getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(int AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public String getSERVICE_CODE() {
        return SERVICE_CODE;
    }

    public void setSERVICE_CODE(String SERVICE_CODE) {
        this.SERVICE_CODE = SERVICE_CODE;
    }

    @Override
    public String toString() {
        return "TransEntity{" +
                "ID='" + ID + '\'' +
                ", TRANS_ID='" + TRANS_ID + '\'' +
                ", DATETIME_LOG='" + DATETIME_LOG + '\'' +
                ", TRANG_THAI='" + TRANG_THAI + '\'' +
                ", AMOUNT='" + AMOUNT + '\'' +
                ", SERVICE_CODE='" + SERVICE_CODE + '\'' +
                '}';
    }
}
