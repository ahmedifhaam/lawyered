package com.mit.lawyered.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mit.lawyered.R;
import com.mit.lawyered.models.Law;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed on 5/10/2017.
 */

public class LawDetails extends AppCompatActivity {
    private Law law;

    private TextView lawTitle;
    private TextView lawShortDesc;
    private TextView lawFullDesc;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law_details);

        lawTitle = (TextView) findViewById(R.id.law_title);
        lawShortDesc = (TextView) findViewById(R.id.short_desc);
        lawFullDesc = (TextView) findViewById(R.id.full_desc);

        List<String> tagList=new ArrayList<>();
        tagList.add("Criminal");
        tagList.add("Murder");

        law = new Law("id","Law Title one ","this is the short description of the law and its very sihort","null",tagList);
        init();
    }

    private void init(){
        lawTitle.setText(law.getTitle());
        lawShortDesc.setText(law.getShortDesc());
        //lawFullDesc.setText(law.getFullDesc());

    }
}
