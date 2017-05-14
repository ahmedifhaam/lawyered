package com.mit.lawyered.controller.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by ASUS on 5/13/2017.
 */

public class LawsForTagController {

    DatabaseReference mDatabaseLawsForTags;

    public LawsForTagController(){
        mDatabaseLawsForTags= FirebaseDatabase.getInstance().getReference().child("laws");
    }

    public List<String> getAllLawDescFortags(List<String>  tagList){
        return null;
    }
}
