package com.example.yassarchohan.sqlite_2_prc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yassar chohan on 11/6/2016.
 */
public class Custom_adapter extends ArrayAdapter<getrecords> {


    public Custom_adapter(Context context, ArrayList<getrecords> resource) {
        super(context,0, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_custom__layout, parent, false);
        }

        getrecords gtr = getItem(position);

        TextView txt1 = (TextView) listItemView.findViewById(R.id.readfname);
        txt1.setText(gtr.getName());

        TextView txt2 = (TextView) listItemView.findViewById(R.id.readfname);
        txt2.setText(gtr.getFname());

        TextView txt3 = (TextView) listItemView.findViewById(R.id.readmarks);
        txt3.setText(gtr.getMarks()+"");

        return listItemView;
    }
}
