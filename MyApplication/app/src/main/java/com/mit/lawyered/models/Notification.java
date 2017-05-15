package com.mit.lawyered.models;

/**
 * Created by ASUS on 5/13/2017.
 */

public class Notification {
    private String nid;
    private String description;
    private String type;
    private String lbid;
    private String userId;
    private int status;
    private String lawBrokenDesc;
    private String lawShortDesc;
    private String lawyerId;

    public Notification(){

    }


    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLawBrokenDesc() {
        return lawBrokenDesc;
    }

    public void setLawBrokenDesc(String lawBrokenDesc) {
        this.lawBrokenDesc = lawBrokenDesc;
    }

    public String getLawShortDesc() {
        return lawShortDesc;
    }

    public void setLawShortDesc(String lawShortDesc) {
        this.lawShortDesc = lawShortDesc;
    }

    public String getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(String lawyerId) {
        this.lawyerId = lawyerId;
    }
}
