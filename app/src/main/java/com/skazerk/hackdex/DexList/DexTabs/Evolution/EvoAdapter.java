package com.skazerk.hackdex.DexList.DexTabs.Evolution;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.skazerk.hackdex.R;

import java.util.ArrayList;

    /**
     * Created by Skaze on 12/27/16.
     */

public class EvoAdapter extends BaseAdapter {
    private ArrayList<ArrayList<String>> eData = new ArrayList<>();
    private LayoutInflater dInflater;

    public void addItem(String pokemon, String number, String level){
        ArrayList<String> tmp = new ArrayList<>();

        tmp.add(pokemon);
        tmp.add(level);
        tmp.add(number);

        Log.i("Evos", "Pokemon: " + tmp.get(0) + ", " + tmp.get(1));

        eData.add(tmp);

        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return eData.size();
    }

    @Override
    public ArrayList<String> getItem(int i) {
        return eData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (dInflater == null) {
            Context context = viewGroup.getContext();
            dInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        Log.d("Evo_List", "getting view");
        EvoHolder holder = null;

        if (view == null) {
            view = dInflater.inflate(R.layout.evo_item, viewGroup, false);
            holder = new EvoHolder();
            holder.pokemon = (TextView) view.findViewById(R.id.evo_name);
            holder.level = (TextView) view.findViewById(R.id.evo_level);
            holder.number = (TextView) view.findViewById(R.id.hidden);
            view.setTag(holder);
        } else {
            holder = (EvoHolder) view.getTag();
        }

        holder.pokemon.setText(eData.get(i).get(0));
        Log.d("EvoHolder", eData.get(i).get(0));
        holder.level.setText(eData.get(i).get(1));
        Log.d("EvoHolder", eData.get(i).get(1));

        holder.number.setText(eData.get(i).get(2));
        Log.d("EvoHolder", holder.number.getText().toString());

        return view;
    }

    private class EvoHolder{
        TextView pokemon;
        TextView level;
        TextView number;
    }
}
