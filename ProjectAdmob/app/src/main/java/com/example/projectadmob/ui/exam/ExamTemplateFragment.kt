package com.example.projectadmob.ui.exam

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.projectadmob.R

class ExamTemplateFragment : Fragment() {

    companion object {
        fun newInstance() = ExamTemplateFragment()
    }

    private lateinit var viewModel: ExamTemplateViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_exam_template, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ExamTemplateViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
