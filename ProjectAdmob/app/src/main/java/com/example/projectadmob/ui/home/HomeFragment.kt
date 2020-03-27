package com.example.projectadmob.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.projectadmob.R
import com.example.projectadmob.databinding.FragmentHomeBinding
import com.example.projectadmob.goToDestination

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.challengeButton.setOnClickListener { goToDestination(HomeFragmentDirections.goToChallenges()) }
        binding.examButton.setOnClickListener { goToDestination(HomeFragmentDirections.goToExams()) }
        binding.trickButton.setOnClickListener { goToDestination(HomeFragmentDirections.goToTricks()) }
        binding.programButton.setOnClickListener { goToDestination(HomeFragmentDirections.goToPrograms()) }
        return binding.root
    }
}
