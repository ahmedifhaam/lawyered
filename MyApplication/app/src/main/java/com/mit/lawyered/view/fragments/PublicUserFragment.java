package com.mit.lawyered.view.fragments;

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
import com.mit.lawyered.controller.firebase.SignUpController;
import com.mit.lawyered.models.User;


public class PublicUserFragment extends Fragment {



    private EditText uname;
    private EditText pw;
    private EditText confirmPw;

    EditText name;
    EditText username;
    EditText password;
    EditText password2;

    ArrayAdapter<CharSequence> adapter;

    SignUpController signUpController;



    public PublicUserFragment() {
        // Required empty public constructor
        signUpController=new SignUpController();
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
        final EditText name = (EditText) root.findViewById(R.id.PublicName);
        final EditText username = (EditText) root.findViewById(R.id.PublicUname);
        final EditText password = (EditText) root.findViewById(R.id.PublicPassword);
        final EditText password2 = (EditText) root.findViewById(R.id.PublicConfirmPassword);

        userSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namestr = name.getText().toString();
                String usernamestr = username.getText().toString();
                String passwordstr = password.getText().toString();
                String password2str =password2.getText().toString();



                if (!passwordstr.equals(password2str)) {

                    Toast pass = Toast.makeText(getActivity(), "Passwords don't match!", Toast.LENGTH_SHORT);
                    pass.show();
                }
                else{
                    //insert details into DB
                   User user=new User();
                    user.setName(namestr);
                    user.setEmail(usernamestr);
                    user.setPassword(passwordstr);
                    signUpController.signUpForNormalUser(user);

                    //helper.insertContact(c);
                }
            }
        });






        return root;
    }


}
