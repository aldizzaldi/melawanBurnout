package com.example.macapedia.ui.explore

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.capstone.ui.discover.DiscoverFragment

class SectionsPagerAdapter(activity: DiscoverFragment) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = ForYouFragment()
            1 -> fragment = TrendingNowFragment()
        }

        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 2
    }
}