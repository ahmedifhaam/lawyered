package com.mit.lawyered.models;

/**
 * Created by ASUS on 5/13/2017.
 */

public class Notification {
    private String nid;
    private String description;
    private String type;
    private String lbid;

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
}
