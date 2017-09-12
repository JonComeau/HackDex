package com.skazerk.hackdex.Old.Attacks;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.skazerk.hackdex.Old.NaviDrawer;
import com.skazerk.hackdex.R;

public class AttackMain extends AppCompatActivity {

    private String[] items;
    private DrawerLayout drawerLayout;
    private ListView drawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attack_main);

        items = new String[]{"Dex Selection", "Pokemon", "Attacks", "Locations"};
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);

        //drawerList.setAdapter(new ArrayAdapter<String>(this,
        //        R.layout.drawer_list_item, items));

        NaviDrawer naviDrawer = new NaviDrawer(this);

        drawerList.setOnItemClickListener(naviDrawer.new DrawerItemClickListener());
    }
}
