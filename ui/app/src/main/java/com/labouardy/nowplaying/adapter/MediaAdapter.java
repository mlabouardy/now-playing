package com.labouardy.nowplaying.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.labouardy.nowplaying.AppController;
import com.labouardy.nowplaying.R;
import com.labouardy.nowplaying.fragments.MovieFragment;
import com.labouardy.nowplaying.model.Media;
import com.labouardy.nowplaying.model.Movie;

import java.util.Collection;
import java.util.List;

/**
 * Created by Mohamed on 05/01/2017.
 */

public class MediaAdapter extends BaseAdapter{
    private List<? extends Media> listOfMedia;
    private Context context;

    public MediaAdapter(Context context, List<? extends Media> listOfMedia){
        this.context = context;
        this.listOfMedia = listOfMedia;
    }


    @Override
    public int getCount() {
        return listOfMedia.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfMedia.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(R.layout.media, null);

        final ImageView coverIV = (ImageView)view.findViewById(R.id.cover);
        TextView nameTV = (TextView)view.findViewById(R.id.name);

        Media media = listOfMedia.get(position);
        ImageRequest request = new ImageRequest(media.getCover(), new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                coverIV.setImageBitmap(response);
            }
        },0,0,null,null);
        nameTV.setText(media.getName());
        AppController.getInstance().addToRequestQueue(request);
        return view;
    }
}
