package com.mit.lawyered.controller.firebase;

import android.location.Location;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mit.lawyered.controller.adapter.OnResponse;
import com.mit.lawyered.models.LocationRules;
import com.mit.lawyered.models.Notification;

import java.util.List;

/**
 * Created by ASUS on 5/15/2017.
 */

public class DistanceCheckerController implements OnResponse {

    List<LocationRules>list;
    LocationRules locationRules;
    Location location;
    LocationController locationController;
    FirebaseAuth mAuth;
    DatabaseReference mData;

    double long1;
    double lati1;
    double long2;
    double lati2;

    public DistanceCheckerController(Location location){

        mAuth=FirebaseAuth.getInstance();
        locationController=new LocationController(this);
        long1=location.getLongitude();
        lati1=location.getLatitude();
        mData= FirebaseDatabase.getInstance().getReference("notifications");

    }
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts decimal degrees to radians             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts radians to decimal degrees             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    @Override
    public void responded(Object location) {

        list=(List<LocationRules>)location;
        for (LocationRules locationRules:list) {
            if(checkLocation(locationRules.getLongitude(),locationRules.getLatitude())){
                Notification notification=new Notification();
                notification.setStatus(0);
                notification.setUserId(mAuth.getCurrentUser().getUid());
                notification.setLawyerId("");
                notification.setDescription(locationRules.getFullDesc());
                notification.setLbid(locationRules.getLid());
                notification.setLawShortDesc(locationRules.getShortDesc());
                notification.setType("location");
                notification.setLawBrokenDesc("");

                String key=mData.push().getKey();
                notification.setNid(key);
                mData.child(key).setValue(notification);
            }
        }

    }

    public boolean checkLocation(double lo2,double la2){
        final int R = 6371; // Radius of the earth

        double theta = long1 - lo2;
        double dist = Math.sin(deg2rad(lati1)) * Math.sin(deg2rad(la2)) + Math.cos(deg2rad(lati1)) * Math.cos(deg2rad(la2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;

            dist = dist * 1.609344;
        if(dist<=locationRules.getRadius()){
            return true;
        }
        return false;
    }
}
