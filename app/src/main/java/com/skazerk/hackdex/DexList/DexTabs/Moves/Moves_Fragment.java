package com.skazerk.hackdex.DexList.DexTabs.Moves;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skazerk.hackdex.DexList.DexTabs.Utils.Pokemon;
import com.skazerk.hackdex.GlobalClass;
import com.skazerk.hackdex.R;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Skaze on 11/17/16.
 */

public class Moves_Fragment extends ListFragment {
    private GlobalClass global;
    private MoveAdapter lvl_adapter;
    private ArrayList<Pokemon.Move> lvl_moves;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        Log.d("Moves", "onCreate");

        global = (GlobalClass)getContext().getApplicationContext();

        Log.d("Moves", "Created");

        Pokemon poke = global.getPoke();

        Log.d("Moves", "Poke init");

        lvl_adapter = new MoveAdapter();

        Log.d("Moves", "Adapter init");
        lvl_moves = poke.getLvlMoves();

        Log.d("Move", "Moves count: " + lvl_moves.size());

        for (int i = 0; i < lvl_moves.size(); i++){
            Log.d("Move_List", lvl_moves.get(i).move);
            lvl_adapter.addItem(lvl_moves.get(i));
        }

        setListAdapter(lvl_adapter);

        return inflater.inflate(R.layout.moves, container, false);
    }

    public void onDestroy(){
        super.onDestroy();
        try {
            trimCache(getContext());
            Log.d("Move_Frag", "deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void trimCache(Context context){
        try {
            File dir = context.getCacheDir();
            if(dir != null && dir.isDirectory())
                deleteDir(dir);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success)
                    return false;
            }
        }

        return dir.delete();
    }


}
