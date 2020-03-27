package com.example.projectadmob.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.projectadmob.databinding.FragmentHomeBinding
import com.example.projectadmob.goToDestination
import com.google.android.gms.ads.*
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdCallback
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mInterstitialAd: InterstitialAd
    private lateinit var rewardedAd: RewardedAd

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.challengeButton.setOnClickListener { goToDestination(HomeFragmentDirections.goToChallenges()) }
        binding.trickButton.setOnClickListener { goToDestination(HomeFragmentDirections.goToTricks()) }
        binding.programButton.setOnClickListener { goToDestination(HomeFragmentDirections.goToPrograms()) }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mInterstitialAd = InterstitialAd(requireContext())
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"

        val adView = AdView(this.context)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"
        binding.banner.loadAd(AdRequest.Builder().build())

        rewardedAd = RewardedAd(this.context, "ca-app-pub-3940256099942544/5224354917")
        val adLoadCallback = object: RewardedAdLoadCallback() {
            override fun onRewardedAdLoaded() {
                // Ad successfully loaded.
            }
            override fun onRewardedAdFailedToLoad(errorCode: Int) {
                // Ad failed to load.
            }
        }
        rewardedAd.loadAd(AdRequest.Builder().build(), adLoadCallback)

        binding.examButton.setOnClickListener {
            if (rewardedAd.isLoaded) {
                //val activityContext: Activity = ...
                val adCallback = object : RewardedAdCallback() {
                    override fun onRewardedAdOpened() {
                        // Ad opened.
                    }

                    override fun onRewardedAdClosed() {
                        // Ad closed.
                    }

                    override fun onUserEarnedReward(@NonNull reward: RewardItem) {
                        // User earned reward.
                    }

                    override fun onRewardedAdFailedToShow(errorCode: Int) {
                        // Ad failed to display.
                    }
                }
                rewardedAd.show(activity, adCallback)
            } else {
                Log.d("TAG", "The rewarded ad wasn't loaded yet.")
            }
        }

        mInterstitialAd.loadAd(AdRequest.Builder().build())
        mInterstitialAd.adListener = object : AdListener() {
            override fun onAdLoaded() {
                mInterstitialAd.show()
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                // Code to be executed when an ad request fails.
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
}
