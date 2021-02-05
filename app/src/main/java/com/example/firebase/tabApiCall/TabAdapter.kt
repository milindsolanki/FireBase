package com.example.firebase.tabApiCall

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.RecyclerView

class TabAdapter(context: Context, fragment: FragmentManager, val tabCount: Int) :
    FragmentPagerAdapter(fragment) {
    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                DataOneFragment()
            }
            1 -> {
                DataSecondFragment()
            }
            2 -> {
                DataThirdFragment()
            }
            else -> return getItem(position)
        }
    }
}