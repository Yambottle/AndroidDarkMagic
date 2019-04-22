package com.example.yam.scanbloxlogindemo.widget;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class CustomPagerAdapter extends FragmentPagerAdapter {

    private  String[] mTitles;
    private ArrayList<Fragment> mFragments;

    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    public ArrayList<Fragment> getmFragments() {
        return mFragments;
    }

    public void setmFragments(ArrayList<Fragment> mFragments) {
        this.mFragments = mFragments;
    }

    public String[] getmTitles(){
        return mTitles;
    }

    public void setmTitles(String[] mTitles){
        this.mTitles = mTitles;
    }
}
