package com.skazerk.hackdex.PokeDexList.DexTabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.skazerk.hackdex.PokeDexList.DexTabs.Area.Area_Fragment;
import com.skazerk.hackdex.PokeDexList.DexTabs.Evolution.Evo_Fragment;
import com.skazerk.hackdex.PokeDexList.DexTabs.Moves.Moves_Fragment;
import com.skazerk.hackdex.R;
import com.skazerk.hackdex.PokeDexList.DexTabs.Info.Info_Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skaze on 9/9/17.
 */

public class DexTabFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Toast.makeText(getContext(), "Dex Fragment is Init", Toast.LENGTH_SHORT).show();
        View result = inflater.inflate(R.layout.dex_tabs_fragment, container, false);
        ViewPager pager = result.findViewById(R.id.dex_tabs);

        pager.setAdapter(buildAdapter());

        return(result);
    }

    private PagerAdapter buildAdapter() {
        return new DexPagerAdapter(getChildFragmentManager(), populateDexFragments());
    }

    private List<Fragment> populateDexFragments() {
        List<Fragment> fragmentList = new ArrayList<>();

        fragmentList.add(new Info_Fragment());
        fragmentList.add(new Moves_Fragment());
        fragmentList.add(new Area_Fragment());
        fragmentList.add(new Evo_Fragment());

        return fragmentList;
    }
}
