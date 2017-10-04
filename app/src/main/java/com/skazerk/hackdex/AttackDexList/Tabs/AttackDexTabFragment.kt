package com.skazerk.hackdex.AttackDexList.Tabs

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.skazerk.hackdex.AttackDexList.List.AttackDexListFragment
import com.skazerk.hackdex.AttackDexList.List.AttackDexTMListFragment
import com.skazerk.hackdex.R

/**
 * Created by Skaze on 10/1/17.
 */
class AttackDexTabFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val result = inflater!!.inflate(R.layout.dex_tabs_fragment, container, false)
        val pager = result.findViewById<ViewPager>(R.id.dex_tabs)

        pager.adapter = AttackDexPagerAdapter(childFragmentManager, listOf(AttackDexListFragment(), AttackDexTMListFragment()) as List<Fragment>)

        return result
    }
}
