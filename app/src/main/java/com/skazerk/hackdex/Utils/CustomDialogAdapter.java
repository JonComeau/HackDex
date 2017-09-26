package com.skazerk.hackdex.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.skazerk.hackdex.R;
import com.skazerk.hackdex.Utils.Global.PokemonSmall;

import java.util.List;

/**
 * Created by Skaze on 9/23/17.
 */

public class CustomDialogAdapter extends BaseAdapter {
    List<PokemonSmall> list;
    private LayoutInflater mInflater;

    public CustomDialogAdapter(List<PokemonSmall> list, Context context) {
        this.list = list;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = mInflater.inflate(R.layout.dex_list_item, null);
            holder.number = view.findViewById(R.id.dex_item_num);
            holder.pokemon = view.findViewById(R.id.dex_item_name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.number.setText(list.get(i).num);
        holder.pokemon.setText(list.get(i).name);

        return view;
    }

    public class ViewHolder {
        public TextView number;
        public TextView pokemon;
    }
}
