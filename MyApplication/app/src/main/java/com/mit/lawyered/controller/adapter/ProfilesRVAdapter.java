package com.mit.lawyered.controller.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mit.lawyered.R;
import com.mit.lawyered.models.DataLawProfiles;
import com.mit.lawyered.view.activities.DialogActivity;

import java.util.ArrayList;

/**
 * Created by Shani on 11/05/2017.
 */

public class ProfilesRVAdapter extends RecyclerView.Adapter<ProfilesRVAdapter.DataObjectHolder> {

    private static String LOG_TAG = "ProfilesRVAdapter";
    private ArrayList<DataLawProfiles> dataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView profileName;
        TextView description;
        TextView rate;


        public DataObjectHolder(View itemView) {
            super(itemView);
            profileName = (TextView) itemView.findViewById(R.id.tvProfileName);
            description = (TextView) itemView.findViewById(R.id.tvDescr);
            rate = (TextView) itemView.findViewById(R.id.tvRate);

            Button btnViewMore = (Button)itemView.findViewById(R.id.btnViewMore);
            btnViewMore.setOnClickListener(this);
            Log.i(LOG_TAG, "Adding Listener");
            //itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition());
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public ProfilesRVAdapter(ArrayList<DataLawProfiles> myDataset,MyClickListener clickListener) {
        dataset = myDataset;
        this.setOnItemClickListener(clickListener);
    }

    @Override
    public ProfilesRVAdapter.DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_cardview_profile, parent, false);

        ProfilesRVAdapter.DataObjectHolder dataObjectHolder = new ProfilesRVAdapter.DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(ProfilesRVAdapter.DataObjectHolder holder, int position) {
        holder.profileName.setText(dataset.get(position).getProfile());
        holder.description.setText(dataset.get(position).getDescription());
        holder.rate.setText(dataset.get(position).getRate());


    }

    public void addItem(DataLawProfiles obj, int index) {
        dataset.add(index, obj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        dataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }




}
