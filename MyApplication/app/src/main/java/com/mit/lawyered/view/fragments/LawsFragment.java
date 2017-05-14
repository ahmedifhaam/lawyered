package com.mit.lawyered.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mit.lawyered.R;
import com.mit.lawyered.controller.adapter.MyClickListener;
import com.mit.lawyered.controller.adapter.MyRecyclerViewAdapter;
import com.mit.lawyered.models.DataObject;
import com.mit.lawyered.models.Law;
import com.mit.lawyered.view.activities.LawDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed on 5/8/2017.
 */

public class LawsFragment extends Fragment implements SearchView.OnQueryTextListener,MyClickListener{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";

    List<DataObject> dataObjects;
    //private ArrayAdapter<String> adapter;
    private Context context;
    List<Law> lawlist;

    public static LawsFragment newInstance(List<Law> lawlist){
        LawsFragment lawsFragment = new LawsFragment();
        lawsFragment.setLawlist(lawlist);
        return lawsFragment;
    }

    public LawsFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_card_view, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        Button btnViewMore = (Button)mRecyclerView.findViewById(R.id.view_more);

        //calling to set law list to card view
        lawlist = new ArrayList<>();
        List<String>tagList=new ArrayList<>();
        tagList.add("Criminal");
        tagList.add("Murder");
        Law law1=new Law("1","Criminal","Violent murder","hgfffffffffffffffffffff",tagList);
        Law law2=new Law("2","Environmental","Violent murder","hgfffffffffffffffffffff",tagList);

        lawlist.add(law1);
        lawlist.add(law2);

        //mAdapter = new MyRecyclerViewAdapter(getDataSet(lawlist),this);
        mAdapter = new MyRecyclerViewAdapter((ArrayList<Law>) lawlist,this);

        mRecyclerView.setAdapter(mAdapter);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        return rootView;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        String[] allTags = {"Abuse","Building","Childcare","Domestic Violence","Environment","Financial","Gender-based"};
        dataObjects = new ArrayList<>();

        /*for (String tagStr : allTags) {
            Locale obj = new Locale(“”, countryCode);
            mCountryModel.add(new CountryModel(obj.getDisplayCountry(), obj.getISO3Country()));
        }

        adapter = new RVAdapter(mCountryModel);
        recyclerview.setAdapter(adapter);*/
    }


    @Override
    public void onResume() {
        super.onResume();
        /**((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });*/
    }

    private ArrayList<DataObject> getDataSet() {

        ArrayList results = new ArrayList<DataObject>();
        for (int index = 0; index < 20; index++)
        {
            DataObject obj = new DataObject("Title " + index,
                    "Title " + index);
            results.add(index, obj);
        }
        return results;
    }

    private ArrayList<DataObject> getDataSet(List<Law>lawList){
        ArrayList results = new ArrayList<DataObject>();
        for (Law law:lawList) {
            DataObject obj = new DataObject(law.getTitle(),
                    law.getShortDesc());
            results.add(obj);
        }
        return results;
    }


    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText == null || newText.trim().isEmpty()) {
            resetSearch();
            return false;
        }



        /*adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, filteredTags);
        .Adapter(adapter);*/

        return false;
    }

    public void resetSearch() {
//        adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, allTags);
        //setListAdapter(adapter);
    }

    public void launchLawDetails(int position){
        lawlist.get(position);
        Intent lawDetailsIntent = new Intent(this.getActivity(), LawDetails.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("LAW",lawlist.get(position));
        lawDetailsIntent.putExtras(bundle);
        startActivity(lawDetailsIntent);
    }

    @Override
    public void onItemClick(int position) {
        Log.d("www","called"+position);
        launchLawDetails(position);
    }

    public List<Law> getLawlist() {
        return lawlist;
    }

    public void setLawlist(List<Law> lawlist) {
        this.lawlist = lawlist;
    }
}

