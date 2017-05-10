package com.mit.lawyered.models;

/**
 * Created by Ahmed on 5/9/2017.
 */

public class ThirdParties extends User{
    private String tpid;
    private String userid;
    private String contactDetails;
    private String description;
    private String type;
    private String reviewAvg;
    private String individualOrOrg;
    private String[] tags;

    public ThirdParties() {
    }

    public ThirdParties(String tpid, String userid, String contactDetails, String description, String type, String reviewAvg, String individualOrOrg) {
        this.tpid = tpid;
        this.userid = userid;
        this.contactDetails = contactDetails;
        this.description = description;
        this.type = type;
        this.reviewAvg = reviewAvg;
        this.individualOrOrg = individualOrOrg;
    }

    public String getTpid() {
        return tpid;
    }

    public void setTpid(String tpid) {
        this.tpid = tpid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
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

    public String getReviewAvg() {
        return reviewAvg;
    }

    public void setReviewAvg(String reviewAvg) {
        this.reviewAvg = reviewAvg;
    }

    public String getIndividualOrOrg() {
        return individualOrOrg;
    }

    public void setIndividualOrOrg(String individualOrOrg) {
        this.individualOrOrg = individualOrOrg;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
