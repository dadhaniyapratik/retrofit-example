package com.iayon.retrofit20tutorial;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import models.ActorContact;

/**
 * Created by Pratik on 26-Nov-16.
 */

public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    List<ActorContact> actorContacts;

    public CustomBaseAdapter(Context context, List<ActorContact> items) {
        this.context = context;
        this.actorContacts = items;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView textview;
        TextView tv_image;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.cell, null);
            holder = new ViewHolder();
            holder.textview = (TextView) convertView.findViewById(R.id.textview);
            holder.tv_image = (TextView) convertView.findViewById(R.id.tv_image);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        ActorContact actorContact = (ActorContact) getItem(position);

        for (int i = 0; i <actorContacts.get(position).getActors().size() ; i++) {

            holder.textview.setText(actorContacts.get(position).getActors().get(i).getName());
            holder.tv_image.setText(actorContacts.get(position).getActors().get(i).getImage());

        }


        return convertView;
    }

    @Override
    public int getCount() {
        return actorContacts.size();
    }

    @Override
    public Object getItem(int position) {
        return actorContacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return actorContacts.indexOf(getItem(position));
    }
}
