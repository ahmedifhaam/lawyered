package com.mit.lawyered.controller.firebase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mit.lawyered.controller.adapter.OnResponseLaw;
import com.mit.lawyered.models.Law;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 5/12/2017.
 */

public  class LawController {

    List<Law> laws = new ArrayList<>();
    private static final String TAG = "ControlTest";

    public static final String EXTRA_POST_KEY = "post_key";
    public DatabaseReference mDatabaseLaw;
    public OnResponseLaw response;

    boolean isLawsaved;
    Law law;

    public LawController(OnResponseLaw responder){
        response=responder;
        mDatabaseLaw= FirebaseDatabase.getInstance().getReference().child("laws");
        mDatabaseLaw.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot partyDataSnapshot : dataSnapshot.getChildren()) {
                    Law law = partyDataSnapshot.getValue(Law.class);
                    laws.add(law);
                }
                response.respondedLaw(laws);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }
    public LawController(OnResponseLaw responder, final String lawId){
        response=responder;
        mDatabaseLaw= FirebaseDatabase.getInstance().getReference().child("laws");
        mDatabaseLaw.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot partyDataSnapshot : dataSnapshot.getChildren()) {
                    if (partyDataSnapshot.getKey().equals(lawId)){
                       law= partyDataSnapshot.getValue(Law.class);
                    }
                }
                response.respondedLaw(law);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }

    public DatabaseReference getmDatabaseThirdParty(){
        return mDatabaseLaw;
    }


    public boolean saveLaw(String title,String smallDesc,String fullDesc,List<String>tags){
        Law law=new Law();
        String key=mDatabaseLaw.push().getKey();
        law.setLawId(key);
        law.setTitle(title);
        law.setShortDesc(smallDesc);
        law.setFullDesc(fullDesc);
        law.setTags(tags);

        mDatabaseLaw.child(key).setValue(law);


        return true;
    }

}
