package com.skazerk.hackdex.PokeDexList.DexTabs.Info

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialogFragment
import android.support.design.widget.CoordinatorLayout
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import com.skazerk.hackdex.PokeDexList.DexTabs.Utils.Global.Abilities
import com.skazerk.hackdex.PokeDexList.DexTabs.Utils.Global.GlobalClass
import com.skazerk.hackdex.R

class BottomSheetFragment : BottomSheetDialogFragment() {
    lateinit var global: GlobalClass

    private val mBottomSheetBehaviorCallback = object : BottomSheetBehavior.BottomSheetCallback() {
        override fun onStateChanged(bottomSheet: View, newState: Int) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                dismiss()
            }
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {}
    }

    companion object {
        @JvmStatic
        fun newInstance(listTitle: String, listType: String): BottomSheetFragment {
            val bottomSheetFragment = BottomSheetFragment()
            val bundle = Bundle()
            bundle.putString("ListType", listType)
            bundle.putString("ListTitle", listTitle)
            bottomSheetFragment.arguments = bundle

            return bottomSheetFragment
        }
    }

    override fun setupDialog(dialog: Dialog?, style: Int) {
        super.setupDialog(dialog, style)
        val contentView = View.inflate(this.context, R.layout.bottom_sheet, null)
        global = this.context.applicationContext as GlobalClass
        val title = contentView.findViewById<TextView>(R.id.bottom_ability)
        val layout = contentView.findViewById<LinearLayout>(R.id.bottom_layout)
        val scale = context.resources.displayMetrics.density

        title.text = arguments.getString("ListTitle")

        val listTitle = arguments["ListTitle"] as String
        val listType = arguments["ListType"] as String

        val list: MutableList<Abilities.PokemonSmall> = loadList(listTitle, listType)

        for (item in list) {
            Log.d("Bottom Sheet", item.num + ", " + item.name)
            val linearLayout = LinearLayout(this.context)
            val num = TextView(this.context)
            val name = TextView(this.context)

            num.text = item.num
            name.text = item.name

            val numLayoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            val nameLayoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            name.gravity = Gravity.CENTER
            num.gravity = Gravity.CENTER

            name.textSize = (35 * scale + 0.5f)

            nameLayoutParams.width = 0
            numLayoutParams.width = 0

            nameLayoutParams.weight = 0.8f
            numLayoutParams.weight = 0.2f

            num.setBackgroundColor(Color.BLUE)

            num.layoutParams = numLayoutParams
            name.layoutParams = nameLayoutParams

            linearLayout.addView(num)
            linearLayout.addView(name)

            val linearLayoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)

            linearLayout.layoutParams = linearLayoutParams
            linearLayout.orientation = LinearLayout.HORIZONTAL

            layout.addView(linearLayout)
        }

        val infoList = global.getAbilityInfoAndEffect(arguments["ListTitle"] as String)

        val abilityText = contentView.findViewById<TextView>(R.id.bottom_text)
        val abilityEffect = contentView.findViewById<TextView>(R.id.bottom_effect)

        abilityText.text = infoList[0]
        abilityEffect.text = infoList[1]

        dialog?.setContentView(contentView)

        val params = (contentView.parent as View).layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior

        if (behavior != null && behavior is BottomSheetBehavior<*>) {
            behavior.setBottomSheetCallback(mBottomSheetBehaviorCallback)
        }
    }

    fun loadList(listTitle: String, listType: String): MutableList<Abilities.PokemonSmall> {
        val map: MutableMap<String, MutableList<Abilities.PokemonSmall>>

        when (listType) {
            "ability" -> map = global.pokemonByAbility
            else -> map = global.pokemonByAbility
        }

        return map.getOrDefault(listTitle, mutableListOf())
    }
}
