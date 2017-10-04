package com.skazerk.hackdex;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.skazerk.hackdex.AttackDexList.Tabs.AttackDexTabFragment;
import com.skazerk.hackdex.PokeDexList.DexListFragment;
import com.skazerk.hackdex.Utils.Activity;
import com.skazerk.hackdex.Utils.Dialog.CustomDialog;
import com.skazerk.hackdex.Utils.Global.GlobalClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends AppCompatActivity {
    private String tag = "MAIN";
    private int index;

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    private List<String> games;

    private GlobalClass global;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        global = (GlobalClass) getApplicationContext();

        loadGames();
        createPreferences();

        global.reset(this);

        setupNaviDrawer();
        initFragment();
    }

    private void setupNaviDrawer() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.navi_drawer);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        toolbar.setNavigationIcon(R.drawable.navi_menu);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if(menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                drawerLayout.closeDrawers();

                switch (menuItem.getItemId()){
                    case R.id.poke_dex:
                        index = 0;
                        setListIndex(index);
                        initFragment();
                        Toast.makeText(getApplicationContext(),"Pokedex Selected",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.attack_dex:
                        index = 1;
                        setListIndex(index);
                        initFragment();
                        Toast.makeText(getApplicationContext(),"Attackdex Selected",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.location_dex:
                        //index = 2;
                        setListIndex(index);
                        initFragment();
                        Toast.makeText(getApplicationContext(),"Locationdex Selected",Toast.LENGTH_SHORT).show();
                        return true;
                }

                return false;
            }
        });
    }

    public void setListIndex(int index) {
        SharedPreferences settings = getSharedPreferences("app", MODE_PRIVATE);

        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("listIndex", index);
        editor.apply();
    }

    public void loadPokemonFromJSON(String pokemon) {
        String path = "games/" + global.getGame() + "/pokemon/" + pokemon.toLowerCase() + "/" + pokemon.toLowerCase();
        String pokemonJSON = loadJSONFromAsset(path);
        Log.d("Main", pokemonJSON);
        global.resetPoke();
        global.getPoke().parseJSON(pokemonJSON);
    }

    public String loadJSONFromAsset(String path) {
        String json;
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

    private void initFragment() {
        if(findViewById(R.id.dex_fragment) != null) {

            Fragment fragment = new Fragment();

            switch (this.index) {
                case 0:
                    fragment = new DexListFragment();
                    break;
                case 1:
                    fragment = new AttackDexTabFragment();
                    break;
                case 2:
                    break;
            }

            Bundle bundle = new Bundle();
            bundle.putString("game", global.getGame());
            fragment.setArguments(bundle);
            addFragment(fragment, "Dex List");
        }
    }

    public void popToDexTabs() {
        getSupportFragmentManager().popBackStack("Dex Tab", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        global.reset(this);
    }

    public void addFragment(Fragment fragment, String name) {
        if(getSupportFragmentManager().getBackStackEntryCount() == 0) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.dex_fragment, fragment)
                    .addToBackStack(name)
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.dex_fragment, fragment)
                    .addToBackStack(name)
                    .commit();
        }
    }

    public void onClick(View view, String type) {
        TextView text;
        switch (type) {
            case "ability":
                text = (TextView) view;
                String ability = text.getText().toString().split("\n")[1];
                showDialog(ability, type);
                break;
            case "move":
                text = view.findViewById(R.id.move_name);
                String move = text.getText().toString();
                showDialog(move, type);
                break;
        }
    }

    private void loadGames(){
        games = new ArrayList<>();
        try {
            InputStream gameInput = getAssets().open("games/gameInfo.json");
            Scanner scanner = new Scanner(gameInput).useDelimiter("\\A");
            String gameJSONStr = scanner.hasNext() ? scanner.next() : "";

            JSONObject masterJSONObj = new JSONObject(gameJSONStr);
            JSONArray gameJSONArray = masterJSONObj.getJSONArray("dex");
            for (int i = 0; i < gameJSONArray.length(); i++){
                JSONObject gameJSONObj = gameJSONArray.getJSONObject(i);
                games.add(gameJSONObj.getString("name"));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    private void createPreferences(){
        SharedPreferences settings = getSharedPreferences("app", MODE_PRIVATE);
        if (!settings.contains("current")) {
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("current", "vega");
            editor.apply();
        } else {
            Log.d("Settings", settings.getString("current", "Nothing"));
        }
        if (!settings.contains("activity")) {
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("activity", Activity.Pokedex.getValue());
            editor.apply();
        }
        global.setActivity(Activity.valueOf(settings.getInt("activity", 0)));
        if (!settings.contains("listIndex")) {
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("listIndex", 0);
            editor.apply();
        }
        index = settings.getInt("listIndex", 0);
    }

    public void onBackPressed() {
        Log.d("BackStack", getSupportFragmentManager().getBackStackEntryCount() + "");
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finishAndRemoveTask();
        }
    }

    public void showDialog(String listTitle, String listType) {
        Log.v("Dialog", listTitle + ", " + listType);
        FragmentTransaction transaction = (this).getSupportFragmentManager().beginTransaction();
        CustomDialog.newInstance(listTitle, listType).show(transaction, listType);
    }
}
