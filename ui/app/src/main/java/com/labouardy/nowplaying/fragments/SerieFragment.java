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

import com.labouardy.nowplaying.R;
import com.labouardy.nowplaying.adapter.DataMovieReceiver;
import com.labouardy.nowplaying.adapter.DataSerieReceiver;
import com.labouardy.nowplaying.adapter.MediaAdapter;
import com.labouardy.nowplaying.model.BucketStorage;
import com.labouardy.nowplaying.model.Movie;
import com.labouardy.nowplaying.model.Serie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohamed on 05/01/2017.
 */

public class SerieFragment   extends Fragment {

    private ListView listOfMediaLV;
    private MediaAdapter adapter;
    private List<Serie> series;
    private DataSerieReceiver receiver;

    public SerieFragment() {
        receiver = new DataSerieReceiver(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie, container, false);
        listOfMediaLV = (ListView)rootView.findViewById(R.id.listOfMedia);
        series = new ArrayList<>();
        adapter = new MediaAdapter(this.getContext(), series);
        listOfMediaLV.setAdapter(adapter);
        return rootView;
    }

    public void update(BucketStorage data){
        series.clear();
        for(Serie m: data.getSeries())
            series.add(m);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter(DataSerieReceiver.ACTION_RESP);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        getActivity().registerReceiver(receiver, filter);
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(receiver);
    }
}