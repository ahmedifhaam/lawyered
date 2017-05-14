package com.mit.lawyered.controller.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mit.lawyered.R;
import com.mit.lawyered.controller.adapter.OnResponseLaw;
import com.mit.lawyered.controller.adapter.OnResponseThirdParties;
import com.mit.lawyered.models.Law;
import com.mit.lawyered.models.ThirdParties;

import java.util.List;

public class ControlTest extends AppCompatActivity implements OnResponseThirdParties,OnResponseLaw {

    List<ThirdParties> thirdParties;
    List<Law> laws;

    ThirdParties party;
    Law law;

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
      /* List<String>list=new ArrayList<>();
        list.add("Criminal");
        */

//Testing for all lawyer detail for lawyerid

        //ThirdPartyController thirdPartyController=new ThirdPartyController(this,"RmvNlFe5W9Y4wFu9zFbxbGmfeQl1");

//Testing for all law detail for lawid
        //LawController lawController=new LawController(this,"-Kk1E_3XbavLJwAfeMiM");




        //Testing for case request ntification

        //LawController lawController=new LawController(this,"-Kk1E_3XbavLJwAfeMiM");

        //TagsForLawIdController tagsForLawIdController =new TagsForLawIdController(thirdParties,"-Kk1E_3XbavLJwAfeMiM","Drunken driver did");

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




    @Override
    public void respondedLaw(Object law) {
      law=(Law)law;
    }

    @Override
    public void respondedThird(Object tags) {
        thirdParties=(List<ThirdParties>)tags;
    }
}
