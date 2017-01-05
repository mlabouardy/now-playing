package com.labouardy.nowplaying.service;

import android.app.IntentService;
import android.content.Intent;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.labouardy.nowplaying.model.BucketStorage;
import com.labouardy.nowplaying.model.Config;
import com.labouardy.nowplaying.model.Movie;

import org.json.JSONObject;

/**
 * Created by Mohamed on 05/01/2017.
 */

public class DataFetcherService extends IntentService{

    public DataFetcherService() {
        super(DataFetcherService.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, Config.BUCKET_STORAGE_URL, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                BucketStorage data = gson.fromJson(response.toString(), BucketStorage.class);
                for(Movie movie: data.getMovies())
                    System.out.println(movie);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);
    }
}
