package com.labouardy.nowplaying;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.labouardy.nowplaying.fragments.MovieFragment;
import com.labouardy.nowplaying.fragments.SerieFragment;

/**
 * Created by Mohamed on 05/01/2017.
 */

public class SectionsPagerAdapter  extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MovieFragment();
            case 1:
                return new SerieFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Movies";
            case 1:
                return "Series";
        }
        return null;
    }
}
