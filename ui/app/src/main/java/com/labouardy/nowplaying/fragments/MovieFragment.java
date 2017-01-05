package com.labouardy.nowplaying.fragments;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.labouardy.nowplaying.MainActivity;
import com.labouardy.nowplaying.R;
import com.labouardy.nowplaying.adapter.DataReceiver;
import com.labouardy.nowplaying.adapter.MediaAdapter;
import com.labouardy.nowplaying.model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohamed on 05/01/2017.
 */

public class MovieFragment  extends Fragment {

    private ListView listOfMediaLV;
    private MediaAdapter adapter;
    private List<Movie> movies;
    private DataReceiver receiver;

    public MovieFragment() {
        receiver = new DataReceiver();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie, container, false);
        listOfMediaLV = (ListView)rootView.findViewById(R.id.listOfMedia);
        movies = new ArrayList<>();
        for(int i=0;i<100;i++)
            movies.add(new Movie("Movie #" + i , "https://image.tmdb.org/t/p/w185_and_h278_bestv2/gJNjVE8WGUjiSKUtMDEvNzxR5zq.jpg"));
        adapter = new MediaAdapter(this.getContext(), movies);
        listOfMediaLV.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter(DataReceiver.ACTION_RESP);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        getActivity().registerReceiver(receiver, filter);
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(receiver);
    }
}