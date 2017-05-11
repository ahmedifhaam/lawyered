package com.mit.lawyered.view.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.mit.lawyered.R;
import com.mit.lawyered.controller.db.DatabaseHelper;
import com.mit.lawyered.models.Contact;


/**
 * Created by S.T.Sarma on 5/8/2017.
 */

public class SignUp extends Activity implements OnCheckedChangeListener {

    DatabaseHelper helper = new DatabaseHelper(this);

    private RadioGroup rg;
    private RadioButton rb;
    private EditText edit1;
    private EditText edit2;
    private String typestr;
    private String thirdtypestr;




    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        rg = (RadioGroup) findViewById(R.id.group1);
        rg.setOnCheckedChangeListener(this);
        edit1 = (EditText) findViewById(R.id.TFcontactdetails);
        edit2 = (EditText)findViewById(R.id.TFdiscreption);
        //actv(false);

        spinner = (Spinner)findViewById(R.id.spinner_select);
        //adapter = ArrayAdapter.createFromResource(this,R.array.legal_array,android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(adapter);
        /*spinner.setOnItemClickListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                thirdtypestr = parent.getItemAtPosition(pos).toString();
            }

            public void onNothingSelected(AdapterView parent) {
                // Do nothing.
            }
        });*/
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId)
    {
        switch (checkedId)
        {
            case R.id.Radioindividual:
                actv(false);
                typestr="i";
                break;

            case R.id.Radioorganization:
                actv(true);
                typestr="0";
                break;
        }
    }

    private void actv(final boolean active)
    {
        edit1.setEnabled(active);
        edit2.setEnabled(active);
        //spinner.setEnabled(active);
    }





    public void onSignupClick(View v) {


        if (v.getId() == R.id.BTNsignup) {

            int rbuttonid1 = rg.getCheckedRadioButtonId();
            rb = (RadioButton) findViewById(rbuttonid1);




            EditText name = (EditText) findViewById(R.id.TFname);
            EditText username = (EditText) findViewById(R.id.TFuname);
            EditText password = (EditText) findViewById(R.id.TFpass);
            EditText password2 = (EditText) findViewById(R.id.TFconfirmpassword);
            EditText contactDetail = (EditText) findViewById(R.id.TFcontactdetails);
            EditText description = (EditText) findViewById(R.id.TFdiscreption);

            String namestr = name.getText().toString();
            String usernamestr = username.getText().toString();
            String passwordstr = password.getText().toString();
            String password2str = password2.getText().toString();
            String contactstr = contactDetail.getText().toString();
            String discreptionstr = description.getText().toString();


            if (!passwordstr.equals(password2str)) {

                Toast pass = Toast.makeText(SignUp.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                pass.show();
            }
            else{
                //insert details into DB
                Contact c = new Contact();
                c.setName(namestr);
                c.setUname(usernamestr);
                c.setPass(passwordstr);
                c.setType(typestr);
                c.setContact(contactstr);
                c.setDescription(discreptionstr);
                c.setThirdtype(thirdtypestr);
                helper.insertContact(c);
            }

        }
    }
}