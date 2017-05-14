package com.mit.lawyered.view.fragments;

import android.content.Context;
import android.content.Intent;
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
import com.mit.lawyered.controller.adapter.MyClickListener;
import com.mit.lawyered.controller.adapter.ProfilesRVAdapter;
import com.mit.lawyered.models.DataLawProfiles;
import com.mit.lawyered.view.activities.LawDetails;
import com.mit.lawyered.view.activities.LawyerDetails;

import java.util.ArrayList;
import java.util.List;


public class ProfilesFragment extends Fragment implements MyClickListener {
    public static ProfilesFragment newInstance(){
        return new ProfilesFragment();
    }
    private RecyclerView rView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static String LOG_TAG = "CardViewActivity";

    List<DataLawProfiles> lawyerProfiles;

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
        lawyerProfiles = getDataSet();
        adapter = new ProfilesRVAdapter(getDataSet(),this);
        rView.setAdapter(adapter);

        layoutManager = new LinearLayoutManager(getActivity());
        rView.setLayoutManager(layoutManager);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        /*((ProfilesRVAdapter) adapter).setOnItemClickListener(new MyClickListener()
        {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });*/
    }

    private ArrayList<DataLawProfiles> getDataSet() {

        ArrayList results = new ArrayList<DataLawProfiles>();
        for (int index = 0; index < 20; index++)
        {
            DataLawProfiles obj = new DataLawProfiles("ID","Profile " + index,
                    "Description " + index, "Rate"+index);
            results.add(index, obj);
        }
        return results;
    }

    public void launchLawyerDetails(int position){
        lawyerProfiles.get(position);
        Intent lawDetailsIntent = new Intent(this.getActivity(), LawyerDetails.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("LAWYERS",lawyerProfiles.get(position));
        lawDetailsIntent.putExtras(bundle);
        startActivity(lawDetailsIntent);
    }

    @Override
    public void onItemClick(int position) {
        Log.d("www","called"+position);
        launchLawyerDetails(position);
    }

}
