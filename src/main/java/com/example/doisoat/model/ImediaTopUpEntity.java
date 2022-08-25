package com.example.doisoat.model;

public class ImediaTopUpEntity {

    private String STT;
    private String thoiGian;
    private String nhaCungCap;
    private String menhGia;
    private String giaChietKhau;
    private String maYeuCau;
    private String maGiaoDich;
    private String trangThai;
    private String taiKhoanDich;

    public ImediaTopUpEntity(String STT, String thoiGian, String nhaCungCap, String menhGia, String giaChietKhau, String maYeuCau, String maGiaoDich, String trangThai, String taiKhoanDich) {
        this.STT = STT;
        this.thoiGian = thoiGian;
        this.nhaCungCap = nhaCungCap;
        this.menhGia = menhGia;
        this.giaChietKhau = giaChietKhau;
        this.maYeuCau = maYeuCau;
        this.maGiaoDich = maGiaoDich;
        this.trangThai = trangThai;
        this.taiKhoanDich = taiKhoanDich;
    }

    public ImediaTopUpEntity() {
    }

    @Override
    public String toString() {
        return "ImediaTopUpEntity{" +
                "STT='" + STT + '\'' +
                ", thoiGian='" + thoiGian + '\'' +
                ", nhaCungCap='" + nhaCungCap + '\'' +
                ", menhGia='" + menhGia + '\'' +
                ", giaChietKhau='" + giaChietKhau + '\'' +
                ", maYeuCau='" + maYeuCau + '\'' +
                ", maGiaoDich='" + maGiaoDich + '\'' +
                ", trangThai='" + trangThai + '\'' +
                ", taiKhoanDich='" + taiKhoanDich + '\'' +
                '}';
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTaiKhoanDich() {
        return taiKhoanDich;
    }

    public void setTaiKhoanDich(String taiKhoanDich) {
        this.taiKhoanDich = taiKhoanDich;
    }
}
