package com.mit.lawyered.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mit.lawyered.R;
import com.mit.lawyered.models.User;


public class PublicUserFragment extends Fragment {


    private EditText name;
    private EditText uname;
    private EditText pw;
    private EditText confirmPw;
    ArrayAdapter<CharSequence> adapter;



    public PublicUserFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_public_user, container, false);

        Button userSignUp = (Button) root.findViewById(R.id.btnUserSignUp);

        userSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSignupClick(v);
            }
        });

        return root;
    }

    public void onSignupClick(View v) {


        if (v.getId() == R.id.btnUserSignUp) {

            EditText name = (EditText) v.findViewById(R.id.PublicName);
            EditText username = (EditText) v.findViewById(R.id.PublicUname);
            EditText password = (EditText) v.findViewById(R.id.PublicPassword);
            EditText password2 = (EditText) v.findViewById(R.id.PublicConfirmPassword);

            String namestr = name.getText().toString();
            String usernamestr = username.getText().toString();
            String passwordstr = password.getText().toString();
            String password2str = password2.getText().toString();



            if (!passwordstr.equals(password2str)) {

                Toast pass = Toast.makeText(getActivity(), "Passwords don't match!", Toast.LENGTH_SHORT);
                pass.show();
            }
            else{
                //insert details into DB
                User user = new User();
                user.setName(namestr);
                user.setUsername(usernamestr);
                user.setPassword(passwordstr);


                //helper.insertContact(c);
            }

        }
    }
}
