package com.mit.lawyered.controller.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mit.lawyered.R;
import com.mit.lawyered.controller.adapter.OnResponse;
import com.mit.lawyered.models.Law;
import com.mit.lawyered.models.ThirdParties;

import java.util.List;

public class ControlTest extends AppCompatActivity implements OnResponse {

    List<ThirdParties> thirdParties;
    List<Law> laws;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_test);

        //Print thrid parties
        Log.d("TPID","Looking for tag1");


        //Initializing Thirdparty controller for testing
       // ThirdPartyController tpc=new ThirdPartyController(this);


        LawController lawController=new LawController(this);




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

    //Testing for Law Controller
    public void responded(Object obj){
        laws = (List<Law>)obj;
        Log.d("LAWID",laws.size()+"");
        for (Law law:laws) {

            Log.d("LAWID",law.getLawId()+"2");
        }
    }


}
