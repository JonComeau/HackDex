package com.skazerk.hackdex;

import android.app.Application;

import com.skazerk.hackdex.DexList.DexTabs.Info.InfoLayout;
import com.skazerk.hackdex.DexList.DexTabs.Info.NameLayout;
import com.skazerk.hackdex.DexList.DexTabs.Utils.Pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Skaze on 12/14/16.
 */

public class GlobalClass extends Application {
    private List<String> pokemon = new ArrayList<>();
    private String game;
    private List<Move> moves;

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

    public GlobalClass() {

    }

    public GlobalClass(String game){
        poke = new Pokemon();
        this.game = game;
        loadMoves();
    }

    public List<String> getMoves(){
        List<String> tmp_moves = new ArrayList<>();
        for (Move move : moves) {
            tmp_moves.add(move.name);
        }
        return tmp_moves;
    }

    public void loadMoves() {
        moves = new ArrayList<>();
        try {
            InputStream gameInput = getAssets().open("games/" + game + "/moves.json");
            Scanner scanner = new Scanner(gameInput).useDelimiter("\\A");
            String pokemonJSONStr = scanner.hasNext() ? scanner.next() : "";

            JSONObject masterJSONObj = new JSONObject(pokemonJSONStr);
            JSONArray moveJSONArray = masterJSONObj.getJSONArray("move");
            for (int i = 0; i < moveJSONArray.length(); i++) {
                JSONObject moveJSONObj = moveJSONArray.getJSONObject(i);
                Move tmp_move = new Move();
                tmp_move.name = moveJSONObj.getString("name");
                tmp_move.inGameText = moveJSONObj.getString("text");
                tmp_move.inGameEffect = moveJSONObj.getString("effect");
                tmp_move.basePP = moveJSONObj.getString("pp");
                moves.add(tmp_move);
            }
            Collections.sort(moves, new MoveComparator());
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }

    public void resetPoke() { this.poke = new Pokemon(); }

    public Pokemon getPoke() { return poke; }

    public class Move {
        public String name;
        public String inGameText;
        public String inGameEffect;
        public String basePP;
    }

    private class MoveComparator implements Comparator<Move> {

        @Override
        public int compare(Move move, Move t1) {
            return move.name.compareTo(t1.name);
        }
    }
}
