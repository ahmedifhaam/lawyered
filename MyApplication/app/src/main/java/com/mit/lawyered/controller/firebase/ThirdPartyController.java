package com.mit.lawyered.controller.firebase;

import android.util.Log;

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
 * Created by ASUS on 5/12/2017.
 */

public  class ThirdPartyController {

    List<ThirdParties> parties = new ArrayList<>();
    private static final String TAG = "ControlTest";

    public static final String EXTRA_POST_KEY = "post_key";
    public DatabaseReference mDatabaseThirdParty;
    public OnResponse response;

    public ThirdPartyController(OnResponse responder){
        response = responder;
        mDatabaseThirdParty= FirebaseDatabase.getInstance().getReference().child("thirdParties");
        mDatabaseThirdParty.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot partyDataSnapshot : dataSnapshot.getChildren()) {
                    Log.d("TPID","Snapshot");
                    ThirdParties thirdParty = partyDataSnapshot.getValue(ThirdParties.class);
                    Log.d("TPID",thirdParty.getTpid()+"...1");
                    parties.add(thirdParty);
                    Log.d("TPID","Snapshot2");
                }

                response.responded(parties);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }

    public DatabaseReference getmDatabaseThirdParty(){
        return mDatabaseThirdParty;
    }

    public List<ThirdParties> getAllThirdParties(){




        return parties;


    }


}
