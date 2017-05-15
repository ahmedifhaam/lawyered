package com.mit.lawyered.controller.firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mit.lawyered.models.Notification;

/**
 * Created by ASUS on 5/15/2017.
 */

public class AcceptRequestController {
    DatabaseReference mAccept;
    FirebaseAuth mAuth;

    public AcceptRequestController(Notification notifi){
        mAccept= FirebaseDatabase.getInstance().getReference().child("notifications");
        mAuth=FirebaseAuth.getInstance();
        Notification notification=new Notification();
        notification.setLbid(notifi.getLbid());
        String email=mAuth.getCurrentUser().getEmail();
        int index = email.indexOf('@');
        email = email.substring(0,index);
        notification.setUserId(mAuth.getCurrentUser().getUid());
        notification.setStatus(0);
        notification.setType("caseAccept");
        notification.setLawBrokenDesc(notifi.getLawBrokenDesc());
        notification.setLawShortDesc(notifi.getLawShortDesc());
        notification.setDescription(email+" has accepted your case");
        notification.setLbid(notifi.getLbid());
        notification.setLawyerId(notifi.getUserId());

        String key=mAccept.push().getKey();
        mAccept.child(key).setValue(notification);
    }

}
