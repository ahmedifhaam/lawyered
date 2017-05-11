package com.mit.lawyered.controller.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mit.lawyered.R;


/**
 * Created by Shani on 10/05/2017.
 */

public class NotificationsListAdapter extends BaseAdapter {

    private String[] titles;
    private String[] descrs;
    private String[] times;
    private Context context;

    public NotificationsListAdapter( Context context, String[] titles, String[] descrs, String[] times) {
        super();
        this.titles = titles;
        this.descrs = descrs;
        this.times = times;
        this.context = context;

    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return titles[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false);


        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView descr = (TextView) rowView.findViewById(R.id.description);
        TextView dura = (TextView)rowView.findViewById(R.id.timeReceived);
        ImageView icon = (ImageView) rowView.findViewById(R.id.notIcon);
        ImageView arrow = (ImageView)rowView.findViewById(R.id.icArrow);

        title.setText(titles[position]);
        descr.setText(descrs[position]);
        dura.setText(times[position]);
        //icon.setImageResource(R.drawable.ic_face);

        return rowView;
    }


}
