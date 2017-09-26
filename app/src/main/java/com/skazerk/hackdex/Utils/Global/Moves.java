package com.skazerk.hackdex.Utils.Global;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by Skaze on 9/13/17.
 */

public class Moves {
    private GlobalClass global;
    private List<Move> moves;
    private Map<String, List<PokemonSmall>> pokemonByMove;

    public Moves(Context context) {
        global = (GlobalClass) context;
        loadMoves();
        Log.e("GlobalContext", "Game: " + global.getGame());
    }

    public List<String> getMoves() {
        List<String> tmp_moves = new ArrayList<>();
        for (Move move : moves) {
            tmp_moves.add(move.name);
        }
        return tmp_moves;
    }

    public Move getMoveStats(String move) {
        for (Move tmpMove : moves) {
            if (tmpMove.name.equals(move)) {
                return tmpMove;
            }
        }
        return new Move();
    }

    public List<PokemonSmall> getPokemonByMove(String move) {
        return pokemonByMove.get(move);
    }

    private class MoveComparator implements Comparator<Move> {
        @Override
        public int compare(Move move, Move t1) {
            return move.name.compareTo(t1.name);
        }
    }

    public Map<String, List<PokemonSmall>> getPokemonByMove() {
        return pokemonByMove;
    }

    public class Move {
        public String name;
        public String type;
        public String catagory;
        public String power;
        public String accuracy;
        public String basePP;
    }

    public void loadMoves() {
        moves = new ArrayList<>();
        Log.e("GlobalContext", "Load Game: " + global.getGame());
        try {
            String pokemonJSONStr = global.getMain().loadJSONFromAsset("games/" + global.getGame() +
                    "/moves" + ".json");
            String pokemonMoveJSONStr = global.getMain().loadJSONFromAsset("games/" + global.getGame() +
                    "/pokemon_move.json");

            JSONObject moveJSONObj = new JSONObject(pokemonJSONStr);
            JSONArray moveJSONArray = moveJSONObj.getJSONArray("move");
            for (int i = 0; i < moveJSONArray.length(); i++) {
                JSONObject moveObj = moveJSONArray.getJSONObject(i);
                Move tmp_move = new Move();
                tmp_move.name = moveObj.getString("name");
                tmp_move.type = moveObj.getString("type");
                tmp_move.catagory = moveObj.getString("catagory");
                tmp_move.power = moveObj.getString("power");
                tmp_move.accuracy = moveObj.getString("accuracy");
                tmp_move.basePP = moveObj.getString("pp");
                moves.add(tmp_move);
            }
            Collections.sort(moves, new MoveComparator());

            JSONObject pokemonMoveJSONObj = new JSONObject(pokemonMoveJSONStr);
            for (Move move : moves) {
                JSONArray pokemonMoveJSONArray = pokemonMoveJSONObj.getJSONArray(move.name);
                for (int i = 0; i < pokemonMoveJSONArray.length(); i++) {
                    JSONObject pokemonMoveObj = pokemonMoveJSONArray.getJSONObject(i);

                    List<PokemonSmall> tmp = pokemonByMove.get(move.name);
                    String pokemon = pokemonMoveObj.getString("pokemon");
                    Log.d("Moves", pokemon);
                    if (tmp != null) {
                        pokemonByMove.get(move.name).add(new PokemonSmall((global.getPokemon()
                                .indexOf(pokemon) + 1) + "", pokemon));
                    } else {
                        tmp = new ArrayList<>();
                        tmp.add(new PokemonSmall((global.getPokemon()
                                .indexOf(pokemon) + 1) + "", pokemon));
                        pokemonByMove.put(move.name, tmp);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
