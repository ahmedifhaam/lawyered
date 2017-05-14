package com.mit.lawyered.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
    Button mark;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law_details);

        lawTitle = (TextView) findViewById(R.id.law_title);
        lawShortDesc = (TextView) findViewById(R.id.short_desc);
        lawFullDesc = (TextView) findViewById(R.id.full_desc);
        mark = (Button) findViewById(R.id.request_help);

        mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),DialogActivity.class);
                Bundle extras = new Bundle();
                extras.putParcelable("LAW",law);
                intent.putExtras(extras);
                v.getContext().startActivity(intent);
            }
        });
        law =(Law) getIntent().getExtras().get("LAW");

        //List<String> tagList=new ArrayList<>();
       // tagList.add("Criminal");
        //tagList.add("Murder");

        //law = new Law("id","Law Title one ","this is the short description of the law and its very sihort","null",tagList);
        init();
    }


    private void init(){
        lawTitle.setText(law.getTitle());
        lawShortDesc.setText(law.getShortDesc());
        //lawFullDesc.setText(law.getFullDesc());



    }
}
