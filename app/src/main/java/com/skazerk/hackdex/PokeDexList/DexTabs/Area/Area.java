package com.skazerk.hackdex.PokeDexList.DexTabs.Area;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Skaze on 4/11/17.
 */

public class Area{
    public ArrayList<AreaInfo> walking;
    public ArrayList<AreaInfo> surfing;
    public ArrayList<AreaInfo> fishing;
    public ArrayList<AreaInfo> event;

    public ArrayList<String> getAreaInfo(String method, int index) {
        switch(method) {
            case "walking":
                return walking.get(index).getInfo();
            case "surfing":
                return surfing.get(index).getInfo();
            case "fishing":
                return fishing.get(index).getInfo();
            case "event":
                return event.get(index).getInfo();
        }

        return null;
    }

    public Area() {
        walking = new ArrayList<>();
        surfing = new ArrayList<>();
        fishing = new ArrayList<>();
        event = new ArrayList<>();
    }

    private class AreaInfo{
        public String percent;
        public String area;

        public AreaInfo(String percent, String area){
            this.percent = percent;
            this.area = area;
        }

        public ArrayList<String> getInfo() {
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add(percent);
            tmp.add(area);

            return tmp;
        }
    }

    public void addArea(String method, String area, String percent){
        Log.d("Pokemon", "addArea");

        AreaInfo tmp = new AreaInfo(percent, area);

        switch(method){
            case "walking":
                Log.d("Pokemon", "walking");
                walking.add(tmp);
                break;
            case "fishing":
                Log.d("Pokemon", "fishing");
                fishing.add(tmp);
                break;
            case "surfing":
                Log.d("Pokemon", "surfing");
                surfing.add(tmp);
                break;
            case "event":
                Log.d("Pokemon", "event");
                event.add(tmp);
                break;
            default:
                break;
        }
    }
}
