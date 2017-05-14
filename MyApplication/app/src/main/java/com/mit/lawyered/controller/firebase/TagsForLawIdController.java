package com.mit.lawyered.controller.firebase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mit.lawyered.controller.adapter.OnResponse;
import com.mit.lawyered.models.ThirdParties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 5/13/2017.
 */

public class TagsForLawIdController {

    OnResponse response;

    public DatabaseReference mDatabaseTags;

    List<String>tagList=new ArrayList<>();



    List <ThirdParties> lawyers;

    public TagsForLawIdController(final OnResponse onResponder, String lawId){
        response=onResponder;
        mDatabaseTags= FirebaseDatabase.getInstance().getReference("laws").child(lawId).child("tags");


        mDatabaseTags.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                // Result will be holded Here
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                   tagList.add(String.valueOf(dsp.getValue())); //add result into array list


                }
                onResponder.responded(tagList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }



}
