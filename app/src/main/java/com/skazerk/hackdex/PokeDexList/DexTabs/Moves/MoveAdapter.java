package com.skazerk.hackdex.PokeDexList.DexTabs.Moves;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.skazerk.hackdex.R;
import com.skazerk.hackdex.Utils.Pokemon;

import java.util.ArrayList;

/**
 * Created by Skaze on 12/27/16.
 */

public class MoveAdapter extends BaseAdapter {
    private ArrayList<MoveEntry> mData = new ArrayList<>();
    private LayoutInflater dInflater;

    public void addItem(final Pokemon.Move move){
        MoveEntry tmp = new MoveEntry();

        tmp.setLvl(move.lvl);
        tmp.setMove(move.move);
        tmp.setCatagory(move.catagory);
        tmp.setType(move.type);

        mData.add(tmp);

        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public MoveEntry getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (dInflater == null){
            Context context = viewGroup.getContext();
            dInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        Log.d("Move_List", "getting view");
        MoveHolder holder;

        if(view == null){
            view = dInflater.inflate(R.layout.move_entry, viewGroup, false);
            holder = new MoveHolder();
            holder.lvl = view.findViewById(R.id.move_lvl);
            holder.move = view.findViewById(R.id.move_name);
            holder.type = view.findViewById(R.id.move_type);
            holder.catagory = view.findViewById(R.id.move_cat);
            view.setTag(holder);
        } else {
            holder = (MoveHolder) view.getTag();
        }

        holder.lvl.setText(mData.get(i).getLvl());
        Log.d("MoveHolder", mData.get(i).getLvl());
        holder.move.setText(mData.get(i).getMove());
        Log.d("MoveHolder", mData.get(i).getMove());
        holder.type.setText(mData.get(i).getType());
        Log.d("MoveHolder", mData.get(i).getType());
        holder.catagory.setText(mData.get(i).getCatagory());
        Log.d("MoveHolder", mData.get(i).getCatagory());

        return view;
    }

    private class MoveEntry{
        //move_lvl = level
        //move = move name
        //type = move type
        //catagory = physical, special, effect
        private String lvl;
        private String move;
        private String type;
        private String catagory;

        public MoveEntry(){  }

        public MoveEntry(ArrayList<String> move_data){
            lvl = move_data.get(0);
            move = move_data.get(1);
            type = move_data.get(2);
            catagory = move_data.get(3);
        }

        public void setLvl(String lvl) {
            this.lvl = lvl;
        }

        public void setMove(String move) {
            this.move = move;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setCatagory(String catagory) {
            this.catagory = catagory;
        }

        public String getLvl() {
            return lvl;
        }

        public String getMove() {
            return move;
        }

        public String getType() {
            return type;
        }

        public String getCatagory() {
            return catagory;
        }
    }

    private class MoveHolder{
        TextView lvl;
        TextView move;
        TextView type;
        TextView catagory;
    }
}