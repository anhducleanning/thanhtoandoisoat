package com.example.doisoat.dto;

public class DataDetail {
    private int totalAtomi;
    private int totalImedia;
    private int totalNotSameAtomi;
    private int totalNotSameImedia;

    public DataDetail(int totalAtomi, int totalImedia, int totalNotSameAtomi, int totalNotSameImedia) {
        this.totalAtomi = totalAtomi;
        this.totalImedia = totalImedia;
        this.totalNotSameAtomi = totalNotSameAtomi;
        this.totalNotSameImedia = totalNotSameImedia;
    }

    public DataDetail() {
    }

    public int getTotalAtomi() {
        return totalAtomi;
    }

    public void setTotalAtomi(int totalAtomi) {
        this.totalAtomi = totalAtomi;
    }

    public int getTotalImedia() {
        return totalImedia;
    }

    public void setTotalImedia(int totalImedia) {
        this.totalImedia = totalImedia;
    }

    public int getTotalNotSameAtomi() {
        return totalNotSameAtomi;
    }

    public void setTotalNotSameAtomi(int totalNotSameAtomi) {
        this.totalNotSameAtomi = totalNotSameAtomi;
    }

    public int getTotalNotSameImedia() {
        return totalNotSameImedia;
    }

    public void setTotalNotSameImedia(int totalNotSameImedia) {
        this.totalNotSameImedia = totalNotSameImedia;
    }
}
