package com.mit.lawyered.view.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mit.lawyered.R;
import com.mit.lawyered.controller.adapter.NotificationsListAdapter;

/**
 * Created by Ahmed on 5/8/2017.
 */

 public class NotificationsFragment extends Fragment {

        private ListView mlist;

        public static NotificationsFragment newInstance(){
            return new NotificationsFragment();
        }


        public NotificationsFragment() {
            // Required empty public constructor
        }


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            String[] titles = {"Location-based rules", "Accepted Case", "You are here",
                    "You are here", "Accepted Case", "Accepted Case", "Location-based rules"};

            String[] descriptions = {"No smoking inside the restaurant", "Mr. John Doe has accepted your case.", "You are entering a religious place where specific rules are applied.",
                    "You are in a hospital. Please be silent.", "Mr. Smith has accepted your case.", "Mrs. Jenkins has accepted your case.", "No honking is allowed"};

            String[] timesReceived = {"12.15.p.m.","7.11.a.m.","6.00.p.m.","8.20.p.m.","11.20.a.m.","8.00.p.m.","7.29.a.m."};

            View rootView = inflater.inflate(R.layout.notifications, container, false);

            mlist = (ListView) rootView.findViewById(R.id.list);

            NotificationsListAdapter adapter = new NotificationsListAdapter(getContext(),titles, descriptions,timesReceived);
            mlist.setAdapter(adapter);

            return rootView;
        }
}
