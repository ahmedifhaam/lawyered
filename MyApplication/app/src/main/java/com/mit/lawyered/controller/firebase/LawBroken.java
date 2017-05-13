package com.mit.lawyered.controller.firebase;

/**
 * Created by ASUS on 5/13/2017.
 */

public class LawBroken {

    private String lbid;
    private String userId;
    private String lawId;
    private String description;

    public LawBroken(){

    }


    public String getLbid() {
        return lbid;
    }

    public void setLbid(String lbid) {
        this.lbid = lbid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLawId() {
        return lawId;
    }

    public void setLawId(String lawId) {
        this.lawId = lawId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
