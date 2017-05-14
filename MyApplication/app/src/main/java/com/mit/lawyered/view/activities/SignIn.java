package com.mit.lawyered.view.activities;

/**
 * Created by Ahmed on 5/11/2017.
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mit.lawyered.R;
import com.mit.lawyered.controller.db.DatabaseHelper;


public class SignIn extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private EditText mLoginEmailField;
    private EditText mLoginPasswordField;
    private Button mLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference().child("users");
        mLoginEmailField=(EditText)findViewById(R.id.TFuname);
        mLoginPasswordField=(EditText)findViewById(R.id.TFpass);
                        mLoginBtn=(Button)findViewById(R.id.BTNsignin);

                        mLoginBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                checkLogIn();
                            }
                        });


                    }

                private void checkLogIn() {
                    String email=mLoginEmailField.getText().toString().trim();
                    String password=mLoginPasswordField.getText().toString().trim();

                    if(!TextUtils.isEmpty(email)&& !TextUtils.isEmpty(password)){
                        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                 checkUserExist();
                    }else{
                        Toast.makeText(SignIn.this, "Please Sign Up", Toast.LENGTH_SHORT).show();
                        Intent mainIntent=new Intent(SignIn.this,TabActivitySignUp.class);
                        mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(mainIntent);
                    }
                }
            });
        }
    }

    private void checkUserExist() {
        final String user_id=mAuth.getCurrentUser().getUid();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(user_id)){
                    Intent mainIntent=new Intent(SignIn.this,Home.class);
                    Toast.makeText(SignIn.this, "Signing in", Toast.LENGTH_SHORT).show();
                    mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(mainIntent);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(SignIn.this, "Error LogIn", Toast.LENGTH_SHORT).show();

            }
        });
    }

    /*public void onButtonClick(View v) {

        if (v.getId() == R.id.BTNsignin)

        {
            EditText uname = (EditText) findViewById(R.id.TFuname);
            String unamestr = uname.getText().toString();

            EditText pass = (EditText) findViewById(R.id.TFpass);
            String passstr = pass.getText().toString();

            String password = helper.searchpass(unamestr);
            if(passstr.equals(password)){

                //code for open new activity
            }

            else{
                Toast t = Toast.makeText(SignIn.this, "Wrong Username password combination!", Toast.LENGTH_SHORT);
                t.show();

            }

        }

    }
*/
    public void onClick(View v) {

        if (v.getId() == R.id.TVsignup) {

            Intent myIntent = new Intent(SignIn.this, TabActivitySignUp.class);
            startActivity(myIntent);

        }

    }

}