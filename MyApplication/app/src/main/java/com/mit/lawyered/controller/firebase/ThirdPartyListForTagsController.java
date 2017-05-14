package com.mit.lawyered.controller.firebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mit.lawyered.controller.adapter.OnResponseThirdParties;
import com.mit.lawyered.models.ThirdParties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ASUS on 5/14/2017.
 */

public class ThirdPartyListForTagsController {
    DatabaseReference mDatabaseLaw;

    List<ThirdParties> lawyerDescList=new ArrayList<>();
    public OnResponseThirdParties response;
    List <String> list;

    public ThirdPartyListForTagsController(OnResponseThirdParties responder, final List<String>list){
        mDatabaseLaw= FirebaseDatabase.getInstance().getReference("thirdParties");
        this.list=list;
        response=responder;
        mDatabaseLaw.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot lawDataSnapshot : dataSnapshot.getChildren()) {
                    ThirdParties thirdParties= lawDataSnapshot.getValue(ThirdParties.class);
                    List<String>tags=thirdParties.getTags();
                    if(!Collections.disjoint(tags,list)){

                        lawyerDescList.add(thirdParties);

                    }
                }
                Log.d("LAWYERSIZE",lawyerDescList.size()+"");
                response.respondedThird(lawyerDescList);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }
}
