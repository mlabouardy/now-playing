package com.labouardy.nowplaying.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.labouardy.nowplaying.R;

/**
 * Created by Mohamed on 05/01/2017.
 */

public class SerieFragment   extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public SerieFragment() {
    }


    public static SerieFragment newInstance(int sectionNumber) {
        SerieFragment fragment = new SerieFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_serie, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        return rootView;
    }
}