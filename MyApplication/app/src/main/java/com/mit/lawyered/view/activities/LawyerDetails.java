package com.mit.lawyered.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mit.lawyered.R;
import com.mit.lawyered.models.DataLawProfiles;
import com.mit.lawyered.models.ThirdParties;
import com.taglib.Tag;
import com.taglib.TagView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed on 5/9/2017.
 */

public class LawyerDetails extends AppCompatActivity {
    private ThirdParties thirdParties;

    //ui elements

    TagView tagGroup;
    TextView lawyerName;
    TextView lawyerRating;
    TextView shortDesc;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyer_details);

        tagGroup = (TagView)findViewById(R.id.tag_group);
        lawyerName = (TextView)findViewById(R.id.lawyer_id);
        lawyerRating = (TextView)findViewById(R.id.lawyer_rate);

        shortDesc = (TextView)findViewById(R.id.short_desc);
        
        //Tag tag = new Tag("test1");
        //tag.tagTextSize = 25.0f;
        //tag.isDeletable =true;
        /*tagGroup.setOnTagDeleteListener(new TagView.OnTagDeleteListener() {
            @Override
            public void onTagDeleted(TagView view, Tag tag, int position) {
                Toast.makeText(LawyerDetails.this,"Deleted",Toast.LENGTH_SHORT).show();
                tagGroup.remove(position);
            }
        });*/
        DataLawProfiles prof = (DataLawProfiles) getIntent().getExtras().get("LAWYERS");
        thirdParties = getThirdParty(prof);

        //thirdParties = new ThirdParties("tpid","userid","Ahmed Ifhaam","0776699609","Iam a good lawyer","NPO","4.0/5","Individual");
        //changed string array to list
        List<String> tags=new ArrayList<>();
        tags.add("tag1");
        tags.add("tag2");
        tags.add("tag3");
        thirdParties.setTags(tags);
        init();
    }

    private void init(){
        lawyerName.setText(thirdParties.getName());
        lawyerRating.setText(thirdParties.getReviewAvg());
        shortDesc.setText(thirdParties.getDescription());

        for(String tagText:thirdParties.getTags()){
            Tag tag = new Tag(tagText);
            tag.tagTextSize=25.0f;
            tagGroup.addTag(tag );
        }
    }

    private ThirdParties getThirdParty(DataLawProfiles profile){
        ThirdParties thirdParties = new ThirdParties("tpid","id",profile.getProfile(),"mobile","office",profile.getDescription(),"reve type",profile.getRate());
        return thirdParties;
    }
}
