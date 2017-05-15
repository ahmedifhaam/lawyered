package com.mit.lawyered.controller.firebase;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mit.lawyered.controller.adapter.OnResponse;
import com.mit.lawyered.models.ThirdParties;
import com.mit.lawyered.models.User;

/**
 * Created by ASUS on 5/13/2017.
 */

public class SignUpController {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private DatabaseReference mDatabaseThirdParty;
    boolean isSuccessful;
    OnResponse responder;

    public SignUpController(OnResponse onResponse, final User user){
        responder=onResponse;
        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference().child("users");
        mDatabaseThirdParty= FirebaseDatabase.getInstance().getReference().child("thirdParties");
        String email=user.getEmail();
        String password=user.getPassword();
        Log.d("Sign Up","Here 1");
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("Sign Up","Here 2");
                if(task.isSuccessful()) {
                    Log.d("Sign Up","Here");
                    String userID = mAuth.getCurrentUser().getUid();
                    user.setId(userID);
                    mDatabase.child(userID).setValue(user);

                    isSuccessful=true;
                    responder.responded(isSuccessful);
                }else{
                    isSuccessful=false;
                }





            }
        });


    }
    public SignUpController(OnResponse onResponse, final User user,final ThirdParties thirdParties){
        responder=onResponse;
        String email=user.getEmail();
        String password=user.getPassword();

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    String userID = mAuth.getCurrentUser().getUid();
                    user.setId(userID);
                    DatabaseReference current_user_db = mDatabase.child(userID);
                    current_user_db.setValue(user);

                    thirdParties.setTpid(userID);

                    mDatabaseThirdParty.child(userID).setValue(thirdParties);


                    isSuccessful=true;
                    responder.responded(isSuccessful);

                }else{
                    isSuccessful=false;
                }

            }
        });


    }






}
