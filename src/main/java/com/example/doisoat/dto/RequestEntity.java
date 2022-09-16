package com.example.doisoat.dto;

public class RequestEntity {
    private String linkAtomi;
    private String linkImedia1;
    private String getLinkImedia2;
    private String periodDate;

    public RequestEntity(String linkAtomi, String linkImedia1, String getLinkImedia2, String periodDate) {
        this.linkAtomi = linkAtomi;
        this.linkImedia1 = linkImedia1;
        this.getLinkImedia2 = getLinkImedia2;
        this.periodDate = periodDate;
    }

    public RequestEntity() {
    }

    public String getLinkAtomi() {
        return linkAtomi;
    }

    public void setLinkAtomi(String linkAtomi) {
        this.linkAtomi = linkAtomi;
    }

    public String getLinkImedia1() {
        return linkImedia1;
    }

    public void setLinkImedia1(String linkImedia1) {
        this.linkImedia1 = linkImedia1;
    }

    public String getGetLinkImedia2() {
        return getLinkImedia2;
    }

    public void setGetLinkImedia2(String getLinkImedia2) {
        this.getLinkImedia2 = getLinkImedia2;
    }

    public String getPeriodDate() {
        return periodDate;
    }

    public void setPeriodDate(String periodDate) {
        this.periodDate = periodDate;
    }
}
