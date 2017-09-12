package com.skazerk.hackdex.AttackDexList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.skazerk.hackdex.DexList.DexListFragment;
import com.skazerk.hackdex.GlobalClass;
import com.skazerk.hackdex.R;

/**
 * Created by jcomeau on 9/12/2017.
 */

public class AttackDexListFragment extends ListFragment {
    private GlobalClass global;
    private ArrayAdapter mAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        global = (GlobalClass) getActivity().getApplicationContext();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        global = (GlobalClass) getContext().getApplicationContext();

        int index = 1;
        mAdapter = new ArrayAdapter(getActivity(), R.layout.simple_list_item_layout, global.getMoves().toArray());

        setListAdapter(mAdapter);

        return inflater.inflate(R.layout.dex_fragment, container, false);
    }
}
