package com.skazerk.hackdex.DexList.DexTabs.Utils;

import java.util.ArrayList;

/**
 * Created by Skaze on 12/1/16.
 */

public class GetWeakness {

    //these are referencing the attack advantage
    // on the defender
    private ArrayList<String> superStrong = new ArrayList<String>();
    private ArrayList<String> strong = new ArrayList<String>();
    private ArrayList<String> normal = new ArrayList<String>();
    private ArrayList<String> weak = new ArrayList<String>();
    private ArrayList<String> superWeak = new ArrayList<String>();
    private ArrayList<String> notEffective = new ArrayList<String>();

    private String type1 = "";
    private String type2 = "";

    public ArrayList<ArrayList<String>> getWeakness(){
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

        list.add(superStrong);
        list.add(strong);
        list.add(normal);
        list.add(weak);
        list.add(superWeak);
        list.add(notEffective);

        return list;
    }

    private String[] type_list = {
            "normal", //0
            "fire", //1
            "fighting", //2
            "water", //3
            "flying", //4
            "grass", //5
            "poison", //6
            "electric", //7
            "ground", //8
            "psychic", //9
            "rock", //10
            "ice", //11
            "bug", //12
            "dragon", //13
            "ghost", //14
            "dark", //15
            "steel" //16
    };

    public GetWeakness(String type1, String type2){
        this.type1 = type1;
        this.type2 = type2;
    }

    public GetWeakness(String type1){
        this.type1 = type1;
    }

