package com.skazerk.hackdex.Utils.Dialog

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import com.skazerk.hackdex.R
import com.skazerk.hackdex.Utils.Global.GlobalClass
import com.skazerk.hackdex.Utils.Global.PokemonSmall

/**
 * Created by Skaze on 9/19/17.
 */
class CustomDialog : DialogFragment() {
    lateinit var global: GlobalClass
    private lateinit var list: MutableList<PokemonSmall>

    companion object {
        @JvmStatic
        fun newInstance(listTitle: String, listType: String): CustomDialog {
            val infoDialog = CustomDialog()
            val bundle = Bundle()
            bundle.putString("ListType", listType)
            bundle.putString("ListTitle", listTitle)
            infoDialog.arguments = bundle

            return infoDialog
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.global = context.applicationContext as GlobalClass
        this.list = loadList(arguments["ListTitle"] as String, arguments["ListType"] as String)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): AlertDialog {
        val builder = AlertDialog.Builder(activity)
        val contentView = View.inflate(context, R.layout.dialog_fragment, null)
        builder.setView(contentView)
        loadIntoList(contentView)
        return builder.create()
    }

    fun loadIntoList(view: View) {
        val listView: ListView = view.findViewById<ListView>(R.id.dialog_list)
        listView.adapter = CustomDialogAdapter(list, activity)

        val title = view.findViewById<TextView>(R.id.dialog_title)
        title.text = arguments["ListTitle"] as String

        Log.v("CustomDialog", arguments["ListTitle"] as String)

        val parent = view as LinearLayout
        val effect = view.findViewById<TextView>(R.id.dialog_effect)
        val text = view.findViewById<TextView>(R.id.dialog_text)

        when (arguments["ListType"]) {
            "ability" -> {
                val info = global.getAbilityInfoAndEffect(arguments["ListTitle"] as String)

                effect.text = info[1]
                text.text = info[0]
            }
            "move" -> {
                effect.visibility = View.GONE
                text.visibility = View.GONE
            }
        }
    }

    fun loadList(listTitle: String, listType: String): MutableList<PokemonSmall> {
        val map: MutableMap<String, MutableList<PokemonSmall>>

        when (listType) {
            "ability" -> map = global.pokemonByAbility
            "move" -> map = global.pokemonByMove
            else -> map = global.pokemonByAbility
        }

        return map.getOrDefault(listTitle, mutableListOf())
    }
}