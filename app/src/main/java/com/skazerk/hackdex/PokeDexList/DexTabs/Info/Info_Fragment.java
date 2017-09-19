package com.skazerk.hackdex.PokeDexList.DexTabs.Info;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skazerk.hackdex.Main;
import com.skazerk.hackdex.PokeDexList.DexTabs.Utils.Global.GlobalClass;
import com.skazerk.hackdex.R;

import static com.skazerk.hackdex.R.id.poke_name;
import static com.skazerk.hackdex.R.id.poke_num;
import static com.skazerk.hackdex.R.id.type1;
import static com.skazerk.hackdex.R.id.type2;

/**
 * Created by Skaze on 11/17/16.
 */

public class Info_Fragment extends Fragment{
    private GlobalClass global;
    public Resources res;

    private NameHolder nameHolder = new NameHolder();
    private InfoHolder infoHolder = new InfoHolder();

    public Info_Fragment(){
        //stuff
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.info_fragment, container, false);
        global = (GlobalClass)getContext().getApplicationContext();

        global.setInfoLayout(new InfoLayout());
        global.setNameLayout(new NameLayout());

        try {

            //Setting info
            infoHolder.entry = view.findViewById(R.id.entry);

            infoHolder.ability1 = view.findViewById(R.id.abil1);

            infoHolder.ability1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Main) getActivity()).onClick((TextView) view, "ability");
                }
            });

            if(global.getInfoLayout().getAbilties().size() == 2)
                infoHolder.ability2 = view.findViewById(R.id.abil2);

            if(global.getInfoLayout().getAbilties().size() == 3){
                infoHolder.ability2 = view.findViewById(R.id.abil2);
                infoHolder.ability3 = view.findViewById(R.id.abil3);
            }

            infoHolder.stats = view.findViewById(R.id.stats);

            //setting Text

            String first = "Entry\n";
            String second = global.getInfoLayout().getEntry();
            String total = first + second;
            Spannable entry = new SpannableString(total);
            entry.setSpan(new StyleSpan(Typeface.BOLD),
                    total.indexOf(first),
                    total.indexOf(first) + first.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            infoHolder.entry.setText(entry);

            //setting abilitites

            first = "Abilities\n";

            total = first;

            String abil1 = global.getInfoLayout().getAbilties().get(0).getAbility();

            abil1 += "\n    -" + global.getInfoLayout().getAbilties().get(0).getText();

            String abil2;
            String abil3;

            total += abil1;

            Spannable ability1 = new SpannableString(total);

            ability1.setSpan(new StyleSpan(Typeface.BOLD),
                    total.indexOf(first),
                    total.indexOf(first) + first.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            infoHolder.ability1.setText(ability1);

            if(global.getInfoLayout().getAbilties().size() == 2) {
                abil2 = global.getInfoLayout().getAbilties().get(1).getAbility();
                abil2 += "\n    -" + global.getInfoLayout().getAbilties().get(1).getText();
                infoHolder.ability2.setText(abil2);
            }

            if(global.getInfoLayout().getAbilties().size() == 3){
                abil2 = global.getInfoLayout().getAbilties().get(1).getAbility();
                abil2 += "\n    -" + global.getInfoLayout().getAbilties().get(1).getText();
                abil3 = global.getInfoLayout().getAbilties().get(2).getAbility();
                abil3 += "\n    -" + global.getInfoLayout().getAbilties().get(2).getText();
                infoHolder.ability2.setText(abil2);
                infoHolder.ability3.setText(abil3);
            }

            //setting num
            nameHolder.num = view.findViewById(poke_num);
            nameHolder.name = view.findViewById(poke_name);
            nameHolder.type1 = view.findViewById(type1);
            nameHolder.type2 = view.findViewById(type2);

            nameHolder.num.setText(global.getNameLayout().getNum());
            nameHolder.name.setText(global.getNameLayout().getName());
            nameHolder.type1.setText(global.getNameLayout().getTypes().get(0));


            nameHolder.type1.setBackgroundColor(getColor(global.getNameLayout().getTypes().get(0)));

            if(global.getPoke().getTypeCount() == 2) {
                nameHolder.type2.setText(global.getNameLayout().getTypes().get(1));
                nameHolder.type1.setTextSize(getResources().getDimension(R.dimen.two_types));
                nameHolder.type2.setTextSize(getResources().getDimension(R.dimen.two_types));

                nameHolder.type2.setBackgroundColor(getColor(global.getPoke().getTypes().get(1)));
            }
            else {
                nameHolder.type2.setText("");
                nameHolder.type1.setTextSize(getResources().getDimension(R.dimen.one_type));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    public void onPause(){
        super.onPause();
        this.onDestroy();
    }

    public void onResume(){
        super.onResume();
    }

    public void onStop(){
        super.onStop();
    }

    public void onDestroy(){
        super.onDestroy();
    }

    private class NameHolder{
        public TextView name;
        public TextView num;
        public TextView type1;
        public TextView type2;
    }

    private class InfoHolder{
        public TextView entry;
        public TextView ability1;
        public TextView ability2;
        public TextView ability3;
        public TextView stats;
    }

    private int getColor(String type){
        switch(type){
            case "normal":
                return ContextCompat.getColor(getActivity().getApplicationContext(), R.color.normal);
            case "fire":
                return ContextCompat.getColor(getActivity().getApplicationContext(), R.color.fire);
            case "fighting":
                return ContextCompat.getColor(getActivity().getApplicationContext(), R.color.fighting);
            case "water":
                return ContextCompat.getColor(getActivity().getApplicationContext(), R.color.water);
            case "flying":
                return ContextCompat.getColor(getActivity().getApplicationContext(), R.color.flying);
            case "grass":
                return ContextCompat.getColor(getActivity().getApplicationContext(), R.color.grass);
            case "poison":
                return ContextCompat.getColor(getActivity().getApplicationContext(), R.color.poison);
            case "electric":
                return ContextCompat.getColor(getActivity().getApplicationContext(), R.color.electric);
            case "ground":
                return ContextCompat.getColor(getActivity().getApplicationContext(), R.color.ground);
            case "psychic":
                return ContextCompat.getColor(getActivity().getApplicationContext(), R.color.psychic);
            case "rock":
                return ContextCompat.getColor(getActivity().getApplicationContext(), R.color.rock);
            case "ice":
                return ContextCompat.getColor(getActivity().getApplicationContext(), R.color.ice);
            case "bug":
                return ContextCompat.getColor(getActivity().getApplicationContext(), R.color.bug);
            case "dragon":
                return ContextCompat.getColor(getActivity().getApplicationContext(), R.color.dragon);
            case "ghost":
                return ContextCompat.getColor(getActivity().getApplicationContext(), R.color.ghost);
            case "dark":
                return ContextCompat.getColor(getActivity().getApplicationContext(), R.color.dark);
            case "steel":
                return ContextCompat.getColor(getActivity().getApplicationContext(), R.color.steel);
        }
        return 0;
    }
}

