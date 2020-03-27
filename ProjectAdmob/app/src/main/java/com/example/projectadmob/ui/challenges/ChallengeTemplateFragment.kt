package com.example.projectadmob.ui.challenges

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.projectadmob.R

class ChallengeTemplateFragment : Fragment() {

    companion object {
        fun newInstance() = ChallengeTemplateFragment()
    }

    private lateinit var viewModel: ChallengeTemplateViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_challenge_template, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ChallengeTemplateViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
