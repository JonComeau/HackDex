package com.skazerk.hackdex.PokeDexList.DexTabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Skaze on 9/9/17.
 */

public class DexPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public DexPagerAdapter(FragmentManager fragmentManager, List<Fragment> fragments) {
        super(fragmentManager);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    public CharSequence getPageTitle(int position) {
        switch(position) {
            case 0:
                return "Info";
            case 1:
                return "Moves";
            case 2:
                return "Area";
            case 3:
                return "Evo";
        }
        return "Default";
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
}
