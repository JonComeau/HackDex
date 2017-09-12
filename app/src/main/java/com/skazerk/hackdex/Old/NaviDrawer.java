package com.skazerk.hackdex.Old;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.skazerk.hackdex.Remake.Main;

/**
 * Created by Skaze on 6/13/17.
 */

public class NaviDrawer {

    Context context;

    public NaviDrawer(Context context) {
        this.context = context;
    }

    public class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    /** Swaps fragments in the main content view */
    private void selectItem(int position) {
        //"Dex Selection", "Pokemon", "Attacks", "Locations"

        Intent intent;

        switch(position) {
            case 0:
                intent = new Intent(context, Main.class);
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}