    //using switches
    private void GenerateWeakness(){
        switch(type1) {
            case "normal":
                if (type2.equals("")) {
                    for (int i = 0; i < type_list.length; i++) {
                        if (i == 2)
                            strong.add(type_list[i]);
                        else if (i == 14)
                            notEffective.add(type_list[i]);
                        else
                            normal.add(type_list[i]);
                    }
                } else {
                    switch(type2){
                        case "fire":
                            for (int i = 0; i < type_list.length; i++) {
                                if (i == 2 || i == 3 || i == 8 || i == 10)
                                    strong.add(type_list[i]);
                                else if (i == 1 || i == 5 || i == 11 || i == 12 ||
                                        i == 16)
                                    weak.add(type_list[i]);
                                else if (i == 14)
                                    notEffective.add(type_list[i]);
                                else
                                    normal.add(type_list[i]);
                            }
                            break;
                        case "fighting":
                            for (int i = 0; i < type_list.length; i++) {
                                if (i == 2)
                                    strong.add(type_list[i]);
                                else if (i == 14)
                                    notEffective.add(type_list[i]);
                                else
                                    normal.add(type_list[i]);
                            }
                            break;
                        case "water":
                            for (int i = 0; i < type_list.length; i++) {
                                if (i == 2)
                                    strong.add(type_list[i]);
                                else if (i == 14)
                                    notEffective.add(type_list[i]);
                                else
                                    normal.add(type_list[i]);
                            }
                            break;
                        case "flying":
                            for (int i = 0; i < type_list.length; i++) {
                                if (i == 2)
                                    strong.add(type_list[i]);
                                else if (i == 14)
                                    notEffective.add(type_list[i]);
                                else
                                    normal.add(type_list[i]);
                            }
                            break;
                        case "grass":
                            for (int i = 0; i < type_list.length; i++) {
                                if (i == 2)
                                    strong.add(type_list[i]);
                                else if (i == 14)
                                    notEffective.add(type_list[i]);
                                else
                                    normal.add(type_list[i]);
                            }
                            break;
                        case "poison":
                            for (int i = 0; i < type_list.length; i++) {
                                if (i == 2)
                                    strong.add(type_list[i]);
                                else if (i == 14)
                                    notEffective.add(type_list[i]);
                                else
                                    normal.add(type_list[i]);
                            }
                            break;
                        case "electric":
                            for (int i = 0; i < type_list.length; i++) {
                                if (i == 2)
                                    strong.add(type_list[i]);
                                else if (i == 14)
                                    notEffective.add(type_list[i]);
                                else
                                    normal.add(type_list[i]);
                            }
                            break;
                        case "ground":
                            for (int i = 0; i < type_list.length; i++) {
                                if (i == 2)
                                    strong.add(type_list[i]);
                                else if (i == 14)
                                    notEffective.add(type_list[i]);
                                else
                                    normal.add(type_list[i]);
                            }
                            break;
                        case "psychic":
                            for (int i = 0; i < type_list.length; i++) {
                                if (i == 2)
                                    strong.add(type_list[i]);
                                else if (i == 14)
                                    notEffective.add(type_list[i]);
                                else
                                    normal.add(type_list[i]);
                            }
                            break;
                        case "rock":
                            for (int i = 0; i < type_list.length; i++) {
                                if (i == 2)
                                    strong.add(type_list[i]);
                                else if (i == 14)
                                    notEffective.add(type_list[i]);
                                else
                                    normal.add(type_list[i]);
                            }
                            break;
                        case "ice":
                            for (int i = 0; i < type_list.length; i++) {
                                if (i == 2)
                                    strong.add(type_list[i]);
                                else if (i == 14)
                                    notEffective.add(type_list[i]);
                                else
                                    normal.add(type_list[i]);
                            }
                            break;
                        case "bug":
                            for (int i = 0; i < type_list.length; i++) {
                                if (i == 2)
                                    strong.add(type_list[i]);
                                else if (i == 14)
                                    notEffective.add(type_list[i]);
                                else
                                    normal.add(type_list[i]);
                            }
                            break;
                        case "dragon":
                            for (int i = 0; i < type_list.length; i++) {
                                if (i == 2)
                                    strong.add(type_list[i]);
                                else if (i == 14)
                                    notEffective.add(type_list[i]);
                                else
                                    normal.add(type_list[i]);
                            }
                            break;
                        case "ghost":
                            for (int i = 0; i < type_list.length; i++) {
                                if (i == 2)
                                    strong.add(type_list[i]);
                                else if (i == 14)
                                    notEffective.add(type_list[i]);
                                else
                                    normal.add(type_list[i]);
                            }
                            break;
                        case "dark":
                            for (int i = 0; i < type_list.length; i++) {
                                if (i == 2)
                                    strong.add(type_list[i]);
                                else if (i == 14)
                                    notEffective.add(type_list[i]);
                                else
                                    normal.add(type_list[i]);
                            }
                            break;
                        case "steel":
                            for (int i = 0; i < type_list.length; i++) {
                                if (i == 2)
                                    strong.add(type_list[i]);
                                else if (i == 14)
                                    notEffective.add(type_list[i]);
                                else
                                    normal.add(type_list[i]);
                            }
                            break;
                    }
                }
                break;
            case "fire":
                if (type2.equals("")) {
                    for (int i = 0; i < type_list.length; i++) {
                        if (i == 8 || i == 10 || i == 3)
                            strong.add(type_list[i]);
                        else if (i == 12 || i == 16 || i == 1 ||
                                i == 5 || i == 11)
                            weak.add(type_list[i]);
                        else
                            normal.add(type_list[i]);
                    }
                } else {
                    switch(type2){
                        case "normal":
                            break;
                        case "fire":
                            break;
                        case "fighting":
                            break;
                        case "water":
                            break;
                        case "flying":
                            break;
                        case "grass":
                            break;
                        case "poison":
                            break;
                        case "electric":
                            break;
                        case "ground":
                            break;
                        case "psychic":
                            break;
                        case "rock":
                            break;
                        case "ice":
                            break;
                        case "bug":
                            break;
                        case "dragon":
                            break;
                        case "ghost":
                            break;
                        case "dark":
                            break;
                        case "steel":
                            break;
                    }
                }
                break;
            case "fighting":
                if (type2.equals("")) {
                    for (int i = 0; i < type_list.length; i++) {
                        if (i == 2 || i == 9)
                            strong.add(type_list[i]);
                        else if (i == 10 || i == 12 || i == 15)
                            weak.add(type_list[i]);
                        else
                            normal.add(type_list[i]);
                    }
                } else {
                    switch(type2){
                        case "normal":
                            break;
                        case "fire":
                            break;
                        case "fighting":
                            break;
                        case "water":
                            break;
                        case "flying":
                            break;
                        case "grass":
                            break;
                        case "poison":
                            break;
                        case "electric":
                            break;
                        case "ground":
                            break;
                        case "psychic":
                            break;
                        case "rock":
                            break;
                        case "ice":
                            break;
                        case "bug":
                            break;
                        case "dragon":
                            break;
                        case "ghost":
                            break;
                        case "dark":
                            break;
                        case "steel":
                            break;
                    }
                }
                break;
            case "water":
                if (type2.equals("")) {
                    for (int i = 0; i < type_list.length; i++) {
                        if (i == 5 || i == 7)
                            strong.add(type_list[i]);
                        else if (i == 16 || i == 1 || i == 3 || i == 11)
                            weak.add(type_list[i]);
                        else
                            normal.add(type_list[i]);
                    }
                } else {
                    switch(type2){
                        case "normal":
                            break;
                        case "fire":
                            break;
                        case "fighting":
                            break;
                        case "water":
                            break;
                        case "flying":
                            break;
                        case "grass":
                            break;
                        case "poison":
                            break;
                        case "electric":
                            break;
                        case "ground":
                            break;
                        case "psychic":
                            break;
                        case "rock":
                            break;
                        case "ice":
                            break;
                        case "bug":
                            break;
                        case "dragon":
                            break;
                        case "ghost":
                            break;
                        case "dark":
                            break;
                        case "steel":
                            break;
                    }
                }
                break;
            case "flying":
                if (type2.equals("")) {
                    for (int i = 0; i < type_list.length; i++) {
                        if (i == 10 || i == 7 || i == 11)
                            strong.add(type_list[i]);
                        else if (i == 2 || i == 12 || i == 5)
                            weak.add(type_list[i]);
                        else
                            normal.add(type_list[i]);
                    }
                } else {
                    switch(type2){
                        case "normal":
                            break;
                        case "fire":
                            break;
                        case "fighting":
                            break;
                        case "water":
                            break;
                        case "flying":
                            break;
                        case "grass":
                            break;
                        case "poison":
                            break;
                        case "electric":
                            break;
                        case "ground":
                            break;
                        case "psychic":
                            break;
                        case "rock":
                            break;
                        case "ice":
                            break;
                        case "bug":
                            break;
                        case "dragon":
                            break;
                        case "ghost":
                            break;
                        case "dark":
                            break;
                        case "steel":
                            break;
                    }
                }
                break;
            case "grass":
                if (type2.equals("")) {
                    for (int i = 0; i < type_list.length; i++) {
                        if (i == 12 || i == 1 || i == 4 ||
                                i == 11 || i == 6)
                            strong.add(type_list[i]);
                        else if (i == 7 || i == 5 || i == 8 || i == 3)
                            weak.add(type_list[i]);
                        else
                            normal.add(type_list[i]);
                    }
                } else {
                    switch(type2){
                        case "normal":
                            break;
                        case "fire":
                            break;
                        case "fighting":
                            break;
                        case "water":
                            break;
                        case "flying":
                            break;
                        case "grass":
                            break;
                        case "poison":
                            break;
                        case "electric":
                            break;
                        case "ground":
                            break;
                        case "psychic":
                            break;
                        case "rock":
                            break;
                        case "ice":
                            break;
                        case "bug":
                            break;
                        case "dragon":
                            break;
                        case "ghost":
                            break;
                        case "dark":
                            break;
                        case "steel":
                            break;
                    }
                }
                break;
            case "poison":
                if (type2.equals("")) {
                    for (int i = 0; i < type_list.length; i++) {
                        if (i == 8 || i == 9)
                            strong.add(type_list[i]);
                        else if (i == 2 || i == 6 || i == 12 || i == 5)
                            weak.add(type_list[i]);
                        else
                            normal.add(type_list[i]);
                    }
                } else {
                    switch(type2){
                        case "normal":
                            break;
                        case "fire":
                            break;
                        case "fighting":
                            break;
                        case "water":
                            break;
                        case "flying":
                            break;
                        case "grass":
                            break;
                        case "poison":
                            break;
                        case "electric":
                            break;
                        case "ground":
                            break;
                        case "psychic":
                            break;
                        case "rock":
                            break;
                        case "ice":
                            break;
                        case "bug":
                            break;
                        case "dragon":
                            break;
                        case "ghost":
                            break;
                        case "dark":
                            break;
                        case "steel":
                            break;
                    }
                }
                break;
            case "electric":
                if (type2.equals("")) {
                    for (int i = 0; i < type_list.length; i++) {
                        if (i == 8)
                            strong.add(type_list[i]);
                        else if (i == 7 || i == 4 || i == 16)
                            weak.add(type_list[i]);
                        else
                            normal.add(type_list[i]);
                    }
                } else {
                    switch(type2){
                        case "normal":
                            break;
                        case "fire":
                            break;
                        case "fighting":
                            break;
                        case "water":
                            break;
                        case "flying":
                            break;
                        case "grass":
                            break;
                        case "poison":
                            break;
                        case "electric":
                            break;
                        case "ground":
                            break;
                        case "psychic":
                            break;
                        case "rock":
                            break;
                        case "ice":
                            break;
                        case "bug":
                            break;
                        case "dragon":
                            break;
                        case "ghost":
                            break;
                        case "dark":
                            break;
                        case "steel":
                            break;
                    }
                }
                break;
            case "ground":
                if (type2.equals("")) {
                    for (int i = 0; i < type_list.length; i++) {
                        if (i == 5 || i == 11 || i == 3)
                            strong.add(type_list[i]);
                        else if (i == 6 || i == 8)
                            weak.add(type_list[i]);
                        else
                            normal.add(type_list[i]);
                    }
                } else {
                    switch(type2){
                        case "normal":
                            break;
                        case "fire":
                            break;
                        case "fighting":
                            break;
                        case "water":
                            break;
                        case "flying":
                            break;
                        case "grass":
                            break;
                        case "poison":
                            break;
                        case "electric":
                            break;
                        case "ground":
                            break;
                        case "psychic":
                            break;
                        case "rock":
                            break;
                        case "ice":
                            break;
                        case "bug":
                            break;
                        case "dragon":
                            break;
                        case "ghost":
                            break;
                        case "dark":
                            break;
                        case "steel":
                            break;
                    }
                }
                break;
            case "psychic":
                if (type2.equals("")) {
                    for (int i = 0; i < type_list.length; i++) {
                        if (i == 12 || i == 15 || i == 14)
                            strong.add(type_list[i]);
                        else if (i == 2 || i == 9)
                            weak.add(type_list[i]);
                        else
                            normal.add(type_list[i]);
                    }
                } else {
                    switch(type2){
                        case "normal":
                            break;
                        case "fire":
                            break;
                        case "fighting":
                            break;
                        case "water":
                            break;
                        case "flying":
                            break;
                        case "grass":
                            break;
                        case "poison":
                            break;
                        case "electric":
                            break;
                        case "ground":
                            break;
                        case "psychic":
                            break;
                        case "rock":
                            break;
                        case "ice":
                            break;
                        case "bug":
                            break;
                        case "dragon":
                            break;
                        case "ghost":
                            break;
                        case "dark":
                            break;
                        case "steel":
                            break;
                    }
                }
                break;
            case "rock":
                if (type2.equals("")) {
                    for (int i = 0; i < type_list.length; i++) {
                        if (i == 2 || i == 5 || i == 8 ||
                                i == 16 || i == 3)
                            strong.add(type_list[i]);
                        else if (i == 1 || i == 4 || i == 0 || i == 6)
                            weak.add(type_list[i]);
                        else
                            normal.add(type_list[i]);
                    }
                } else {
                    switch(type2){
                        case "normal":
                            break;
                        case "fire":
                            break;
                        case "fighting":
                            break;
                        case "water":
                            break;
                        case "flying":
                            break;
                        case "grass":
                            break;
                        case "poison":
                            break;
                        case "electric":
                            break;
                        case "ground":
                            break;
                        case "psychic":
                            break;
                        case "rock":
                            break;
                        case "ice":
                            break;
                        case "bug":
                            break;
                        case "dragon":
                            break;
                        case "ghost":
                            break;
                        case "dark":
                            break;
                        case "steel":
                            break;
                    }
                }
                break;
            case "ice":
                if (type2.equals("")) {
                    for (int i = 0; i < type_list.length; i++) {
                        if (i == 2 || i == 1 || i == 10 || i == 16)
                            strong.add(type_list[i]);
                        else if (i == 11)
                            weak.add(type_list[i]);
                        else
                            normal.add(type_list[i]);
                    }
                } else {
                    switch(type2){
                        case "normal":
                            break;
                        case "fire":
                            break;
                        case "fighting":
                            break;
                        case "water":
                            break;
                        case "flying":
                            break;
                        case "grass":
                            break;
                        case "poison":
                            break;
                        case "electric":
                            break;
                        case "ground":
                            break;
                        case "psychic":
                            break;
                        case "rock":
                            break;
                        case "ice":
                            break;
                        case "bug":
                            break;
                        case "dragon":
                            break;
                        case "ghost":
                            break;
                        case "dark":
                            break;
                        case "steel":
                            break;
                    }
                }
                break;
            case "bug":
                if (type2.equals("")) {
                    for (int i = 0; i < type_list.length; i++) {
                        if (i == 1 || i == 4 || i == 10)
                            strong.add(type_list[i]);
                        else if (i == 2 || i == 5 || i == 8)
                            weak.add(type_list[i]);
                        else
                            normal.add(type_list[i]);
                    }
                } else {
                    switch(type2){
                        case "normal":
                            break;
                        case "fire":
                            break;
                        case "fighting":
                            break;
                        case "water":
                            break;
                        case "flying":
                            break;
                        case "grass":
                            break;
                        case "poison":
                            break;
                        case "electric":
                            break;
                        case "ground":
                            break;
                        case "psychic":
                            break;
                        case "rock":
                            break;
                        case "ice":
                            break;
                        case "bug":
                            break;
                        case "dragon":
                            break;
                        case "ghost":
                            break;
                        case "dark":
                            break;
                        case "steel":
                            break;
                    }
                }
                break;
            case "dragon":
                if (type2.equals("")) {
                    for (int i = 0; i < type_list.length; i++) {
                        if (i == 13 || i == 11)
                            strong.add(type_list[i]);
                        else if (i == 7 || i == 1 || i == 5 || i == 3)
                            weak.add(type_list[i]);
                        else
                            normal.add(type_list[i]);
                    }
                } else {
                    switch(type2){
                        case "normal":
                            break;
                        case "fire":
                            break;
                        case "fighting":
                            break;
                        case "water":
                            break;
                        case "flying":
                            break;
                        case "grass":
                            break;
                        case "poison":
                            break;
                        case "electric":
                            break;
                        case "ground":
                            break;
                        case "psychic":
                            break;
                        case "rock":
                            break;
                        case "ice":
                            break;
                        case "bug":
                            break;
                        case "dragon":
                            break;
                        case "ghost":
                            break;
                        case "dark":
                            break;
                        case "steel":
                            break;
                    }
                }
                break;
            case "ghost":
                if (type2.equals("")) {
                    for (int i = 0; i < type_list.length; i++) {
                        if (i == 15 || i == 14)
                            strong.add(type_list[i]);
                        else if (i == 12 || i == 6)
                            weak.add(type_list[i]);
                        else
                            normal.add(type_list[i]);
                    }
                } else {
                    switch(type2){
                        case "normal":
                            break;
                        case "fire":
                            break;
                        case "fighting":
                            break;
                        case "water":
                            break;
                        case "flying":
                            break;
                        case "grass":
                            break;
                        case "poison":
                            break;
                        case "electric":
                            break;
                        case "ground":
                            break;
                        case "psychic":
                            break;
                        case "rock":
                            break;
                        case "ice":
                            break;
                        case "bug":
                            break;
                        case "dragon":
                            break;
                        case "ghost":
                            break;
                        case "dark":
                            break;
                        case "steel":
                            break;
                    }
                }
                break;
            case "dark":
                if (type2.equals("")) {
                    for (int i = 0; i < type_list.length; i++) {
                        if (i == 12 || i == 2)
                            strong.add(type_list[i]);
                        else if (i == 15 || i == 14)
                            weak.add(type_list[i]);
                        else
                            normal.add(type_list[i]);
                    }
                } else {
                    switch(type2){
                        case "normal":
                            break;
                        case "fire":
                            break;
                        case "fighting":
                            break;
                        case "water":
                            break;
                        case "flying":
                            break;
                        case "grass":
                            break;
                        case "poison":
                            break;
                        case "electric":
                            break;
                        case "ground":
                            break;
                        case "psychic":
                            break;
                        case "rock":
                            break;
                        case "ice":
                            break;
                        case "bug":
                            break;
                        case "dragon":
                            break;
                        case "ghost":
                            break;
                        case "dark":
                            break;
                        case "steel":
                            break;
                    }
                }
                break;
            case "steel":
                if (type2.equals("")) {
                    for (int i = 0; i < type_list.length; i++) {
                        if (i == 2 || i == 1 || i == 8)
                            strong.add(type_list[i]);
                        else if(i == 12 || i == 15 || i == 13 ||
                                i == 14 || i == 5 || i == 11 ||
                                i == 0 || i == 9 || i == 10 ||
                                i == 16)
                            weak.add(type_list[i]);
                        else if(i == 6)
                            notEffective.add(type_list[i]);
                        else
                            normal.add(type_list[i]);
                    }
                } else {
                    switch(type2){
                        case "normal":
                            break;
                        case "fire":
                            break;
                        case "fighting":
                            break;
                        case "water":
                            break;
                        case "flying":
                            break;
                        case "grass":
                            break;
                        case "poison":
                            break;
                        case "electric":
                            break;
                        case "ground":
                            break;
                        case "psychic":
                            break;
                        case "rock":
                            break;
                        case "ice":
                            break;
                        case "bug":
                            break;
                        case "dragon":
                            break;
                        case "ghost":
                            break;
                        case "dark":
                            break;
                        case "steel":
                            break;
                    }
                }
                break;
        }
    }

    //using ints
    private void GenerateTypeEffects(){
        ArrayList<Integer> types = new ArrayList<Integer>();

        //0 = not effective
        //1 = super weak
        //2 = weak
        //3 = normal
        //4 = strong
        //5 = super strong
        for (int i = 0; i < type_list.length; i++){
            types.add(3);
        }

        switch(type1){
            case "normal":
                break;
            case "fire":
                break;
            case "fighting":
                break;
            case "water":
                break;
            case "flying":
                break;
            case "grass":
                break;
            case "poison":
                break;
            case "electric":
                break;
            case "ground":
                break;
            case "psychic":
                break;
            case "rock":
                break;
            case "ice":
                break;
            case "bug":
                break;
            case "dragon":
                break;
            case "ghost":
                break;
        }
    }
}
