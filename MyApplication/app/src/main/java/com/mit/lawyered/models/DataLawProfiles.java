package com.mit.lawyered.models;

/**
 * Created by Shani on 11/05/2017.
 */

public class DataLawProfiles {

    private String profile;
    private String description;
    private String rate;

    public DataLawProfiles (String text1, String text2, String text3){
        profile = text1;
        description = text2;
        rate = text3;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}