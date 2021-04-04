package com.tans.fragmenttest

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.PagerAdapter
import com.tans.fragmenttest.fragments.BaseFragment

class ViewPagerFragmentAdapter(
        private val fm: FragmentManager,
        private val fragments: List<Pair<String, BaseFragment>>
        ) : PagerAdapter() {

    private val initHistory: HashMap<BaseFragment, Boolean> = HashMap<BaseFragment, Boolean>()

    init {
        for (f in fragments) { initHistory[f.second] = false }
    }

    private var transaction: FragmentTransaction? = null

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val tag = getFragmentTag(position, container.id)
        val fragment: Fragment? = fm.findFragmentByTag(tag)
        var localTransaction = this.transaction
        if (localTransaction == null) {
            localTransaction = fm.beginTransaction()
            transaction = localTransaction
        }
        return if (fragment == null) {
            localTransaction.add(container.id, fragments[position].second, tag)
            fragments[position].second
        } else {
            localTransaction.show(fragment)
            fragment
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, key: Any) {
        val fragment = key as Fragment
        var localTransaction = this.transaction
        if (localTransaction == null) {
            localTransaction = fm.beginTransaction()
            this.transaction = localTransaction
        }
        localTransaction.hide(fragment)
    }

    override fun setPrimaryItem(container: ViewGroup, position: Int, key: Any) {
        val fragment = key as BaseFragment
        var localTransaction = this.transaction
        if (localTransaction == null) {
            localTransaction = fm.beginTransaction()
            this.transaction = localTransaction
        }
        localTransaction.show(fragment)
        if (initHistory[fragment] != true) {
            fragment.refreshData()
            initHistory[fragment] = true
        }
    }

    override fun finishUpdate(container: ViewGroup) {
        transaction?.commitNowAllowingStateLoss()
        transaction = null
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fragments[position].first
    }

    override fun getCount(): Int = fragments.size

    override fun isViewFromObject(view: View, key: Any): Boolean = (key as? Fragment)?.view == view

    private fun getFragmentTag(position: Int, parentId: Int): String = "ViewPagerFragmentTag_${parentId}_${position}"

}