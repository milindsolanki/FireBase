package com.example.firebase.tabApiCall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebase.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_api_call.*

class TabApiCallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_api_call)
        intiView()
    }

    private fun intiView() {
        tabs.addTab(tabs.newTab().setText("One"))
        tabs.addTab(tabs.newTab().setText("Second"))
        tabs.addTab(tabs.newTab().setText("Third"))
        val madapter = TabAdapter(this, supportFragmentManager, tabs.tabCount)
        view_pager.adapter = madapter
        view_pager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager!!.currentItem = tab!!.position
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

        })
    }
}