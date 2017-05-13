package com.mit.lawyered.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mit.lawyered.R;
import com.mit.lawyered.controller.adapter.MyRecyclerViewAdapter;
import com.mit.lawyered.models.DataObject;
import com.mit.lawyered.models.Law;

import java.util.ArrayList;

/**
 * Created by Ahmed on 5/8/2017.
 */

public class LawsFragment extends Fragment {

    private Law law;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";

    private DatabaseReference mDatabase;

    public static LawsFragment newInstance(){
        return new LawsFragment();
    }

    public LawsFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDatabase= FirebaseDatabase.getInstance().getReference().child("laws");



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootView = inflater.inflate(R.layout.activity_card_view, container, false);

        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        return rootView;

    }
    @Override
    public void onStart() {
        super.onStart();

        /*FirebaseRecyclerAdapter<Law,LawViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Law, LawViewHolder>(
                Law.class,
                R.layout.rcycler_view,
                LawViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(LawViewHolder viewHolder, Law model, int position) {

                viewHolder.setTitle(model.getTitle());
                viewHolder.setShortDesc(model.getShortDesc());

            }
        };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);*/
    }

    /*public static class LawViewHolder extends RecyclerView.ViewHolder{

        View mView;
        public LawViewHolder(View itemView){
            super(itemView);

            itemView=mView;
        }


        public void setTitle(String title){
            TextView titleText=(TextView)mView.findViewById(R.id.titleCard);
            titleText.setText(title);
        }

        public void setShortDesc(String shortDesc){
            TextView sText=(TextView)mView.findViewById(R.id.shortDescCard);
            sText.setText(shortDesc);
        }







    }*/

    @Override
    public void onResume() {
        super.onResume();
       ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }

    private ArrayList<DataObject> getDataSet() {


        ArrayList results = new ArrayList<DataObject>();
        for (int index = 0; index < 20; index++)
        {
            DataObject obj = new DataObject("Title " + index,
                    "Title " +index);
            results.add(index, obj);
        }
        return results;
    }


}

