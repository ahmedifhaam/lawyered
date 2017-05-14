package com.mit.lawyered.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mit.lawyered.R;
import com.mit.lawyered.controller.adapter.ProfilesRVAdapter;
import com.mit.lawyered.models.DataLawProfiles;

import java.util.ArrayList;


public class ProfilesFragment extends Fragment {
    public static ProfilesFragment newInstance(){
        return new ProfilesFragment();
    }
    private RecyclerView rView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static String LOG_TAG = "CardViewActivity";


    public ProfilesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_recycler_view, container, false);

        rView = (RecyclerView) rootView.findViewById(R.id.recycler_view_profiles);
        rView.setHasFixedSize(true);

        adapter = new ProfilesRVAdapter(getDataSet());
        rView.setAdapter(adapter);

        layoutManager = new LinearLayoutManager(getActivity());
        rView.setLayoutManager(layoutManager);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((ProfilesRVAdapter) adapter).setOnItemClickListener(new ProfilesRVAdapter
                .MyClickListener()
        {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }

    private ArrayList<DataLawProfiles> getDataSet() {

        ArrayList results = new ArrayList<DataLawProfiles>();
        for (int index = 0; index < 20; index++)
        {
            DataLawProfiles obj = new DataLawProfiles("Profile " + index,
                    "Description " + index, "Rate"+index);
            results.add(index, obj);
        }
        return results;
    }
}
