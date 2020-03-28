package com.example.projectadmob.ui.tricks.reward

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.projectadmob.databinding.FragmentTrickTemplateBinding
import com.example.projectadmob.ui.tricks.TrickPagerAdapter
import com.example.projectadmob.ui.tricks.TricksViewModel

class RewardTricksFragment : Fragment(), TrickPagerAdapter.TrickPagerCallback {
    private lateinit var viewModel: TricksViewModel
    private lateinit var binding: FragmentTrickTemplateBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentTrickTemplateBinding.inflate(inflater, container, false)
        binding.adapterCallback = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TricksViewModel::class.java)
    }

    override fun onItemClicked() {

    }
}

