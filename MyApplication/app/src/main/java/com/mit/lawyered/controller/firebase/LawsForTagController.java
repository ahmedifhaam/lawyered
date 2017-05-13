package com.mit.lawyered.controller.firebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mit.lawyered.controller.adapter.OnResponse;
import com.mit.lawyered.models.Law;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ASUS on 5/13/2017.
 */

public class LawsForTagController {

    DatabaseReference mDatabaseLaw;

    List<Law>lawDescList=new ArrayList<>();
    public OnResponse response;
    List <String> list;

    public LawsForTagController(OnResponse responder, final List<String>list){
        mDatabaseLaw= FirebaseDatabase.getInstance().getReference("laws");
        this.list=list;
        response=responder;
        mDatabaseLaw.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot lawDataSnapshot : dataSnapshot.getChildren()) {
                    Law law= lawDataSnapshot.getValue(Law.class);
                    List<String>tags=law.getTags();
                    if(!Collections.disjoint(tags,list)){
                        law.setFullDesc(null);
                        lawDescList.add(law);

                    }
                }
                Log.d("LAWSIZE",lawDescList.size()+"");
                response.responded(lawDescList);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }

    public List<Law> getAllLawDescFortags(){

        return lawDescList;
    }

}
