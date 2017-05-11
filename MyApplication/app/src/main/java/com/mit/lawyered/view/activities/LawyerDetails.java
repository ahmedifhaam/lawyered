package com.mit.lawyered.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.mit.lawyered.R;
import com.mit.lawyered.models.ThirdParties;
import com.taglib.Tag;
import com.taglib.TagView;

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
        thirdParties = new ThirdParties("tpid","userid","Ahmed Ifhaam","0776699609","Iam a good lawyer","NPO","4.0/5","Individual");
        thirdParties.setTags(new String[]{"Test1","Test2","test 3"});
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
}
