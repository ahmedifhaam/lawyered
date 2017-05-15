package com.mit.lawyered.controller.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mit.lawyered.R;
import com.mit.lawyered.models.Notification;

import java.util.ArrayList;
import java.util.List;

public class ControlTest extends AppCompatActivity {

List<Notification> nList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_test);

        Notification notification=new Notification();
        notification.setNid("-Kk7scqt427_Rpi7oAy9");
        notification.setLbid("-Kk7scqqaZ3-wEOUO-0i");
        notification.setStatus(0);
        notification.setType("caseRequest");
        notification.setDescription("rameela20 has brought up a case");
        notification.setLawBrokenDesc("He damaged the road sign");
        notification.setLawShortDesc("");
        notification.setUserId("nbCCosFdd5ZusxZxf1H7dFr8k1a2");

        SeeNotificationController seeNotificationController =new SeeNotificationController(notification);

        //RequestController requestController=new RequestController("-Kk1E_3XbavLJwAfeMiM","He damaged the road sign");

        //Print thrid parties
       // Log.d("TPID","Looking for tag1");


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




   /* @Override
    public void respondedLaw(Object law) {
      law=(Law)law;
    }

    @Override
    public void respondedThird(Object tags) {
        thirdParties=(List<ThirdParties>)tags;
    }*/
}
