package com.mit.lawyered.controller.firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mit.lawyered.controller.adapter.OnResponse;
import com.mit.lawyered.models.LocationRules;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 5/15/2017.
 */

public class LocationController {
    DatabaseReference mRules;
    FirebaseAuth mAuth;
    OnResponse response;
   List<LocationRules>lsList=new ArrayList<>();

    public LocationController(OnResponse responder){
        mRules= FirebaseDatabase.getInstance().getReference().child("lsRules");
        mAuth=FirebaseAuth.getInstance();

        response = responder;

     mRules.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ruleDataSnapshot : dataSnapshot.getChildren()) {

                LocationRules locationRules=ruleDataSnapshot.getValue(LocationRules.class);
                    lsList.add(locationRules);
                }

                response.responded(lsList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }

}
