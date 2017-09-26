package com.skazerk.hackdex.Utils;

import com.skazerk.hackdex.PokeDexList.DexTabs.Area.Area;
import com.skazerk.hackdex.PokeDexList.DexTabs.Info.Ability;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skaze on 11/30/16.
 */

public class Pokemon {
    private String[] num_name = new String[2];
    private ArrayList<String> types = new ArrayList<>();
    private ArrayList<Ability> abilities = new ArrayList<>();
    private String entry = "";
    private ArrayList<Stat> stats = new ArrayList<>();
    private ArrayList<Move> lvl_moves = new ArrayList<>();
    private ArrayList<Integer> effects = new ArrayList<>();

    private ArrayList<ArrayList<String>> evos = new ArrayList<>();

    //area list: walking, surfing, fishing, event
    private Area areas = new Area();

    public String getPer(String area, String method) {
        switch(method) {
            case "Walking":
                for(int i = 0; i < areas.walking.size();i++){
                    if(areas.getAreaInfo("walking", i).get(1).equals(area)){
                        return areas.getAreaInfo("walking", i).get(0);
                    }
                }
            case "Surfing":
                for(int i = 0; i < areas.walking.size();i++){
                    if(areas.getAreaInfo("surfing", i).get(1).equals(area)){
                        return areas.getAreaInfo("surfing", i).get(0);
                    }
                }
            case "Fishing":
                for(int i = 0; i < areas.walking.size();i++){
                    if(areas.getAreaInfo("fishing", i).get(1).equals(area)){
                        return areas.getAreaInfo("fishing", i).get(0);
                    }
                }
            case "Event":
                for(int i = 0; i < areas.walking.size();i++){
                    if(areas.getAreaInfo("event", i).get(1).equals(area)){
                        return areas.getAreaInfo("event", i).get(0);
                    }
                }
        }
        return null;
    }

    public class Move{
        public String lvl;
        public String move;
        public String type;
        public String catagory;
    }

    public class Stat{
        public String stat;
        public String amount;

        public String toString() {
            return stat + " " + amount;
        }
    }

    public String[] getNumName(){
        return num_name;
    }

    public String getEntry() { return entry; }

    public ArrayList<String> getTypes(){
        return types;
    }

    public ArrayList<Ability> getAbilities(){
        return abilities;
    }

    public ArrayList<Move> getLvlMoves(){
        return lvl_moves;
    }

    public ArrayList<Stat> getStats() { return stats; }

    public Area getArea(){
        return areas;
    }

    public ArrayList<ArrayList<String>> getEvos() { return evos; }

    public int getTypeCount(){
        return types.size();
    }

    public List<Integer> getEffects() {
        return TypeEffects.typeEffects(this.types);
    }

    public void parseJSON(String json){
        try {
            JSONObject obj = new JSONObject(json);
            JSONObject poke_obj = obj.getJSONObject("pokemon");

            num_name[0] = poke_obj.getString("num");

            num_name[1] = poke_obj.getString("name");

            entry = poke_obj.getString("entry");

            //parsing types
            JSONArray type_arr = poke_obj.getJSONArray("type_list");
            for (int i = 0; i < type_arr.length(); i++){
                JSONObject type_obj = type_arr.getJSONObject(i);
                types.add(type_obj.getString("type"));
            }

            //parsing abilities
            JSONArray abil_arr = poke_obj.getJSONArray("ability");
            for (int i = 0; i < abil_arr.length(); i++){
                JSONObject abil_obj = abil_arr.getJSONObject(i);
                Ability abil = new Ability(abil_obj.getString("ability"), abil_obj.getString
                        ("text"), abil_obj.getString("effect"));

                abilities.add(abil);
            }

            //parsing stats
            JSONArray stat_arr = poke_obj.getJSONArray("stats");
            for(int i = 0; i < stat_arr.length(); i++){
                JSONObject stat_obj = stat_arr.getJSONObject(i);
                Stat tmp_stat = new Stat();
                tmp_stat.stat = stat_obj.getString("stat");
                tmp_stat.amount = stat_obj.getString("amount");

                stats.add(tmp_stat);
            }

            //parsing moves
            JSONObject move_obj = poke_obj.getJSONObject("moves");

            //parsing the move_lvl moves
            JSONArray lvl_arr = move_obj.getJSONArray("level");
            for (int i = 0; i < lvl_arr.length(); i++) {
                JSONObject lvl_obj = lvl_arr.getJSONObject(i);
                Move tmp_move = new Move();
                tmp_move.lvl = lvl_obj.getString("lvl");
                tmp_move.move = lvl_obj.getString("move");
                tmp_move.type = lvl_obj.getString("type");
                tmp_move.catagory = lvl_obj.getString("catagory");

                lvl_moves.add(tmp_move);
            }

            //parsing the areas
            JSONObject area_obj = poke_obj.getJSONObject("areas");

            //parsing the walking areas
            JSONArray walk_arr = area_obj.getJSONArray("walking");
            for(int i = 0; i < walk_arr.length(); i++){
                JSONObject walk_obj = walk_arr.getJSONObject(i);
                areas.addArea("walking", walk_obj.getString("area"),
                        walk_obj.getString("percent"));
            }

            //parsing the surfing areas
            JSONArray surf_arr = area_obj.getJSONArray("surfing");
            for(int i = 0; i < surf_arr.length(); i++){
                JSONObject surf_obj = surf_arr.getJSONObject(i);
                areas.addArea("surfing", surf_obj.getString("area"),
                        surf_obj.getString("percent"));
            }

            //parsing the fishing areas
            JSONArray fish_arr = area_obj.getJSONArray("fishing");
            for(int i = 0; i < fish_arr.length(); i++){
                JSONObject fish_obj = fish_arr.getJSONObject(i);
                areas.addArea("fishing", fish_obj.getString("area"),
                        fish_obj.getString("percent"));
            }

            //parsing the event areas
            JSONArray evnt_arr = area_obj.getJSONArray("event");
            for(int i = 0; i < evnt_arr.length(); i++){
                JSONObject evnt_obj = evnt_arr.getJSONObject(i);
                areas.addArea("event", evnt_obj.getString("area"),
                        evnt_obj.getString("percent"));
            }

            JSONArray evo_arr = poke_obj.getJSONArray("evolutions");

            for(int i = 0; i < evo_arr.length(); i++) {
                ArrayList<String> tmp = new ArrayList<>();

                JSONObject evo_obj = evo_arr.getJSONObject(i);

                tmp.add(evo_obj.getString("name"));
                tmp.add(evo_obj.getString("num"));
                tmp.add(evo_obj.getString("level"));

                evos.add(tmp);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
