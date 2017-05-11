package com.mit.lawyered.view.activities;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.mit.lawyered.R;

import java.util.ArrayList;

/**
 * Created by Ahmed on 5/10/2017.
 */

public class LocationSpecificRules extends AppCompatActivity {
    private ArrayList<String> rules;
    ArrayAdapter<String> adapter;
    ListView listView;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_spec_rul);
        listView = (ListView)findViewById(R.id.rules_list);
        rules = new ArrayList<>();
        rules.add("test1");
        rules.add("test2");
        rules.add("test2");
        rules.add("test2");
        rules.add("test2");
        rules.add("test1");
        rules.add("test2");
        rules.add("test2");
        rules.add("test2");
        rules.add("test2");
        rules.add("test1");
        rules.add("test2");
        rules.add("test2");
        rules.add("test2");
        rules.add("test2");
        rules.add("test1");
        rules.add("test2");
        rules.add("test2");
        rules.add("test2");
        rules.add("test2");

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,rules);
        listView.setAdapter(adapter);

    }

    private void  init(){

    }

}
