package com.labouardy.nowplaying.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.labouardy.nowplaying.MainActivity;
import com.labouardy.nowplaying.R;

/**
 * Created by Mohamed on 05/01/2017.
 */

public class MovieFragment  extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public MovieFragment() {
    }


    public static MovieFragment newInstance(int sectionNumber) {
        MovieFragment fragment = new MovieFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        return rootView;
    }
}