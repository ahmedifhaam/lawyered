package com.mit.lawyered.controller.firebase;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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

    public SignUpController(){
        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference().child("users");
        mDatabaseThirdParty= FirebaseDatabase.getInstance().getReference().child("thirdParties");
    }

    public boolean signUpForNormalUser(final User user){

        String email=user.getEmail();
        String password=user.getPassword();
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    String userID = mAuth.getCurrentUser().getUid();
                    DatabaseReference current_user_db = mDatabase.child(userID);
                    current_user_db.setValue(user);

                    isSuccessful=true;

                }else{
                    isSuccessful=false;
                }





            }
        });
        return isSuccessful;
    }

    public boolean signUpForThirdParty(final User user,final ThirdParties thirdParties){
        String email=user.getEmail();
        String password=user.getPassword();
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    String userID = mAuth.getCurrentUser().getUid();
                    DatabaseReference current_user_db = mDatabase.child(userID);
                    current_user_db.setValue(user);

                        mDatabaseThirdParty.child(userID).setValue(thirdParties);


                    isSuccessful=true;

                }else{
                    isSuccessful=false;
                }
            }
        });

        return isSuccessful;
    }

}
