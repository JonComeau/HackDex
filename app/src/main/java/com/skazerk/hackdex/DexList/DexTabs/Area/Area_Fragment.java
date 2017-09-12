package com.skazerk.hackdex.DexList.DexTabs.Area;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.skazerk.hackdex.GlobalClass;
import com.skazerk.hackdex.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Skaze on 11/17/16.
 */

public class Area_Fragment extends Fragment {
    private GlobalClass global;
    private ExpandableListAdapter lAdapter;
    private ExpandableListView expListView;
    private List<String> header;
    private HashMap<String, List<String>> children;

    public Area_Fragment(){
        //stuff
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        global = (GlobalClass)getContext().getApplicationContext();

        return inflater.inflate(R.layout.area_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        expListView = (ExpandableListView) view.findViewById(R.id.area_list);

        insertListData();

        lAdapter = new ExpandableListAdapter(
                global.getApplicationContext(),
                header,
                children
        );

        expListView.setAdapter(lAdapter);
    }



    private void insertListData() {
        header = new ArrayList<>();
        children = new HashMap<>();

        if(global.getPoke().getArea().walking.size() > 0){
            header.add("Walking");
        }
        if(global.getPoke().getArea().surfing.size() > 0) {
            header.add("Surfing");
        }
        if(global.getPoke().getArea().fishing.size() > 0) {
            header.add("Fishing");
        }
        if(global.getPoke().getArea().event.size() > 0) {
            header.add("Event");
        }

        List<String> walking = new ArrayList<>();

        for(int i = 0; i < global.getPoke().getArea().walking.size(); i++) {
            ArrayList<String> tmp = global.getPoke().getArea().getAreaInfo("walking", 0);
            walking.add(tmp.get(1) + "," + tmp.get(0));
        }

        if(walking.size() != 0)
            children.put(header.get(0), walking);
    }
}
