package com.abdullah.tasks.ui.home.views

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.abdullah.tasks.R
import com.abdullah.tasks.base.BaseFragment
import com.abdullah.tasks.databinding.FrJobDetailsBinding
import com.abdullah.tasks.extension.popStack
import com.abdullah.tasks.ui.home.model.Job
import kotlinx.android.synthetic.main.fr_job_details.*

class JobDetails : BaseFragment() {
    lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = arguments?.getSerializable(JOB) as Job
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FrJobDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fr_job_details, container, false)
        binding.model = job
        return binding.root
    }

    override fun initializeComponents() {
    }

    override fun setObservers() {
    }

    override fun showLoader() {
    }

    override fun hideLoader() {
    }

    override fun setUpListeners() {
        close.setOnClickListener{
            screenTransactions().popStack()
        }

        buttonMap.setOnClickListener {
            val encodedQuery =
                Uri.encode("${job.job_latitude},${job.job_longitude}(${job.customer_name}})")
            val uri = Uri.parse("geo:${job.job_latitude},${job.job_longitude}?q=$encodedQuery")

            var mapIntent = Intent(Intent.ACTION_VIEW, uri)
            mapIntent = Intent.createChooser(mapIntent, "Open customer address with")
            startActivity(mapIntent)
        }
    }

    companion object {
        const val JOB = "JOB"

        fun newInstance(job: Job): JobDetails {
            val fragment = JobDetails()
            val bundle = Bundle().apply {
                putSerializable(JOB, job)
            }
            fragment.arguments = bundle

            fragment.arguments =

                return fragment
        }
    }
}