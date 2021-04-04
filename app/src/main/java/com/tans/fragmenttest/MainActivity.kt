package com.tans.fragmenttest

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tans.fragmenttest.fragments.*
import com.tans.fragmenttest.viewpager2.FragmentStateAdapter

class MainActivity : BaseActivity(activityName = "MainActivity") {
    private val fragment1 = Fragment1()

    private val fragment2 = Fragment2()

    private val fragment3 = Fragment3()

    private val fragment4 = Fragment4()

    private val fragment5 = Fragment5()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val adapter = ViewPagerFragmentAdapter(supportFragmentManager, listOf("Fragment1" to fragment1, "Fragment2" to fragment2, "Fragment3" to fragment3, "Fragment4" to fragment4, "Fragment5" to fragment5))
//        val viewPager = findViewById<ViewPager>(R.id.fragment_container)
//        viewPager.adapter = adapter
        val viewPagerTabLayout = findViewById<TabLayout>(R.id.view_pager_tab)
//        viewPagerTabLayout.setupWithViewPager(viewPager)
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager2)
        val fragments = listOf<Fragment>(fragment1, fragment2, fragment3, fragment4, fragment5)
        val titles = listOf<String>("Fragment1", "Fragment2", "Fragment3", "Fragment4", "Fragment5")
        viewPager2.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = fragments.size
            override fun createFragment(position: Int): Fragment = fragments[position]
        }

        TabLayoutMediator(viewPagerTabLayout, viewPager2) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }
}
