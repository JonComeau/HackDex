package com.skazerk.hackdex.Remake.DexList.DexTabs.Info;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skaze on 12/1/16.
 */
public class NameLayout{
    private String name = "";
    private String num = "";
    private List<String> types = new ArrayList<>();

    public void setName(String name){
        this.name = name;
    }

    public void setNum(String num){
        this.num = num;
    }

    public void setType(List<String> types){
        this.types = types;
    }

    public String getName(){
        return name;
    }

    public String getNum(){
        return num;
    }

    public List<String> getTypes(){
        return types;
    }
}
