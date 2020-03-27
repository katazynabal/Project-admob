package com.example.projectadmob.ui.programs

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.projectadmob.R

class ProgramsFragment : Fragment() {

    companion object {
        fun newInstance() = ProgramsFragment()
    }

    private lateinit var viewModel: ProgramsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_programs, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProgramsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
