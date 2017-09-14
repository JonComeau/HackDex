package com.skazerk.hackdex.PokeDexList.DexTabs.Utils.Global;

import android.content.Context;

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
 * Created by Skaze on 9/13/17.
 */

public class Moves {
    private List<Move> moves;

    public List<String> getMoves() {
        List<String> tmp_moves = new ArrayList<>();
        for (Move move : moves) {
            tmp_moves.add(move.name);
        }
        return tmp_moves;
    }

    private class MoveComparator implements Comparator<Move> {

        @Override
        public int compare(Move move, Move t1) {
            return move.name.compareTo(t1.name);
        }
    }

    public class Move {
        public String name;
        public String inGameText;
        public String inGameEffect;
        public String basePP;
    }

    public void loadMoves(Context context, String game) {
        moves = new ArrayList<>();
        try {
            InputStream gameInput = context.getAssets().open("games/" + game + "/moves.json");
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
}
