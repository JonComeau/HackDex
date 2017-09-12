package com.skazerk.hackdex.Old.DexTabs;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.skazerk.hackdex.Remake.DexList.DexTabs.Area.Area_Fragment;
import com.skazerk.hackdex.Remake.DexList.DexTabs.Evolution.Evo_Fragment;
import com.skazerk.hackdex.Remake.DexList.DexTabs.Moves.Moves_Fragment;
import com.skazerk.hackdex.Remake.GlobalClass;
import com.skazerk.hackdex.R;
import com.skazerk.hackdex.Remake.DexList.DexTabs.Info.Info_Fragment;

import java.io.IOException;
import java.io.InputStream;

public class Dex_Main extends AppCompatActivity {

    private static Dex_Main dex;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String game;
    private int entryNum;
    private String json;
    private GlobalClass global;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    public int getEntryNum() {
        return entryNum;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onResume() {
        super.onResume();

        Log.d("Creation", "Resumed, Entry Number:" + entryNum);

        Intent intent = getIntent();
        game = intent.getStringExtra("game");
        entryNum = intent.getIntExtra("num", 0);

        String poke;
        String path;

        // Selecting the pokemon from the correct string array
        switch(game){
            case "vega":
                poke = getResources().getStringArray(R.array.vega)[entryNum];
                break;
            default:
                poke = null;
                break;
        }

        global = (GlobalClass)getApplicationContext();

        path = "games/" + game + "/pokemon/" + poke.toLowerCase() + "/" + poke.toLowerCase();

        //Grabbing the JSON for the pokemon
        json = loadJSONFromAsset(path);

        Log.d("JSON", json);

        //global.setPoke(new Pokemon());

        Log.d("Pokemon", "starting parse");
        //global.getPoke().parseJSON(json);

        //Log.d("Info_Poke", global.getPoke().getNumName()[0] + "");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.navi_drawer);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.app_name, R.string.app_name);

        //viewPager = (ViewPager) findViewById(R.id.dex_fragment);
        PagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        Log.d("FragManager", "ViewPager is set up");
        //tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        Log.d("FragManager", "Dex_Main is set up");
    }

    public void onDestroy(){
        super.onDestroy();
    }

    public String getJSON(){
        return json;
    }

    public String loadJSONFromAsset(String path){
        String json = null;
        try {

            AssetManager am = getAssets();
            InputStream is = am.open(path);

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();

            json = new String(buffer);

        } catch (IOException e){
            e.printStackTrace();
            return null;
        }

        return json;
    }

    public void onClick(View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        switch(view.getId()){
            case R.id.abil1:
                //dialog.setTitle(global.getInfoLayout().getAbilties().get(0).getAbitily());
                //dialog.setMessage(global.getInfoLayout().getAbilties().get(0).getEffect());
                dialog.show();
                break;
            case R.id.abil2:
                //dialog.setTitle(global.getInfoLayout().getAbilties().get(1).getAbitily());
                //dialog.setMessage(global.getInfoLayout().getAbilties().get(1).getEffect());
                dialog.show();
                break;
            case R.id.abil3:
                //dialog.setTitle(global.getInfoLayout().getAbilties().get(2).getAbitily());
                //dialog.setMessage(global.getInfoLayout().getAbilties().get(2).getEffect());
                dialog.show();
                break;
        }
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter{

        public ViewPagerAdapter(FragmentManager manager){
            super(manager);
        }

        @Override
        public Fragment getItem(int position){
            switch (position) {
                case 0:
                    return new Info_Fragment();
                case 1:
                    return new Moves_Fragment();
                case 2:
                    return new Area_Fragment();
                case 3:
                    return new Evo_Fragment();
            }
            return null;
        }

        @Override
        public int getCount(){
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position){
            switch (position) {
                case 0:
                    return "Info";
                case 1:
                    return "Moves";
                case 2:
                    return "Area";
                case 3:
                    return "Evo";
                default: return null;
            }
        }
    }

    public static synchronized Dex_Main getInstance(){
        return dex;
    }
}
