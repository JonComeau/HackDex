package com.skazerk.hackdex.DexList.DexTabs.Info.BottomSheet

import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialogFragment
import android.support.design.widget.CoordinatorLayout
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import com.skazerk.hackdex.R
import java.util.HashMap

class BottomSheetFragment : BottomSheetDialogFragment() {
    private val key: String = "BottomSheetFragment"

    private val mBottomSheetBehaviorCallback = object : BottomSheetBehavior.BottomSheetCallback() {
        override fun onStateChanged(bottomSheet: View, newState: Int) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                dismiss()
            }
        }
        override fun onSlide(bottomSheet: View, slideOffset: Float) {}
    }

    companion object {
        @JvmStatic fun newInstance(ability: String): BottomSheetFragment {
            val bottomSheetFragment = BottomSheetFragment()
            val bundle = Bundle()
            bundle.putString("BottomSheetFragment", ability)
            bottomSheetFragment.arguments = bundle

            return bottomSheetFragment
        }
    }

    override fun setupDialog(dialog: Dialog?, style: Int) {
        super.setupDialog(dialog, style)
        val contentView = View.inflate(this.context, R.layout.bottom_sheet_info, null)
        val listView = contentView.findViewById<ListView>(R.id.ability_list)
        val ability = contentView.findViewById<TextView>(R.id.bottom_ability)

        ability.text = arguments.getString(this.key)

        listView.adapter = BottomSheetListAdapter(context, arguments.getString(this.key))

        dialog?.setContentView(contentView)

        val params = (contentView.parent as View).layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior

        if (behavior != null && behavior is BottomSheetBehavior<*>) {
            behavior.setBottomSheetCallback(mBottomSheetBehaviorCallback)
        }
    }
}
