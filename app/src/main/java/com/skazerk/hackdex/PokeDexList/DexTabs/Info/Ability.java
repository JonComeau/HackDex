package com.skazerk.hackdex.PokeDexList.DexTabs.Info;

/**
 * Created by Skaze on 1/8/17.
 */

public class Ability {
    private String ability;
    private String text;
    private String effect;

    public Ability(String ability, String text, String effect) {
        this.ability = ability;
        this.text = text;
        this.effect = effect;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEffect() { return effect; }

    public void setEffect(String effect){
        this.effect = effect;
    }
}
