package com.mit.lawyered.view.fragments;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mit.lawyered.R;
import com.mit.lawyered.controller.firebase.SignUpController;
import com.mit.lawyered.models.ThirdParties;
import com.mit.lawyered.models.User;
import com.taglib.Tag;
import com.taglib.TagView;

import java.util.ArrayList;
import java.util.List;


public class LegalPartyFragment extends Fragment  {


    String revType;
    String[] tags = {"Criminal", "Environmental","Childcare","Abuse", "Corruption"};
    ArrayList<String> list = new ArrayList<String>();


    private EditText luname;
    private EditText lpw;
    private EditText lconfirmPw;
    ArrayAdapter<CharSequence> adapter;
    ThirdParties thirdParties;
    TagView tagGroup;
    AutoCompleteTextView actv;
    String tag;
    List<String> tagList=new ArrayList<String>();
    SignUpController signUpController;

    //controls

    EditText lname ;
    EditText lusername;
    EditText lpassword;
    EditText lpassword2;
    EditText lMobile;
    EditText lOffice;
    EditText lDescr;

    public LegalPartyFragment() {
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

        View view = inflater.inflate(R.layout.fragment_legal_party, container, false);

        Button lPartySignUp = (Button) view.findViewById(R.id.btnLPartySignUp);

      lname = (EditText) view.findViewById(R.id.LegalName);
      lusername = (EditText) view.findViewById(R.id.LegalUname);
         lpassword = (EditText) view.findViewById(R.id.LegalPassword);
      lpassword2 = (EditText) view.findViewById(R.id.LegalConfirmPassword);
         lMobile = (EditText) view.findViewById(R.id.LegalMobile);
      lOffice = (EditText) view.findViewById(R.id.LegalOffice);
      lDescr = (EditText) view.findViewById(R.id.profileDescription);




        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getActivity(),android.R.layout.select_dialog_item,tags);

        //Getting the instance of AutoCompleteTextView
        actv= (AutoCompleteTextView)view.findViewById(R.id.searchTags);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        Log.d("Selected","Adapter set");
        tagGroup=(TagView)view.findViewById(R.id.tag_group);


        RadioGroup rg = (RadioGroup) view.findViewById(R.id.radioGroup);
        //RadioGroup.OnCheckedChangeListener listener = null;

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                revType = ((RadioButton)group.findViewById(checkedId)).getText().toString();
            }
        });



        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int pos,
                                    long id) {
                String tagText=actv.getText().toString();
                Toast.makeText(getActivity(),tagText, Toast.LENGTH_LONG).show();

                //Adding tags to the third party tag list should set it to model object
                tagList.add(tagText);
                Tag tag = new Tag(tagText);
                tag.tagTextSize=25.0f;
                tagGroup.addTag(tag );
            }
        });

        lPartySignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lnamestr = lname.getText().toString();
                String lusernamestr = lusername.getText().toString();
                String lpasswordstr = lpassword.getText().toString();
                String lpassword2str = lpassword2.getText().toString();
                String lMobileStr = lMobile.getText().toString();
                String lOfficeStr = lOffice.getText().toString();
                String lDescrStr = lDescr.getText().toString();

                if (!lpasswordstr.equals(lpassword2str)) {

                    Toast pass = Toast.makeText(getActivity(), "Passwords don't match!", Toast.LENGTH_SHORT);
                    pass.show();
                }
                else{
                    //insert details into DB
                    ThirdParties tp = new ThirdParties();
                    User u = new User();
                    u.setName(lnamestr);
                    u.setEmail(lusernamestr);
                    u.setPassword(lpasswordstr);
                    u.setType("ThirdParty");
                    tp.setName(lnamestr);
                    tp.setMobile(lMobileStr);
                    tp.setOffice(lOfficeStr);
                    tp.setDescription(lDescrStr);
                    tp.setRevenueType(revType);
                    tp.setTags(tagList);

                    signUpController.signUpForThirdParty(u,tp);

//Should set tags to model object third party here


                    //helper.insertContact(c);
                }
            }
        });
        return view;
    }









}
