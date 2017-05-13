package com.mit.lawyered.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.IdRes;
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
import com.mit.lawyered.models.ThirdParties;
import com.mit.lawyered.models.User;
import com.taglib.Tag;
import com.taglib.TagView;


public class LegalPartyFragment extends Fragment  {


    String revType;
    String[] tags = {"Criminal", "Environmental","Childcare","Abuse", "Corruption"};
    private EditText lname;
    private EditText luname;
    private EditText lpw;
    private EditText lconfirmPw;
    ArrayAdapter<CharSequence> adapter;
    ThirdParties thirdParties;
    TagView tagGroup;
    AutoCompleteTextView actv;
    String tag;

    public LegalPartyFragment() {
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

        View view = inflater.inflate(R.layout.fragment_legal_party, container, false);

        Button lPartySignUp = (Button) view.findViewById(R.id.btnLPartySignUp);

        lPartySignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSignupClick(v);
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getActivity(),android.R.layout.select_dialog_item,tags);

        //Getting the instance of AutoCompleteTextView
        actv= (AutoCompleteTextView)view.findViewById(R.id.searchTags);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView

        actv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected (AdapterView<?> parent, View view, int position, long id) {
                String selectedTag = actv.getText().toString();
                tagGroup = (TagView)view.findViewById(R.id.tag_group);
                Tag tag = new Tag(selectedTag);
                tag.tagTextSize=25.0f;
                tagGroup.addTag(tag );
            }
            @Override
            public void onNothingSelected (AdapterView<?> parent) {
                //... your stuff
            }

        });
        return view;
    }



    public void onSignupClick(View v) {


        if (v.getId() == R.id.btnLPartySignUp) {

            EditText lname = (EditText) v.findViewById(R.id.LegalName);
            EditText lusername = (EditText) v.findViewById(R.id.LegalUname);
            EditText lpassword = (EditText) v.findViewById(R.id.LegalPassword);
            EditText lpassword2 = (EditText) v.findViewById(R.id.LegalConfirmPassword);
            EditText lMobile = (EditText) v.findViewById(R.id.LegalMobile);
            EditText lOffice = (EditText) v.findViewById(R.id.LegalOffice);
            EditText lDescr = (EditText) v.findViewById(R.id.profileDescription);

            RadioGroup rg = (RadioGroup) v.findViewById(R.id.radioGroup);
            //RadioGroup.OnCheckedChangeListener listener = null;

            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    revType = ((RadioButton)group.findViewById(checkedId)).getText().toString();
                }
            });
            /*int checked = rg.getCheckedRadioButtonId();
            RadioButton rb = (RadioButton) v.findViewById(checked);
            int radioId = rg.indexOfChild(rb);
            RadioButton checkedBtn = (RadioButton) rg.getChildAt(radioId);
            String revenueType = (String) checkedBtn.getText();*/

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
                u.setUsername(lusernamestr);
                u.setPassword(lpasswordstr);
                tp.setMobile(lMobileStr);
                tp.setOffice(lOfficeStr);
                tp.setDescription(lDescrStr);
                tp.setRevenueType(revType);



                //helper.insertContact(c);
            }

        }
    }





}
