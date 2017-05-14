package com.mit.lawyered.controller.firebase;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mit.lawyered.controller.adapter.OnResponse;
import com.mit.lawyered.models.Notification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 5/14/2017.
 */

public class ReadNotificationController {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    OnResponse response;
    List<Notification> nList=new ArrayList<>();
    String id;
    public ReadNotificationController(OnResponse onResponder){
        response=onResponder;
        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference().child("notifications");
        id=mAuth.getCurrentUser().getUid();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot partyDataSnapshot : dataSnapshot.getChildren()) {
                    Log.d("NID","Snapshot");
                    Notification notification = partyDataSnapshot.getValue(Notification.class);
                    Log.d("NID",notification.getDescription()+"...1");
                    nList.add(notification);
                    Log.d("TPID","Snapshot2");
                }

                response.responded(nList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });


    }




}
