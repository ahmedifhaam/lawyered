package com.mit.lawyered.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Shani on 11/05/2017.
 */

public class DataLawProfiles implements Parcelable{
    private String lawyerID;
    private String profile;
    private String description;
    private String rate;

    public DataLawProfiles (String lawyerID,String text1, String text2, String text3){
        this.lawyerID = lawyerID;
        profile = text1;
        description = text2;
        rate = text3;
    }

    protected DataLawProfiles(Parcel in) {
        lawyerID = in.readString();
        profile = in.readString();
        description = in.readString();
        rate = in.readString();

    }

    public static final Creator<DataLawProfiles> CREATOR = new Creator<DataLawProfiles>() {
        @Override
        public DataLawProfiles createFromParcel(Parcel in) {
            return new DataLawProfiles(in);
        }

        @Override
        public DataLawProfiles[] newArray(int size) {
            return new DataLawProfiles[size];
        }
    };

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

    public String getLawyerID() {
        return lawyerID;
    }

    public void setLawyerID(String lawyerID) {
        this.lawyerID = lawyerID;
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(lawyerID);
        dest.writeString(profile);
        dest.writeString(description);
        dest.writeString(rate);

    }
}