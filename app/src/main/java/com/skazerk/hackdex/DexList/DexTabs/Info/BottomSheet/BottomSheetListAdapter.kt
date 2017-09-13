package com.skazerk.hackdex.DexList.DexTabs.Info.BottomSheet

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.skazerk.hackdex.GlobalClass
import com.skazerk.hackdex.R
import java.util.*

/**
 * Created by jcomeau on 9/13/2017.
 */

class BottomSheetListAdapter(context: Context, ability: String) : BaseAdapter() {
    private val mInflator: LayoutInflater = LayoutInflater.from(context)
    private val global: GlobalClass = context.applicationContext as GlobalClass

    internal val list: List<Objects> = ArrayList()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View?
        if (position < 2) {
            val vh: ListRowHolderPlain
            if (convertView == null) {
                view = this.mInflator.inflate(R.layout.simple_list_item_layout, parent, false)
                vh = ListRowHolderPlain(view)
                view.tag = vh
            } else {
                view = convertView
                vh = view.tag as ListRowHolderPlain
            }

            vh.text.text = list[position] as String
            return view
        } else if (position == 2) {
            val vh: ListRowHolderPlain
            if (convertView == null) {
                view = this.mInflator.inflate(R.layout.simple_list_item_layout, parent, false)
                vh = ListRowHolderPlain(view)
                view.tag = vh
            } else {
                view = convertView
                vh = view.tag as ListRowHolderPlain
            }

            vh.text.text = list[position] as String

            val params: ViewGroup.LayoutParams = vh.text.layoutParams
            params.height = 1

            vh.text.layoutParams = params
            vh.text.setBackgroundColor(Color.BLACK)

            return view
        } else {
            val vh: ListRowHolderPokemon
            if (convertView == null) {
                view = this.mInflator.inflate(R.layout.dex_list_item, parent, false)
                vh = ListRowHolderPokemon(view)
                view.tag = vh
            } else {
                view = convertView
                vh = view.tag as ListRowHolderPokemon
            }

            val pokemon = list[position] as GlobalClass.PokemonSmall

            vh.name.text = pokemon.name
            vh.num.text = pokemon.num
            return view
        }

    }

    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

    private class ListRowHolderPlain(row: View?) {
        val text: TextView = R.id.simple_list_item as TextView

    }

    private class ListRowHolderPokemon(row: View?) {
        val num: TextView = R.id.dex_item_num as TextView
        val name: TextView = R.id.dex_item_name as TextView
    }

}