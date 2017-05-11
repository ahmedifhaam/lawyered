package com.mit.lawyered.models;

/**
 * Created by Ahmed on 5/10/2017.
 */

public class Law {
    private String lawId;
    private String title;
    private String shortDesc;
    private String fullDesc;

    public Law(String lawId, String title, String shortDesc, String fullDesc) {
        this.lawId = lawId;
        this.title = title;
        this.shortDesc = shortDesc;
        this.fullDesc = fullDesc;
    }

    public String getLawId() {
        return lawId;
    }

    public void setLawId(String lawId) {
        this.lawId = lawId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getFullDesc() {
        return fullDesc;
    }

    public void setFullDesc(String fullDesc) {
        this.fullDesc = fullDesc;
    }
}
