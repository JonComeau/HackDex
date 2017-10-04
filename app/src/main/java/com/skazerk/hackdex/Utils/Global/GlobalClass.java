package com.skazerk.hackdex.Utils.Global;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import com.skazerk.hackdex.Main;
import com.skazerk.hackdex.PokeDexList.DexTabs.Info.InfoLayout;
import com.skazerk.hackdex.PokeDexList.DexTabs.Info.NameLayout;
import com.skazerk.hackdex.Utils.Activity;
import com.skazerk.hackdex.Utils.Pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Skaze on 12/14/16.
 */

public class GlobalClass extends Application {
    private Moves moves;
    private Abilities abilities;
    private List<String> pokemon = new ArrayList<>();
    private String game;
    private Pokemon poke;
    private InfoLayout infoLayout;
    private NameLayout nameLayout;
    private Main main;
    private Activity activity;

    public GlobalClass() {
    }

    public void reset(Main main) {
        resetPoke();
        this.main = main;
        openSharedPreferences();
        loadPokemon();
        this.abilities = new Abilities(this);
        this.moves = new Moves(this);
    }

    private void openSharedPreferences() {
        SharedPreferences settings = getSharedPreferences("app", MODE_PRIVATE);
        this.game = settings.getString("current", "");
        Log.e("GlobalContext", this.game);
    }

    public Main getMain() {
        return this.main;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public Map<String, List<PokemonSmall>> getPokemonByAbility() {
        return abilities.getPokemonByAbility();
    }

    public Map<String, List<PokemonSmall>> getPokemonByMove() {
        return moves.getPokemonByMove();
    }

    public Moves.Move getMoveStats(String move) {
        return moves.getMoveStats(move);
    }

    public List<String> getAbilityInfoAndEffect(String ability) {
        return abilities.getAbilityInfoAndEffect(ability);
    }

    public List<String> getTms() {
        return moves.getTms();
    }

    public List<String> getPokemon() {
        return pokemon;
    }

    public int getDexAmount() {
        return pokemon.size();
    }

    public void loadPokemon() {
        try {
            InputStream gameInput = getAssets().open("games/" + game + "/pokemon.json");
            Scanner scanner = new Scanner(gameInput).useDelimiter("\\A");
            String pokemonJSONStr = scanner.hasNext() ? scanner.next() : "";

            JSONObject masterJSONObj = new JSONObject(pokemonJSONStr);
            JSONArray pokemonJSONArray = masterJSONObj.getJSONArray("pokemon");
            for (int i = 0; i < pokemonJSONArray.length(); i++) {
                JSONObject pokemonJSONObj = pokemonJSONArray.getJSONObject(i);
                pokemon.add(pokemonJSONObj.getString("name"));
                Log.v("GlobalClass", pokemon.indexOf(pokemonJSONObj.getString("name")) + "");
            }
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }

    public NameLayout getNameLayout() {
        return nameLayout;
    }

    public void setNameLayout(NameLayout nameLayout) {
        this.nameLayout = nameLayout;
        this.nameLayout.setNum(poke.getNumName()[0]);
        this.nameLayout.setName(poke.getNumName()[1]);
        this.nameLayout.setType(poke.getTypes());
    }

    public InfoLayout getInfoLayout() {
        return infoLayout;
    }

    public void setInfoLayout(InfoLayout infoLayout) {
        this.infoLayout = infoLayout;
        this.infoLayout.setEntry(poke.getEntry());
        this.infoLayout.setAbility(poke.getAbilities());
        this.infoLayout.setEffects(poke.getEffects());
        this.infoLayout.setStats(poke.getStats());
    }

    public List<String> getMoves() {
        return moves.getMoves();
    }

    public List<String> getAbilities(String ability) {
        return abilities.getAbilities(ability);
    }

    public void resetPoke() {
        Log.d("GlobalClass", "New Pokemon");
        this.poke = new Pokemon();
    }

    public Pokemon getPoke() { return poke; }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Activity getActivity() {
        return activity;
    }
}
