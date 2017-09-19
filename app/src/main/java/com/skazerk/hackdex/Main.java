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
import android.widget.TextView;
import android.widget.Toast;

import com.skazerk.hackdex.PokeDexList.DexListFragment;
import com.skazerk.hackdex.PokeDexList.DexTabs.Info.BottomSheetFragment;
import com.skazerk.hackdex.PokeDexList.DexTabs.Utils.Global.GlobalClass;

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
        initFragment(savedInstanceState);

        global.loadPokemon(global.getGame());
        global.reset(global.getGame(), this);

        setupNaviDrawer();
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
                        Toast.makeText(getApplicationContext(),"Pokedex Selected",Toast.LENGTH_SHORT).show();
//                        ContentFragment fragment = new ContentFragment();
//                        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                        fragmentTransaction.replace(R.id.frame,fragment);
//                        fragmentTransaction.commit();
                        return true;

                    case R.id.attack_dex:
                        Toast.makeText(getApplicationContext(),"Attackdex Selected",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.location_dex:
                        Toast.makeText(getApplicationContext(),"Locationdex Selected",Toast.LENGTH_SHORT).show();
                        return true;
                    }
                return false;
            }
        });
    }

    public void loadPokemonFromJSON(String pokemon) {
        String path = "games/" + global.getGame() + "/pokemon/" + pokemon.toLowerCase() + "/" + pokemon.toLowerCase();
        String pokemonJSON = loadJSONFromAsset(path);
        Log.d("Main", pokemonJSON);
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

    private void initFragment(Bundle savedInstanceState){
        if(findViewById(R.id.dex_fragment) != null) {
            if (savedInstanceState != null) {
                return;
            }
            DexListFragment fragment = new DexListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("game", global.getGame());
            fragment.setArguments(bundle);
            addFragment(fragment, "Dex List");
        }
    }

    public void popToDexTabs() {
        getSupportFragmentManager().popBackStack("Dex Tab", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        global.reset(global.getGame(), this);
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

    public void onClick(TextView view, String type) {
        switch (type) {
            case "ability":
                String ability = view.getText().toString().split("\n")[1];
                showBottomSheet(type, ability);
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
        SharedPreferences settings = getPreferences(MODE_PRIVATE);
        if (!settings.contains("current")) {
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("current", "vega");
            editor.apply();
        }
        global.setGame(settings.getString("current", null));
    }

    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    public void showBottomSheet(String version, String item) {
        FragmentTransaction transaction = (this)
                .getSupportFragmentManager()
                .beginTransaction();

        new BottomSheetFragment();
        BottomSheetFragment.newInstance(item, version).show(transaction, version);
    }
}
