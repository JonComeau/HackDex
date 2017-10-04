package com.skazerk.hackdex.Utils.Global;

import android.content.Context;
import android.util.Log;

import com.skazerk.hackdex.PokeDexList.DexTabs.Info.Ability;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Skaze on 9/13/17.
 */

public class Abilities {
    private Map<String, Ability> abilityMap;
    private Map<String, List<PokemonSmall>> pokemonByAbility;
    private GlobalClass global;

    public Abilities(Context context) {
        global = (GlobalClass) context;
        loadAbilities();
    }

    public void loadAbilities() {
        abilityMap = new HashMap<>();
        pokemonByAbility = new HashMap<>();
        loadAbilitiesFromAssets();
    }

    private void loadAbilitiesFromAssets() {
        String abilityJSONStr = global.getMain().loadJSONFromAsset("games/" + global.getGame() + "/abilities.json");
        String pokemonAbilityJSONStr = global.getMain().loadJSONFromAsset("games/" + global.getGame() + "/pokemon_ability.json");

        try {
            JSONObject abilityJSONObj = new JSONObject(abilityJSONStr);
            JSONArray abilityJSONArray = abilityJSONObj.getJSONArray("abilities");
            for (int i = 0; i < abilityJSONArray.length(); i++) {
                JSONObject abilityObj = abilityJSONArray.getJSONObject(i);
                abilityMap.put(abilityObj.getString("ability"), new Ability(abilityObj.getString("ability"), abilityObj.getString("text"), abilityObj.getString("effect")));
            }

            JSONObject pokemonAbilityJSONObj = new JSONObject(pokemonAbilityJSONStr);
            for (Object o : abilityMap.entrySet()) {
                Map.Entry pair = (Map.Entry) o;

                JSONArray pokemonAbilityJSONArray = pokemonAbilityJSONObj.getJSONArray((String) pair.getKey());

                for (int i = 0; i < pokemonAbilityJSONArray.length(); i++) {
                    JSONObject pokemonAbilityObj = pokemonAbilityJSONArray.getJSONObject(i);

                    List<PokemonSmall> value = pokemonByAbility.get(pair.getKey());
                    String pokemon = pokemonAbilityObj.getString("pokemon");
                    Log.d("Abilities", pokemon);
                    for (String poke : global.getPokemon()) {
                        Log.v("Abilities", poke);
                    }
                    if (value != null) {
                        pokemonByAbility.get(pair.getKey()).add(new PokemonSmall((global
                                .getPokemon().indexOf(pokemon) + 1) + "", pokemon));
                    } else {
                        value = new ArrayList<>();
                        value.add(new PokemonSmall((global.getPokemon().indexOf(pokemon) + 1) +
                                "", pokemon));
                        pokemonByAbility.put((String) pair.getKey(), value);
                    }
                }
            }
        } catch (Exception ex) {
            Log.wtf("Abilities", ex);
        }
    }

    public List<String> getAbilityInfoAndEffect(String ability) {
        List<String> list = new ArrayList<>();
        list.add(abilityMap.get(ability).getText());
        list.add(abilityMap.get(ability).getEffect());

        return list;
    }

    public Map<String, List<PokemonSmall>> getPokemonByAbility() {
        return pokemonByAbility;
    }

    public List<String> getAbilities(String ability) {
        List<String> tmpAbility = new ArrayList<>();

        return tmpAbility;
    }
}
