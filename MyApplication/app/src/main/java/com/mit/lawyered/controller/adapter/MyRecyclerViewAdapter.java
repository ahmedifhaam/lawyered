package com.mit.lawyered.controller.adapter;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mit.lawyered.R;
import com.mit.lawyered.models.DataObject;
import com.mit.lawyered.models.Law;
import com.mit.lawyered.view.activities.DialogActivity;
import com.mit.lawyered.view.fragments.LawsFragment;

import java.util.ArrayList;
/**
 * Created by Shani on 08/05/2017.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.DataObjectHolder>

{

    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<Law> mDataset;
    private static MyClickListener myClickListener;


    public class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView label;
        TextView dateTime;
        Button mark;

        public DataObjectHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.textView);
            dateTime = (TextView) itemView.findViewById(R.id.textView2);
            Button btnMore = (Button) itemView.findViewById(R.id.btnViewMore);
            mark = (Button) itemView.findViewById(R.id.btnMark);
            btnMore.setOnClickListener(this);
            Log.i(LOG_TAG, "Adding Listener");
            //itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition());

        }


    }


    public MyRecyclerViewAdapter(ArrayList<Law> myDataset,MyClickListener listener) {
        mDataset = myDataset;
       this.myClickListener = listener;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rcycler_view, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, final int position) {
        holder.label.setText(mDataset.get(position).getTitle());
        holder.dateTime.setText(mDataset.get(position).getShortDesc());

        holder.mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),DialogActivity.class);
                Bundle extras = new Bundle();
                extras.putParcelable("LAW",mDataset.get(position));
                intent.putExtras(extras);
                v.getContext().startActivity(intent);

            }
        });
    }

    public void addItem(Law dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }



    protected void onActivityResult(int requestCode,int resultCode,Intent data){

    }

    public ArrayList<Law> getmDataset() {
        return mDataset;
    }

    public void setmDataset(ArrayList<Law> mDataset) {
        this.mDataset = mDataset;
    }
}