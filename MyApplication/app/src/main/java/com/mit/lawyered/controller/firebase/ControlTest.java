package com.mit.lawyered.controller.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mit.lawyered.R;
import com.mit.lawyered.controller.adapter.OnResponse;
import com.mit.lawyered.models.Law;
import com.mit.lawyered.models.ThirdParties;

import java.util.ArrayList;
import java.util.List;

public class ControlTest extends AppCompatActivity implements OnResponse {

    List<ThirdParties> thirdParties;
    List<Law> laws;
    SaveLawBrokenController saveLawBrokenController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_test);

        //Print thrid parties
        Log.d("TPID","Looking for tag1");


        //Initializing Thirdparty controller for testing
       // ThirdPartyController tpc=new ThirdPartyController(this);


       // LawController lawController=new LawController(this);
        //List<String>tagList=new ArrayList<>();
        //tagList.add("Accident");
        //tagList.add("road");
        //lawController.saveLaw("Accident","Drunk Driving","hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh",tagList);
        //saveLawBrokenController=new SaveLawBrokenController();
        //saveLawBrokenController.saveLawBrokenNotification("-Kk0pFlU1oMcJagmZAxl","A drunken driver made this happen");
       List<String>list=new ArrayList<>();
        list.add("Criminal");
        LawsForTagController lawsForTagController=new LawsForTagController(this,list);





    }

    //Testing for Third Party Controller

    /*
    public void responded(Object obj){
        thirdParties = (List<ThirdParties>)obj;
        Log.d("TPID",thirdParties.size()+"");
        for (ThirdParties party:thirdParties) {

            Log.d("TPID",party.getTpid()+"2");
        }
    }*/

    //Testing for LawFortAGS Controller
    public void responded(Object obj){
        laws = (List<Law>)obj;
        Log.d("LAWSIZE",laws.size()+"");

        for(Law law:laws){
           List<String>list=law.getTags();
            for(String tag:list){
                Log.d("TAG is ",tag+"");
            }
        }

    }


}
