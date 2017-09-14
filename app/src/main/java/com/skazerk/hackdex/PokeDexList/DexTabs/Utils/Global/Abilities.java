package com.skazerk.hackdex.PokeDexList.DexTabs.Utils.Global;

import android.content.Context;

import com.skazerk.hackdex.PokeDexList.DexTabs.Info.Ability;

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

    public void loadAbilities(Context context, String game) {
        abilityMap = new HashMap<>();
        pokemonByAbility = new HashMap<>();
    }

    public Map<String, List<PokemonSmall>> getPokemonByAbility() {
        return pokemonByAbility;
    }


    public List<String> getAbilities(String ability) {
        List<String> tmpAbility = new ArrayList<>();



        return tmpAbility;
    }

    public class PokemonSmall {
        public PokemonSmall(String num, String name) {
            this.num = num;
            this.name = name;
        }
        public String num;
        public String name;
    }
}
