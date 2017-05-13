package com.mit.lawyered.models;

import java.util.List;

/**
 * Created by Ahmed on 5/9/2017.
 */

public class ThirdParties extends User{
    private String tpid;

    private String mobile;
    private String office;
    private String description;
    private String revenueType;
    private String reviewAvg;
    private List<String> tags;

    public ThirdParties() {
    }

    public ThirdParties(String tpid, String id, String name,String mobile, String office,String description,  String revenueType,String reviewAvg) {
        super(id,name);
        this.tpid = tpid;
        this.mobile = mobile;
        this.office = office;
        this.description = description;
        this.revenueType = revenueType;
        this.reviewAvg = reviewAvg;

    }

    public String getTpid() {
        return tpid;
    }

    public void setTpid(String tpid) {
        this.tpid = tpid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }

    public String getReviewAvg() {
        return reviewAvg;
    }

    public void setReviewAvg(String reviewAvg) {
        this.reviewAvg = reviewAvg;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
