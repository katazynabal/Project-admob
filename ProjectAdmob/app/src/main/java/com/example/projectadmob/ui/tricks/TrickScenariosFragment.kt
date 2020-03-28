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
import com.example.projectadmob.goToDestination

class TrickScenariosFragment : Fragment() {
    private lateinit var viewModel: TricksViewModel
    private lateinit var binding: FragmentTricksBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentTricksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TricksViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.banner.setOnClickListener { goToDestination(TrickScenariosFragmentDirections.goToBannerTricksFragment(isReward = false)) }
        binding.rewardBanner.setOnClickListener { goToDestination(TrickScenariosFragmentDirections.goToRewardTricksFragment(true)) }
    }
}
