package com.example.doisoat.model;

public class ImediaBuyCardEntity {

    private String STT;
    private String thoiGian;
    private String nhaCungCap;
    private String menhGia;
    private String giaChietKhau;
    private String maYeuCau;
    private String maGiaoDich;
    private String seriThe;
    private String chietKhau;

    public ImediaBuyCardEntity(String STT, String thoiGian, String nhaCungCap, String menhGia, String giaChietKhau, String maYeuCau, String maGiaoDich, String seriThe, String chietKhau) {
        this.STT = STT;
        this.thoiGian = thoiGian;
        this.nhaCungCap = nhaCungCap;
        this.menhGia = menhGia;
        this.giaChietKhau = giaChietKhau;
        this.maYeuCau = maYeuCau;
        this.maGiaoDich = maGiaoDich;
        this.seriThe = seriThe;
        this.chietKhau = chietKhau;
    }

    @Override
    public String toString() {
        return "ImediaBuyCardEntity{" +
                "STT='" + STT + '\'' +
                ", thoiGian='" + thoiGian + '\'' +
                ", nhaCungCap='" + nhaCungCap + '\'' +
                ", menhGia='" + menhGia + '\'' +
                ", giaChietKhau='" + giaChietKhau + '\'' +
                ", maYeuCau='" + maYeuCau + '\'' +
                ", maGiaoDich='" + maGiaoDich + '\'' +
                ", seriThe='" + seriThe + '\'' +
                ", chietKhau='" + chietKhau + '\'' +
                '}';
    }

    public ImediaBuyCardEntity() {
    }

    public String getSTT() {
        return STT;
    }

    public void setSTT(String STT) {
        this.STT = STT;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public String getMenhGia() {
        return menhGia;
    }

    public void setMenhGia(String menhGia) {
        this.menhGia = menhGia;
    }

    public String getGiaChietKhau() {
        return giaChietKhau;
    }

    public void setGiaChietKhau(String giaChietKhau) {
        this.giaChietKhau = giaChietKhau;
    }

    public String getMaYeuCau() {
        return maYeuCau;
    }

    public void setMaYeuCau(String maYeuCau) {
        this.maYeuCau = maYeuCau;
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    public void setMaGiaoDich(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public String getSeriThe() {
        return seriThe;
    }

    public void setSeriThe(String seriThe) {
        this.seriThe = seriThe;
    }

    public String getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(String chietKhau) {
        this.chietKhau = chietKhau;
    }
}
