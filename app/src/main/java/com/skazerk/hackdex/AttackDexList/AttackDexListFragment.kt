package com.skazerk.hackdex.AttackDexList

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.ListFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter

import com.skazerk.hackdex.DexList.DexListFragment
import com.skazerk.hackdex.GlobalClass
import com.skazerk.hackdex.R

/**
 * Created by jcomeau on 9/12/2017.
 */

class AttackDexListFragment : ListFragment() {
    private var global: GlobalClass? = null
    private var mAdapter: ArrayAdapter<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        global = activity.applicationContext as GlobalClass
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        global = context.applicationContext as GlobalClass

        val index = 1
        mAdapter = ArrayAdapter(activity, R.layout.simple_list_item_layout, global!!.moves.toTypedArray())

        listAdapter = mAdapter

        return inflater!!.inflate(R.layout.dex_fragment, container, false)
    }
}
