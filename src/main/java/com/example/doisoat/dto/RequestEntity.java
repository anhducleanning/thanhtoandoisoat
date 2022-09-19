package com.example.doisoat.dto;

public class RequestEntity {

    private String periodDate;
    private String dateStart;
    private String dateEnd;

    private String linkFileSave;

    public RequestEntity(String periodDate, String dateStart, String dateEnd, String linkFileSave) {
        this.periodDate = periodDate;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.linkFileSave = linkFileSave;
    }

    public RequestEntity() {
    }

    public String getPeriodDate() {
        return periodDate;
    }

    public void setPeriodDate(String periodDate) {
        this.periodDate = periodDate;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getLinkFileSave() {
        return linkFileSave;
    }

    public void setLinkFileSave(String linkFileSave) {
        this.linkFileSave = linkFileSave;
    }
}
