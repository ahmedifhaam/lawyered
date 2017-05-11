package com.mit.lawyered.view.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


import com.mit.lawyered.R;
import com.mit.lawyered.view.fragments.LawsFragment;
import com.mit.lawyered.view.fragments.ProfilesFragment;
import com.mit.lawyered.view.fragments.NotificationsFragment;

/**
 * Created by Ahmed on 5/8/2017.
 */

public class Home extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, LawsFragment.newInstance());
        transaction.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
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
    }

}
