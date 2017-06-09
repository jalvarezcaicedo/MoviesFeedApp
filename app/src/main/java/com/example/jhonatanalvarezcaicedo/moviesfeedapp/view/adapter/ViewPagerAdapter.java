package com.example.jhonatanalvarezcaicedo.moviesfeedapp.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.jhonatanalvarezcaicedo.moviesfeedapp.view.fragment.PopularFragment;
import com.example.jhonatanalvarezcaicedo.moviesfeedapp.view.fragment.RatedFragment;
import com.example.jhonatanalvarezcaicedo.moviesfeedapp.view.fragment.UpcomingFragment;

/**
 * Created by jhonatanalvarezcaicedo on 8/06/17.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int numTabs;
    String pageTitle;

    public ViewPagerAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs = numTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                PopularFragment popularTab = new PopularFragment();
                return popularTab;
            case 1:
                RatedFragment ratedTab = new RatedFragment();
                return ratedTab;
            case 2:
                UpcomingFragment upcomingTab = new UpcomingFragment();
                return upcomingTab;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Popular";
            case 1:
                return "Top rated";
            case 2:
                return "Upcoming";
        }
        return super.getPageTitle(position);
    }
}
