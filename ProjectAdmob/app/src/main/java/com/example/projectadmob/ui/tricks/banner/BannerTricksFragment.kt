package com.example.projectadmob.ui.tricks.banner

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup

import com.example.projectadmob.databinding.FragmentTrickTemplateBinding
import com.example.projectadmob.ui.tricks.TrickPagerAdapter
import com.example.projectadmob.ui.tricks.TricksViewModel
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize

class BannerTricksFragment : Fragment(), TrickPagerAdapter.TrickPagerCallback {
    private lateinit var viewModel: TricksViewModel
    private lateinit var binding: FragmentTrickTemplateBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentTrickTemplateBinding.inflate(inflater, container, false)
        binding.adapterCallback = this
        binding.adView.visibility = VISIBLE
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TricksViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)
        binding.adView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                Log.e("mano", "loaded")
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                // Code to be executed when an ad request fails.
                Log.e("mano", "error " +errorCode)
            }

            override fun onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
            }
        }
    }

    override fun onItemClicked() {

    }
}
