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
import android.util.Log;
import android.view.MenuItem;



import com.mit.lawyered.R;
import com.mit.lawyered.controller.service.LocationChangeDetector;
import com.mit.lawyered.view.fragments.LawsFragment;
import com.mit.lawyered.view.fragments.ProfilesFragment;
import com.mit.lawyered.view.fragments.NotificationsFragment;


import java.util.List;

/**
 * Created by Ahmed on 5/8/2017.
 */

public class Home extends AppCompatActivity {



    Location lastKnownLocation;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, LocationChangeDetector.class);
        startService(intent);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, LawsFragment.newInstance());
        transaction.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.laws_bt_ic:
                        selectedFragment = LawsFragment.newInstance();
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


    }
    /*
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.w("Error Connection Failed","Error");
    }*/
}
