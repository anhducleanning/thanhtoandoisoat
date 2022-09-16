package com.example.doisoat.dto;

public class LinkFilePartern {
    private String fileAtomi;
    private String fileImedia1;
    private String fileImedia2;

    public LinkFilePartern(String fileAtomi, String fileImedia1, String fileImedia2) {
        this.fileAtomi = fileAtomi;
        this.fileImedia1 = fileImedia1;
        this.fileImedia2 = fileImedia2;
    }

    public LinkFilePartern() {
    }

    public String getFileAtomi() {
        return fileAtomi;
    }

    public void setFileAtomi(String fileAtomi) {
        this.fileAtomi = fileAtomi;
    }

    public String getFileImedia1() {
        return fileImedia1;
    }

    public void setFileImedia1(String fileImedia1) {
        this.fileImedia1 = fileImedia1;
    }

    public String getFileImedia2() {
        return fileImedia2;
    }

    public void setFileImedia2(String fileImedia2) {
        this.fileImedia2 = fileImedia2;
    }
}
