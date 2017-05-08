package com.mit.lawyered.view.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mit.lawyered.R;

/**
 * Created by Ahmed on 5/8/2017.
 */

public class FragmentThree extends Fragment {
    public static FragmentThree newInstance(){
        return new FragmentThree();
    }

    @Override
    public void onCreate(Bundle savedInstanceVlaue){
        super.onCreate(savedInstanceVlaue);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container
            ,Bundle savedInstanceState){
        return inflater.inflate(R.layout.frag_three,container,false);
    }
}
