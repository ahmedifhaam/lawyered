package com.mit.lawyered.controller.firebase;

import com.mit.lawyered.controller.adapter.OnResponse;
import com.mit.lawyered.controller.adapter.OnResponseThirdParties;
import com.mit.lawyered.models.Notification;
import com.mit.lawyered.models.ThirdParties;

import java.util.List;

/**
 * Created by ASUS on 5/14/2017.
 */

public class RequestController implements OnResponse,OnResponseThirdParties {
    TagsForLawIdController tagsForLawIdController;
    ThirdPartyListForTagsController thirdPartyListForTagsController;



    List <String> tagList;
    List <ThirdParties> thirdParties;
    List<Notification>notifications;

    String lawId;
    String description;

    public RequestController(String lawId,String description){

        this.lawId=lawId;
        this.description=description;
        tagsForLawIdController=new TagsForLawIdController(this,lawId);




    }

    @Override
    public void responded(Object tags) {
        tagList=(List<String>)tags;
        NotifyThirdPartyListForTagsController notifyThirdPartyListForTagsController=new NotifyThirdPartyListForTagsController(this,tagList,lawId,description);

    }

    @Override
    public void respondedThird(Object parties) {
        thirdParties=(List<ThirdParties>)parties;
    }


}
