package com.abdullah.tasks.ui.home.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.abdullah.tasks.R
import com.abdullah.tasks.base.BaseFragment
import com.abdullah.tasks.databinding.FrJobsBinding

class Jobs : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FrJobsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fr_jobs, container, false)
        return binding.root
    }

    override fun initializeComponents() {
        setupAdapter()
    }

    override fun setObservers() {
    }

    override fun showLoader() {
    }

    override fun hideLoader() {
    }

    fun setupAdapter() {

    }

    companion object {
        fun newInstance(): Jobs {
            val fragment = Jobs()
            return fragment
        }
    }

}