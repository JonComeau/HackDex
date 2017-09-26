package com.skazerk.hackdex.Utils;

import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Skaze on 9/23/17.
 */

public enum Activity {
    Pokedex(0),
    Attackdex(1),
    Locationdex(2);

    private final int num;
    private static Map<Integer, Activity> map = new HashMap<Integer, Activity>();

    Activity(int num) {
        this.num = num;
    }

    static {
        for (Activity act : Activity.values()) {
            map.put(act.num, act);
        }
    }

    @Contract(pure = true)
    public int getValue() {
        return num;
    }

    public static Activity valueOf(int type) {
        return map.get(type);
    }
}
