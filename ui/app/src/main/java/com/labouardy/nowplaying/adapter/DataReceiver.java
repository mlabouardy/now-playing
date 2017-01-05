package com.labouardy.nowplaying.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;
import com.labouardy.nowplaying.model.BucketStorage;
import com.labouardy.nowplaying.model.Movie;

/**
 * Created by Mohamed on 05/01/2017.
 */

public class DataReceiver extends BroadcastReceiver {
    public static final String ACTION_RESP ="com.myapp.intent.action.TEXT_TO_DISPLAY";
    @Override
    public void onReceive(Context context, Intent intent) {
        String results = intent.getStringExtra("results");
        Gson gson = new Gson();
        BucketStorage data = gson.fromJson(results, BucketStorage.class);
        for(Movie movie: data.getMovies())
            System.out.println(movie);
    }
}
