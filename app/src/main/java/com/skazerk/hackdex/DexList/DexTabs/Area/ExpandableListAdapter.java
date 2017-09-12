package com.skazerk.hackdex.DexList.DexTabs.Area;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.skazerk.hackdex.DexList.DexTabs.Utils.Pokemon;
import com.skazerk.hackdex.GlobalClass;
import com.skazerk.hackdex.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Skaze on 2/4/17.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private GlobalClass global;
    private Pokemon poke;

    private List<String> headers;
    private HashMap<String, List<String>> children;

    public ExpandableListAdapter(Context context, List<String> listHeader,
                                 HashMap<String, List<String>> listChild) {
        this.context = context;
        this.headers = listHeader;
        this.children = listChild;
        global = (GlobalClass)context;
        //poke = global.getPoke();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.children.get(this.headers.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.area_item, null);
        }

        final TextView text = (TextView) convertView.findViewById(R.id.area_item);
        TextView percent = (TextView) convertView.findViewById(R.id.area_percent);

        String[] parts = childText.split(",");

        text.setText(parts[0]);
        percent.setText(parts[1] + "%");

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition){
        return this.children.get(this.headers.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.headers.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.headers.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String header = (String) getGroup(groupPosition);

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.area_header, null);
        }

        TextView text = (TextView) convertView.findViewById(R.id.area_header);

        text.setText(header);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
