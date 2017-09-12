package com.skazerk.hackdex.Remake;

import android.app.Application;

import com.skazerk.hackdex.Remake.DexList.DexTabs.Info.InfoLayout;
import com.skazerk.hackdex.Remake.DexList.DexTabs.Info.NameLayout;
import com.skazerk.hackdex.Remake.DexList.DexTabs.Utils.Pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Skaze on 12/14/16.
 */

public class GlobalClass extends Application {
    private List<String> pokemon = new ArrayList<>();
    private String game;

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public List<String> getPokemon() {
        return pokemon;
    }

    public int getDexAmount() {
        return pokemon.size() + 1;
    }

    public void loadPokemon(String game) {
        try {
            InputStream gameInput = getAssets().open("games/" + game + "/pokemon.json");
            Scanner scanner = new Scanner(gameInput).useDelimiter("\\A");
            String pokemonJSONStr = scanner.hasNext() ? scanner.next() : "";

            JSONObject masterJSONObj = new JSONObject(pokemonJSONStr);
            JSONArray pokemonJSONArray = masterJSONObj.getJSONArray("pokemon");
            for (int i = 0; i < pokemonJSONArray.length(); i++) {
                JSONObject pokemonJSONObj = pokemonJSONArray.getJSONObject(i);
                pokemon.add(pokemonJSONObj.getString("name"));
            }
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }

    private Pokemon poke;

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

    private InfoLayout infoLayout;
    private NameLayout nameLayout;

    public GlobalClass(){
        poke = new Pokemon();
    }

    public void resetPoke() { this.poke = new Pokemon(); }

    public Pokemon getPoke() { return poke; }
}
