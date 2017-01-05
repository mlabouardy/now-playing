package com.labouardy.nowplaying.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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

    public MediaAdapter(Context context, List<Movie> listOfMedia){
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

        return view;
    }
}
