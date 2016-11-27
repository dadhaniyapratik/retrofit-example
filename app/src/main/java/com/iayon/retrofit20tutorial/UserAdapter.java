package com.iayon.retrofit20tutorial;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


import java.util.List;

import models.ActorContact;

/**
 * Created by Ashiq Uz Zoha on 9/13/15.
 * Dhrubok Infotech Services Ltd.
 * ashiq.ayon@gmail.com
 */
public class UserAdapter extends BaseAdapter {

    private List<ActorContact> actorContactList;
    private Context context ;

    public UserAdapter (Context ctx, List<ActorContact> items) {
        super();
        this.context = ctx ;
        this.actorContactList = items ;
    }

    @Override
    public int getCount() {
        return this.actorContactList.size();
    }

    @Override
    public long getItemId(int i) {
        return 0 ;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.cell, viewGroup, false);
        TextView tv = (TextView) v.findViewById(R.id.textview);
        TextView tv_image = (TextView) v.findViewById(R.id.tv_image);
        ImageView img_actor = (ImageView) v.findViewById(R.id.img_actor);
        ActorContact actorContact = actorContactList.get(i);
        for (int j = 0; j <actorContactList.get(i).getActors().size() ; j++) {
            tv.setText(actorContactList.get(i).getActors().get(i).getName());
            tv_image.setText(actorContactList.get(i).getActors().get(i).getImage());
            Glide.with(context).load(actorContactList.get(i).getActors().get(i).getImage())
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(img_actor);
            Log.d("Adapter", actorContactList.get(i).getActors().get(i).getName());
            Log.d("Image", actorContactList.get(i).getActors().get(i).getName());
        }


        return v;
    }
}