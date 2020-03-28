package com.example.projectadmob

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.projectadmob.ui.tricks.TrickListAdapter
import com.example.projectadmob.ui.tricks.TrickPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("dotTabsForOnboarding", "callback")
    fun ViewPager2.setOnboardingDetailsTab(
        tabLayout: com.google.android.material.tabs.TabLayout,
        callback: TrickPagerAdapter.TrickPagerCallback?
    ) {
        if (callback != null) {
            val pagerAdapter = TrickPagerAdapter(callback)
            adapter = pagerAdapter
            val tabLayoutMediator = TabLayoutMediator(tabLayout, this) { _, _ -> }
            tabLayoutMediator.attach()
        }
    }

    @JvmStatic
    @BindingAdapter("callbackTrickList")
    fun RecyclerView.setOnboardingDetailsTab(
        callback: TrickListAdapter.TrickPagerCallback?
    ) {
        if (callback != null) {
            val pagerAdapter = TrickListAdapter(callback)
            adapter = pagerAdapter
        }
    }
}