package com.mit.lawyered.controller.firebase;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.mit.lawyered.controller.adapter.OnResponse;
import com.mit.lawyered.models.Law;
import com.mit.lawyered.models.LawBroken;
import com.mit.lawyered.models.Notification;

/**
 * Created by ASUS on 5/14/2017.
 */

public class LawBrokenForNotificationController {

    OnResponse responder;
    DatabaseReference mDatabase;
    DatabaseReference mDatabaseStatus;
     Notification notification;
    LawBroken lawbroken;
    Law law;


    public LawBrokenForNotificationController(OnResponse onResponse, Notification notification){
        responder=onResponse;
        this.notification=notification;
        mDatabase= FirebaseDatabase.getInstance().getReference().child("lawBroken");
        mDatabaseStatus= FirebaseDatabase.getInstance().getReference().child("notifications").child(notification.getNid()).child("status");

        mDatabaseStatus.setValue(1);
        Query mQuery =mDatabase.orderByChild("lbid").equalTo(notification.getLbid());
        mQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                lawbroken=dataSnapshot.getValue(LawBroken.class);
                responder.responded(lawbroken);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
