package com.skazerk.hackdex.Utils.Global;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Skaze on 9/13/17.
 */

public class Moves {
    private GlobalClass global;
    private List<Move> moves;
    private List<MachineMove> tms;
    private Map<String, List<PokemonSmall>> pokemonByMove;

    public Moves(Context context) {
        global = (GlobalClass) context;
        moves = new ArrayList<>();
        tms = new ArrayList<>();
        pokemonByMove = new HashMap<>();
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

    public List<String> getTms() {
        List<String> tmp = new ArrayList<>();

        for (MachineMove move : tms) {
            tmp.add(move.machineName);
        }

        return tmp;
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
        Log.e("Moves", "Load Game: " + global.getGame());
        try {
            String moveJSONStr = global.getMain().loadJSONFromAsset("games/" + global.getGame() +
                    "/moves.json");
            String pokemonMoveJSONStr = global.getMain().loadJSONFromAsset("games/" + global.getGame() +
                    "/pokemon_move.json");
            String tmJSONStr = global.getMain().loadJSONFromAsset("games/" + global.getGame() +
                    "/tmMoves.json");
            Log.v("JSON", tmJSONStr);

            JSONObject moveJSONObj = new JSONObject(moveJSONStr);
            JSONArray moveJSONArray = moveJSONObj.getJSONArray("moves");
            for (int i = 0; i < moveJSONArray.length(); i++) {
                JSONObject moveObj = moveJSONArray.getJSONObject(i);
                Move tmp_move = new Move();
                tmp_move.name = moveObj.getString("move_name");
                tmp_move.type = moveObj.getString("type");
                tmp_move.catagory = moveObj.getString("catagory");
                tmp_move.power = moveObj.getString("power");
                tmp_move.accuracy = moveObj.getString("accuracy");
                tmp_move.basePP = moveObj.getString("pp");
                moves.add(tmp_move);
            }
            Collections.sort(moves, new MoveComparator());

            JSONObject tmJSONObj = new JSONObject(tmJSONStr);
            JSONArray tmJSONArray = tmJSONObj.getJSONArray("moves");
            for (int i = 0; i < tmJSONArray.length(); i++) {
                JSONObject tmObj = tmJSONArray.getJSONObject(i);
                Log.v("JSON", tmObj.toString());
                MachineMove tmp_move = new MachineMove();
                tmp_move.isHM = tmObj.getString("tm").contains("HM");
                tmp_move.machineName = tmObj.getString("move_name");
                tmp_move.machineNumber = tmObj.getString("tm").substring(3);
                tms.add(tmp_move);
            }

            JSONObject pokemonMoveJSONObj = new JSONObject(pokemonMoveJSONStr);
            for (Move move : moves) {
                if (!pokemonMoveJSONObj.has(move.name))
                    continue;
                Log.v("Moves", "Move name: " + move.name);
                JSONObject pokemonMoveJSONNameObj = pokemonMoveJSONObj.getJSONObject(move.name);
                List<String> keys = new ArrayList<>();
                if (pokemonMoveJSONNameObj.has("level"))
                    keys.add("level");

                List<PokemonSmall> tmp;

                for (String key : keys) {
                    JSONArray pokemonMoveArray = pokemonMoveJSONNameObj.getJSONArray(key);

                    for (int j = 0; j < pokemonMoveArray.length(); j++) {
                        JSONObject pokemonMoveObj = pokemonMoveArray.getJSONObject(j);
                        String pokemon = pokemonMoveObj.getString("pokemon");
                        Log.d("Moves", pokemon);
                        if (pokemonByMove.containsKey(move.name)) {
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
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public class MachineMove {
        public boolean isHM;
        public String machineName;
        public String machineNumber;
    }
}
