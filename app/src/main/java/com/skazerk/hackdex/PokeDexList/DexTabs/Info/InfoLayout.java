package com.skazerk.hackdex.PokeDexList.DexTabs.Info;

import com.skazerk.hackdex.PokeDexList.DexTabs.Utils.Pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skaze on 12/1/16.
 */
public class InfoLayout{
    private String entry = "";
    private String capture_rate = "";
    private ArrayList<Pokemon.Stat> stats = new ArrayList<>();
    private ArrayList<Ability> abilities = new ArrayList<>();
    private List<Effect> effects = new ArrayList<>();

    public List getEffects(){
        return effects;
    }

    public void setStats(ArrayList<Pokemon.Stat> stat_list){
        stats = stat_list;
    }

    public ArrayList getStats(){
        return stats;
    }

    public void setEntry(String text){
        entry = text;
    }

    public String getEntry(){
        return entry;
    }

    public void setAbility(ArrayList<Ability> abil){
        abilities = abil;
    }

    public ArrayList<Ability> getAbilties(){
        return abilities;
    }

    public void setEffects(List<Integer> effect_list){
        for(int i = 0; i < effect_list.size(); i++){
            Effect effect = new Effect();
            switch(i){
                case 0:
                    effect.setType("Normal");
                    break;
                case 1:
                    effect.setType("Fire");
                    break;
                case 2:
                    effect.setType("Water");
                    break;
                case 3:
                    effect.setType("Electric");
                    break;
                case 4:
                    effect.setType("Grass");
                    break;
                case 5:
                    effect.setType("Ice");
                    break;
                case 6:
                    effect.setType("Fighting");
                    break;
                case 7:
                    effect.setType("Poison");
                    break;
                case 8:
                    effect.setType("Ground");
                    break;
                case 9:
                    effect.setType("Flying");
                    break;
                case 10:
                    effect.setType("Psychic");
                    break;
                case 11:
                    effect.setType("Bug");
                    break;
                case 12:
                    effect.setType("Rock");
                    break;
                case 13:
                    effect.setType("Ghost");
                    break;
                case 14:
                    effect.setType("Dragon");
                    break;
                case 15:
                    effect.setType("Dark");
                    break;
                case 16:
                    effect.setType("Steel");
                    break;
            }

            effect.setEffect(effect_list.get(i));
        }
    }
}
