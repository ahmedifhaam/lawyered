package com.mit.lawyered.controller.firebase;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.mit.lawyered.controller.adapter.OnResponseLaw;
import com.mit.lawyered.models.Law;
import com.mit.lawyered.models.LawBroken;
import com.mit.lawyered.models.Notification;

/**
 * Created by ASUS on 5/15/2017.
 */

public class FindLawBrokenController  {
    OnResponseLaw responder;
    DatabaseReference mDatabase;
    DatabaseReference mDatabaseStatus;
    Notification n;
    Law law;


    public FindLawBrokenController(OnResponseLaw onResponseLaw, final LawBroken lawBroken,Notification nn){
        responder=onResponseLaw;
        this.n=nn;

        mDatabase= FirebaseDatabase.getInstance().getReference().child("laws");
        mDatabaseStatus=FirebaseDatabase.getInstance().getReference().child("notifications");


        Query mQuery =mDatabase.orderByChild("lawId").equalTo(lawBroken.getLawId());
        mQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                law=dataSnapshot.getValue(Law.class);
                mDatabaseStatus.child(n.getNid()).child("lawShortDesc").setValue(law.getShortDesc());


                // n.setLawShortDesc(law.getShortDesc());

                responder.respondedLaw(law);

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
