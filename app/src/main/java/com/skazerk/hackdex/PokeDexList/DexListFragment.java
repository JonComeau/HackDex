package com.skazerk.hackdex.PokeDexList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.skazerk.hackdex.PokeDexList.DexTabs.DexTabFragment;
import com.skazerk.hackdex.PokeDexList.DexTabs.Utils.Global.GlobalClass;
import com.skazerk.hackdex.R;
import com.skazerk.hackdex.Main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skaze on 9/4/17.
 */

public class DexListFragment extends ListFragment {
    private GlobalClass global;
    private EntryAdapter eAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        global = (GlobalClass) getContext().getApplicationContext();

        eAdapter = new EntryAdapter();

        int index = 1;
        for (String pokemon : global.getPokemon()) {
            eAdapter.addItem(index++, pokemon);
        }

        setListAdapter(eAdapter);

        return inflater.inflate(R.layout.dex_fragment, container, false);
    }

    private class EntryAdapter extends BaseAdapter {
        private List<String[]> eData = new ArrayList<>();
        private LayoutInflater eInflator;

        EntryAdapter(){
            eInflator = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

         void addItem(final int number, final String name){
            String[] dexArray = {"" + number, name};
            eData.add(dexArray);
            notifyDataSetChanged();
        }

        @Override
        public int getCount(){
            return eData.size();
        }

        @Override
        public String[] getItem(int position){
            return eData.get(position);
        }

        @Override
        public long getItemId(int position){
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            Log.d("MyApp", "getView " + position);
            ViewHolder holder = null;

            if(convertView == null){
                convertView = eInflator.inflate(R.layout.dex_list_item, null);
                holder = new ViewHolder();
                holder.num = convertView.findViewById(R.id.dex_item_num);
                holder.name = convertView.findViewById(R.id.dex_item_name);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.num.setText(eData.get(position)[0]);
            holder.name.setText(eData.get(position)[1]);

            return convertView;
        }
    }

    private static class ViewHolder{
        public TextView name;
        public TextView num;
    }

    public void onListItemClick(ListView listView, View view, int position, long id) {
        Bundle bundle = new Bundle();
        bundle.putString("num", position + "");
        ((Main)getActivity()).loadPokemonFromJSON(global.getPokemon().get(position));

        DexTabFragment dexTabFragment = new DexTabFragment();
        dexTabFragment.setArguments(bundle);

        ((Main)getActivity()).addFragment(dexTabFragment, "Dex Tab");
    }
}
