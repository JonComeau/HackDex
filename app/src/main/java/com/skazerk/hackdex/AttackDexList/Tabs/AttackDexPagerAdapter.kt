package com.skazerk.hackdex.AttackDexList.Tabs

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class AttackDexPagerAdapter(val manager: FragmentManager, val list: List<Fragment>) : FragmentPagerAdapter(manager) {
    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getCount(): Int {
        return list.count()
    }

    override fun getPageTitle(position: Int): CharSequence {
        when (position) {
            0 -> return "All"
            1 -> return "TM's"
            else -> return ""
        }
    }
}