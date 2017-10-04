package com.skazerk.hackdex.AttackDexList.List

import android.os.Bundle
import android.support.v4.app.ListFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.skazerk.hackdex.Main
import com.skazerk.hackdex.R
import com.skazerk.hackdex.Utils.Global.GlobalClass

/**
 * Created by Skaze on 10/1/17.
 */
class AttackDexTMListFragment : ListFragment() {
    private lateinit var global: GlobalClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        global = activity.applicationContext as GlobalClass
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        global = context.applicationContext as GlobalClass

        listAdapter = AttackDexListAdapter(global.tms, 1)

        return inflater!!.inflate(R.layout.dex_fragment, container, false)
    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        var move = listAdapter.getItem(position) as String

        val main = activity as Main
        main.showDialog(move, "move")
    }
}