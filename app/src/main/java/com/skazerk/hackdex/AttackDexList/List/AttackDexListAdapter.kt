package com.skazerk.hackdex.AttackDexList.List

import android.content.Context
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import com.skazerk.hackdex.R

class AttackDexListAdapter(private val list: List<Any>, private val id: Int) : BaseAdapter() {
    private lateinit var inflater: LayoutInflater

    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return list.count()
    }

    override fun getView(position: Int, p1: View?, viewGroup: ViewGroup?): View {
        inflater = viewGroup?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val move: TextView
        var view: View? = p1

        when (id) {
            0 -> {
                if (p1 == null) {
                    view = inflater.inflate(R.layout.simple_list_item_layout, viewGroup, false)
                    move = view.findViewById(R.id.simple_list_item)
                    view.tag = move
                } else {
                    move = view!!.tag as TextView
                }

                val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)

                params.setMargins(convertPXToSP(10f, view!!.context), convertPXToSP(5f, view.context), convertPXToSP(10f, view.context), convertPXToSP(5f, view.context))

                move.gravity = Gravity.CENTER

                move.text = list[position] as String
                move.textSize = convertPXToSP(15f, view.context).toFloat()
                move.layoutParams = params
            }
            1 -> {
                if (p1 == null) {
                    view = inflater.inflate(R.layout.simple_list_item_layout, viewGroup, false)
                    move = view.findViewById(R.id.simple_list_item)
                    view.tag = TMHolder(tm, move)
                } else {
                    move = view!!.tag as TextView
                }

                val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)

                params.setMargins(convertPXToSP(10f, view!!.context), convertPXToSP(5f, view.context), convertPXToSP(10f, view.context), convertPXToSP(5f, view.context))

                move.gravity = Gravity.CENTER

                move.text = list[position] as String
                move.textSize = convertPXToSP(15f, view.context).toFloat()
                move.layoutParams = params
            }
        }

        return view!!
    }

    private fun convertPXToSP(sp: Float, context: Context): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.resources.displayMetrics).toInt()
    }

    private class TMHolder(var tm: View, var text: View) {  }
}