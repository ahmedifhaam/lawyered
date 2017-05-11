package com.mit.lawyered.view.activities;

/**
 * Created by Ahmed on 5/11/2017.
 */


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mit.lawyered.R;
import com.mit.lawyered.controller.db.DatabaseHelper;


public class SignIn extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


    }

    public void onButtonClick(View v) {

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

    public void onClick(View v) {

        if (v.getId() == R.id.TVsignup) {

            Intent myIntent = new Intent(SignIn.this,SignUp.class);
            startActivity(myIntent);

        }
    }


}