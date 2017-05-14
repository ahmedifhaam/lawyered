package com.mit.lawyered.controller.firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mit.lawyered.models.LawBroken;
import com.mit.lawyered.models.Notification;
import com.mit.lawyered.models.ThirdParties;

import java.util.List;

/**
 * Created by ASUS on 5/14/2017.
 */

public class SaveNewCaseRequestNotification {

    DatabaseReference mDatabaseLawBroken;
    DatabaseReference mDatabaseNotification;
    FirebaseAuth mAuth;

    public SaveNewCaseRequestNotification(String lawId,String description, List<ThirdParties> thirdPartiesList){
        String cureentUID=mAuth.getCurrentUser().getUid();

        mDatabaseLawBroken= FirebaseDatabase.getInstance().getReference().child("lawBroken");
        mDatabaseNotification= FirebaseDatabase.getInstance().getReference().child("notifications");
        LawBroken lawBroken=new LawBroken();
        lawBroken.setLawId(lawId);
        lawBroken.setDescription(description);
        lawBroken.setUserId(cureentUID);

        String key=mDatabaseLawBroken.push().getKey();
        lawBroken.setLbid(key);
        mDatabaseLawBroken.child(key).setValue(lawBroken);


        for (ThirdParties party:thirdPartiesList) {
            Notification notification=new Notification();
            notification.setLbid(key);
            notification.setUserId(party.getTpid());
            notification.setStatus(0);
            notification.setType("caseRequest");
            notification.setDescription(party.getName()+" has brought up a case");
            String keyN=mDatabaseNotification.push().getKey();
            mDatabaseNotification.child(keyN).setValue(notification);
        }

    }
}
