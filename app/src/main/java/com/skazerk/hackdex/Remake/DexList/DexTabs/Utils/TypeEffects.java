package com.skazerk.hackdex.Remake.DexList.DexTabs.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skaze on 9/9/17.
 */
public class TypeEffects {
    public static List<Integer> typeEffects(List<String> types) {

        List<Integer> effects = new ArrayList<>();

        for (int i = 0; i < 17; i++)
            effects.add(i, 4);

        for (String type : types) {
            switch (type) {
                case "normal":
                    //fighting
                    effects.set(6, (effects.get(6) * 2));
                    //ghost
                    effects.set(13, 0);
                    break;
                case "fire":
                    //fire
                    effects.set(1, (effects.get(1) / 2));
                    //water
                    effects.set(2, (effects.get(2) * 2));
                    //grass
                    effects.set(4, (effects.get(4) / 2));
                    //ice
                    effects.set(5, (effects.get(5) / 2));
                    //ground
                    effects.set(8, (effects.get(8) * 2));
                    //bug
                    effects.set(11, (effects.get(11) / 2));
                    //rock
                    effects.set(12, (effects.get(12) * 2));
                    //steel
                    effects.set(16, (effects.get(16) / 2));
                    break;
                case "water":
                    //fire
                    effects.set(1, (effects.get(1) / 2));
                    //water
                    effects.set(2, (effects.get(2) / 2));
                    //electric
                    effects.set(3, (effects.get(3) * 2));
                    //grass
                    effects.set(4, (effects.get(4) * 2));
                    //ice
                    effects.set(5, (effects.get(5) / 2));
                    //steel
                    effects.set(16, (effects.get(16) / 2));
                    break;
                case "electric":
                    //electric
                    effects.set(3, (effects.get(3) / 2));
                    //ground
                    effects.set(8, (effects.get(8) * 2));
                    //flying
                    effects.set(9, (effects.get(9) / 2));
                    //steel
                    effects.set(16, (effects.get(16) / 2));
                    break;
                case "grass":
                    //fire
                    effects.set(1, (effects.get(1) * 2));
                    //water
                    effects.set(2, (effects.get(2) / 2));
                    //electric
                    effects.set(3, (effects.get(3) / 2));
                    //grass
                    effects.set(4, (effects.get(4) / 2));
                    //ice
                    effects.set(5, (effects.get(5) * 2));
                    //poison
                    effects.set(7, (effects.get(7) * 2));
                    //ground
                    effects.set(8, (effects.get(8) / 2));
                    //flying
                    effects.set(9, (effects.get(9) * 2));
                    //bug
                    effects.set(11, (effects.get(11) * 2));
                    break;
                case "ice":
                    //fire
                    effects.set(1, (effects.get(1) * 2));
                    //ice
                    effects.set(5, (effects.get(5) / 2));
                    //fighting
                    effects.set(6, (effects.get(6) * 2));
                    //rock
                    effects.set(12, (effects.get(12) * 2));
                    //steel
                    effects.set(16, (effects.get(16) * 2));
                    break;
                case "fighting":
                    //flying
                    effects.set(9, (effects.get(9) * 2));
                    //psychic
                    effects.set(10, (effects.get(10) * 2));
                    //bug
                    effects.set(11, (effects.get(11) / 2));
                    //rock
                    effects.set(12, (effects.get(12) / 2));
                    //dark
                    effects.set(15, (effects.get(15) / 2));
                    break;
                case "poison":
                    //grass
                    effects.set(4, (effects.get(4) / 2));
                    //fighting
                    effects.set(6, (effects.get(6) / 2));
                    //poison
                    effects.set(7, (effects.get(7) / 2));
                    //ground
                    effects.set(8, (effects.get(8) * 2));
                    //psychic
                    effects.set(10, (effects.get(10) * 2));
                    //bug
                    effects.set(11, (effects.get(11) / 2));
                    break;
                case "ground":
                    //water
                    effects.set(2, (effects.get(2) * 2));
                    //electric
                    effects.set(3, 0);
                    //grass
                    effects.set(4, (effects.get(4) * 2));
                    //ice
                    effects.set(5, (effects.get(5) * 2));
                    //poison
                    effects.set(7, (effects.get(7) / 2));
                    //rock
                    effects.set(12, (effects.get(12) / 2));
                    break;
                case "flying":
                    //electric
                    effects.set(3, (effects.get(3) * 2));
                    //grass
                    effects.set(4, (effects.get(4) / 2));
                    //ice
                    effects.set(5, (effects.get(5) * 2));
                    //fighting
                    effects.set(6, (effects.get(6) / 2));
                    //ground
                    effects.set(8, 0);
                    //bug
                    effects.set(11, (effects.get(11) / 2));
                    //rock
                    effects.set(12, (effects.get(12) * 2));
                    break;
                case "psychic":
                    //fighting
                    effects.set(6, (effects.get(6) / 2));
                    //psychic
                    effects.set(10, (effects.get(10) / 2));
                    //bug
                    effects.set(11, (effects.get(11) * 2));
                    //ghost
                    effects.set(13, (effects.get(13) * 2));
                    //dark
                    effects.set(15, (effects.get(15) * 2));
                    break;
                case "bug":
                    //fire
                    effects.set(1, (effects.get(1) * 2));
                    //grass
                    effects.set(4, (effects.get(4) / 2));
                    //fighting
                    effects.set(6, (effects.get(6) / 2));
                    //ground
                    effects.set(8, (effects.get(8) / 2));
                    //flying
                    effects.set(9, (effects.get(9) * 2));
                    //rock
                    effects.set(12, (effects.get(12) * 2));
                    break;
                case "rock":
                    //normal
                    effects.set(0, (effects.get(0) / 2));
                    //fire
                    effects.set(1, (effects.get(1) / 2));
                    //water
                    effects.set(2, (effects.get(2) * 2));
                    //grass
                    effects.set(4, (effects.get(4) * 2));
                    //fighting
                    effects.set(6, (effects.get(6) * 2));
                    //poison
                    effects.set(7, (effects.get(7) / 2));
                    //ground
                    effects.set(8, (effects.get(8) * 2));
                    //flying
                    effects.set(9, (effects.get(9) / 2));
                    //steel
                    effects.set(16, (effects.get(16) * 2));
                    break;
                case "ghost":
                    //normal
                    effects.set(0, 0);
                    //fighting
                    effects.set(6, 0);
                    //poison
                    effects.set(7, (effects.get(7) / 2));
                    //ground
                    effects.set(8, 0);
                    //bug
                    effects.set(11, (effects.get(11) / 2));
                    //ghost
                    effects.set(13, (effects.get(13) * 2));
                    //dark
                    effects.set(15, (effects.get(15) * 2));
                    break;
                case "dragon":
                    //fire
                    effects.set(1, (effects.get(1) / 2));
                    //water
                    effects.set(2, (effects.get(2) / 2));
                    //electric
                    effects.set(3, (effects.get(3) / 2));
                    //grass
                    effects.set(4, (effects.get(4) / 2));
                    //ice
                    effects.set(5, (effects.get(5) * 2));
                    //dragon
                    effects.set(14, (effects.get(14) * 2));
                    break;
                case "dark":
                    //fighting
                    effects.set(6, (effects.get(6) * 2));
                    //psychic
                    effects.set(10, 0);
                    //bug
                    effects.set(11, (effects.get(11) * 2));
                    //ghost
                    effects.set(12, (effects.get(12) / 2));
                    //dark
                    effects.set(15, (effects.get(15) / 2));
                    break;
                case "steel":
                    //normal
                    effects.set(0, (effects.get(0) / 2));
                    //fire
                    effects.set(1, (effects.get(1) * 2));
                    //grass
                    effects.set(4, (effects.get(4) / 2));
                    //ice
                    effects.set(5, (effects.get(5) / 2));
                    //fighting
                    effects.set(6, (effects.get(6) * 2));
                    //poison
                    effects.set(7, 0);
                    //ground
                    effects.set(8, (effects.get(8) * 2));
                    //flying
                    effects.set(9, (effects.get(9) / 2));
                    //psychic
                    effects.set(10, (effects.get(10) / 2));
                    //bug
                    effects.set(11, (effects.get(11) / 2));
                    //rock
                    effects.set(12, (effects.get(12) / 2));
                    //ghost
                    effects.set(13, (effects.get(13) / 2));
                    //dragon
                    effects.set(14, (effects.get(14) / 2));
                    //dark
                    effects.set(15, (effects.get(15) / 2));
                    //steel
                    effects.set(16, (effects.get(16) / 2));
                    break;
            }
        }

        return effects;
    }
}
