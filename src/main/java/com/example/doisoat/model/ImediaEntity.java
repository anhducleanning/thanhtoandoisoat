package com.example.doisoat.model;

public class ImediaEntity {
    private String taiKhoan;
    private String systemTrayId;
    private String menhGia;
    private String trangThai;
    private String ngayThang;
    private String requestID;
    private String phone;
    private String chietKhau;
    private String soLuong;
    private String nhaMang;

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getSystemTrayId() {
        return systemTrayId;
    }

    public void setSystemTrayId(String systemTrayId) {
        this.systemTrayId = systemTrayId;
    }

    public String getMenhGia() {
        return menhGia;
    }

    public void setMenhGia(String menhGia) {
        this.menhGia = menhGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(String ngayThang) {
        this.ngayThang = ngayThang;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(String chietKhau) {
        this.chietKhau = chietKhau;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaMang() {
        return nhaMang;
    }

    public void setNhaMang(String nhaMang) {
        this.nhaMang = nhaMang;
    }

    @Override
    public String toString() {
        return "ImediaModel{" +
                "taiKhoan='" + taiKhoan + '\'' +
                ", systemTrayId='" + systemTrayId + '\'' +
                ", menhGia='" + menhGia + '\'' +
                ", trangThai='" + trangThai + '\'' +
                ", ngayThang='" + ngayThang + '\'' +
                ", requestID='" + requestID + '\'' +
                ", phone='" + phone + '\'' +
                ", chietKhau='" + chietKhau + '\'' +
                ", soLuong='" + soLuong + '\'' +
                ", nhaMang='" + nhaMang + '\'' +
                '}';
    }
}
