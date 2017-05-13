package com.mit.lawyered.controller.firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mit.lawyered.models.LawBroken;
import com.mit.lawyered.models.Notification;

/**
 * Created by ASUS on 5/13/2017.
 */

public class SaveLawBrokenController {

    public DatabaseReference mDatabaseLawBroken;
    public DatabaseReference mDatabaseNotification;
    private FirebaseAuth mAuth;

    public SaveLawBrokenController(){
        mDatabaseLawBroken= FirebaseDatabase.getInstance().getReference().child("lawBroken");
        mDatabaseNotification= FirebaseDatabase.getInstance().getReference().child("notifications");
        mAuth=FirebaseAuth.getInstance();
    }

    public void saveLawBrokenNotification(String lawId,String description){
        String userID=mAuth.getCurrentUser().getUid();
        String lbID=mDatabaseLawBroken.push().getKey();

        LawBroken lb=new LawBroken();
        lb.setLawId(lawId);
        lb.setDescription(description);
        lb.setUserId(userID);
        lb.setLbid(lbID);

        mDatabaseLawBroken.child(lbID).setValue(lb);

        String key=mDatabaseNotification.push().getKey();

        Notification notification=new Notification();
        notification.setLbid(lbID);

        String email=mAuth.getCurrentUser().getEmail();
        int index = email.indexOf('@');
        email = email.substring(0,index);
        notification.setDescription("User "+email+" has brought up a case");
        notification.setType("caseRequest");
        notification.setNid(key);
        mDatabaseNotification.child(key).setValue(notification);

    }

}
