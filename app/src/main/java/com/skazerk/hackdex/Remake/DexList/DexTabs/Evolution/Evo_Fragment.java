package com.skazerk.hackdex.Remake.DexList.DexTabs.Evolution;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.skazerk.hackdex.Old.DexTabs.Dex_Main;
import com.skazerk.hackdex.Remake.DexList.DexTabs.DexTabFragment;
import com.skazerk.hackdex.Remake.DexList.DexTabs.Utils.Pokemon;
import com.skazerk.hackdex.Remake.GlobalClass;
import com.skazerk.hackdex.R;
import com.skazerk.hackdex.Remake.Main;

import java.util.ArrayList;

/**
 * Created by Skaze on 11/17/16.
 */

public class Evo_Fragment extends ListFragment {
    private GlobalClass global;
    private EvoAdapter evo_adapter;
    private ArrayList<ArrayList<String>> evos;

    public Evo_Fragment(){
        //stuff
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("Evos", "Evo Start");
        global = (GlobalClass)getContext().getApplicationContext();
        Pokemon poke = global.getPoke();

        evo_adapter = new EvoAdapter();

        evos = poke.getEvos();

        Log.i("Evos", "Evo Size: " + evos.size());

        for(int i = 0; i < evos.size(); i++) {
            Log.d("Evos", evos.get(i).get(0) + ", " + evos.get(i).get(1) + ", " + evos.get(i).get(2));
            evo_adapter.addItem(evos.get(i).get(0), evos.get(i).get(1), evos.get(i).get(2));
        }

        setListAdapter(evo_adapter);

        return inflater.inflate(R.layout.evo_fragment, container, false);
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        Bundle bundle = new Bundle();
        bundle.putString("num", ((TextView)view.findViewById(R.id.evo_name)).getText().toString());
        ((Main)getActivity()).popToDexTabs();

        ((Main)getActivity()).loadPokemonFromJSON(((TextView)view.findViewById(R.id.evo_name)).getText().toString());

        DexTabFragment dexTabFragment = new DexTabFragment();
        dexTabFragment.setArguments(bundle);

        ((Main)getActivity()).addFragment(dexTabFragment, "Dex Tab");
    }
}
