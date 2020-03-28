package com.example.projectadmob.ui.tricks

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.projectadmob.R
import com.example.projectadmob.databinding.FragmentTrickTemplateBinding
import com.example.projectadmob.databinding.FragmentTricksBinding
import com.example.projectadmob.databinding.FragmentTricksListBinding
import com.example.projectadmob.goToDestination
import com.example.projectadmob.showTrickRewardAlertDialog
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdCallback
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

class TricksFragment : Fragment(), TrickListAdapter.TrickPagerCallback {
    private lateinit var viewModel: TricksViewModel
    private lateinit var binding: FragmentTricksListBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentTricksListBinding.inflate(inflater, container, false)
        binding.adapterCallback = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TricksViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onItemClicked() {
        if(TricksFragmentArgs.fromBundle(requireArguments()).isReward) {
            showTrickRewardAlertDialog(requireContext()){
                val rewardedAd = RewardedAd(this.context, "ca-app-pub-3940256099942544/5224354917")
                val adLoadCallback = object: RewardedAdLoadCallback() {
                    override fun onRewardedAdLoaded() {
                                val adCallback = object : RewardedAdCallback() {
                                    override fun onRewardedAdOpened() {
                                        // Ad opened.
                                    }

                                    override fun onRewardedAdClosed() {
                                        // Ad closed.
                                    }

                                    override fun onUserEarnedReward(reward: RewardItem) {
                                        goToDestination(TricksFragmentDirections.goToNext())
                                    }

                                    override fun onRewardedAdFailedToShow(errorCode: Int) {
                                        // Ad failed to display.
                                    }
                                }
                                rewardedAd.show(activity, adCallback)
                        }
                    override fun onRewardedAdFailedToLoad(errorCode: Int) {
                        // Ad failed to load.
                    }
                }
                rewardedAd.loadAd(AdRequest.Builder().build(), adLoadCallback)
            }
        } else {
            goToDestination(TricksFragmentDirections.goToNext())
        }
    }
}
