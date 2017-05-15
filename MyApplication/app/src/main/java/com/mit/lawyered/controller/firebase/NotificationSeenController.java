package com.mit.lawyered.controller.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mit.lawyered.models.Notification;

/**
 * Created by ASUS on 5/15/2017.
 */

public class NotificationSeenController {
    DatabaseReference mNotify;

    public NotificationSeenController(Notification notification){
        mNotify= FirebaseDatabase.getInstance().getReference().child("notifications");
        mNotify.child(notification.getNid()).child("status").setValue(1);
    }
}
