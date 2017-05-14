package com.mit.lawyered.view.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.mit.lawyered.R;
import com.mit.lawyered.controller.firebase.LawsForTagController;
import com.mit.lawyered.controller.service.LocationChangeDetector;
import com.mit.lawyered.models.Law;
import com.mit.lawyered.view.fragments.LawsFragment;
import com.mit.lawyered.view.fragments.ProfilesFragment;
import com.mit.lawyered.view.fragments.NotificationsFragment;
import com.taglib.Tag;
import com.taglib.TagView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed on 5/8/2017.
 */

public class Home extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
    Location lastKnownLocation;
    TagView tagGroup;
    List<String> stringsForTag;
    AutoCompleteTextView searchView;
    List<String> allTags;
    LinearLayout searchPanel;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, LocationChangeDetector.class);
        startService(intent);
        setContentView(R.layout.activity_home);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        tagGroup = (TagView) findViewById(R.id.tag_group);
        searchPanel = (LinearLayout)findViewById(R.id.search_panel);

        tagGroup.setOnTagDeleteListener(new TagView.OnTagDeleteListener() {
            @Override
            public void onTagDeleted(TagView view, Tag tag, int position) {
                tagGroup.remove(position);
            }
        });

        stringsForTag = new ArrayList<>();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout,loadLawListFragment());
        transaction.commit();
        allTags = new ArrayList<>();
        allTags.add("Abuse");

        allTags.add("Building");
        allTags.add("Childcare");
        allTags.add("Domestic Violence");
        allTags.add("Environment");
        allTags.add("Financial");
        allTags.add("Gender-based");


        searchView = (AutoCompleteTextView) findViewById(R.id.search_box);
        ArrayAdapter<String> acarryadapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,allTags);
        searchView = (AutoCompleteTextView)findViewById(R.id.search_box);
        searchView.setAdapter(acarryadapter);

        init();
        /**
        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build();
        getType();*/
    }
    /*
    public void getType() {
       // mGoogleApiClient.connect();

        PendingResult<PlaceLikelihoodBuffer> currentPlace;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

        }else {

            currentPlace = Places.PlaceDetectionApi.getCurrentPlace(mGoogleApiClient, null);
            currentPlace.setResultCallback(new ResultCallback<PlaceLikelihoodBuffer>() {
                @Override
                public void onResult(@NonNull PlaceLikelihoodBuffer placeLikelihoods) {
                    for(PlaceLikelihood placeLikelihood:placeLikelihoods){
                        Log.i("HOME",String.format("Place '%s' has likelihood: %g",placeLikelihood.getPlace().getName()
                        ,placeLikelihood.getLikelihood()));
                    }
                    placeLikelihoods.release();
                }
            });
        }
    }*/


    private void init(){
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.laws_bt_ic:
                        selectedFragment =loadLawListFragment();
                        break;
                    case R.id.noti_bt_ic:
                        selectedFragment = NotificationsFragment.newInstance();
                        break;
                    case R.id.findlawyer_bt_ic:
                        selectedFragment = ProfilesFragment.newInstance();
                        break;

                    default:
                        selectedFragment = ProfilesFragment.newInstance();
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, selectedFragment);
                transaction.commit();
                return true;
            }
        });

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if(allTags.contains(s.toString()) && !tagGroup.getTags().contains(new Tag(s.toString()))){
                    Tag tag = new Tag(s.toString());
                    tag.isDeletable = true;
                    tagGroup.addTag(tag);
                    searchView.setText("");
                }
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_bar,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_LONG).show();
        if(item.getItemId() == R.id.show_search){
            if(searchPanel.getVisibility()!=View.VISIBLE)
                searchPanel.setVisibility(View.VISIBLE);
            else
                searchPanel.setVisibility(View.GONE);
        }
        return true;
    }
    /*
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.w("Error Connection Failed","Error");
    }*/

    public LawsFragment loadLawListFragment(){
        List<Law> lawlist = new ArrayList<>();
        List<String>tagList=new ArrayList<>();
        tagList.add("Criminal");
        tagList.add("Murder");
        /*Law law1=new Law("1","Criminal","Violent murder","hgfffffffffffffffffffff",tagList);
        Law law2=new Law("2","Environmental","Violent murder","hgfffffffffffffffffffff",tagList);

        lawlist.add(law1);
        lawlist.add(law2);
           */
        LawsForTagController lawsForTagController = new LawsForTagController();
        lawlist = lawsForTagController.getAllLawDescFortags(tagList);
        return LawsFragment.newInstance(lawlist);

    }
}
