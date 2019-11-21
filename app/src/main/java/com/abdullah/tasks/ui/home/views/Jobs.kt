package com.abdullah.tasks.ui.home.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdullah.tasks.R
import com.abdullah.tasks.base.BaseFragment
import com.abdullah.tasks.databinding.FrJobsBinding
import com.abdullah.tasks.di.app.component.AppComponent
import com.abdullah.tasks.di.factory.ComponentFactory
import com.abdullah.tasks.extension.addFragment
import com.abdullah.tasks.ui.home.adapters.JobsAdapter
import com.abdullah.tasks.ui.home.events.JobsNavEvents
import com.abdullah.tasks.ui.home.factory.JobsViewModelFactory
import com.abdullah.tasks.ui.home.viewmodel.JobsViewModel
import kotlinx.android.synthetic.main.fr_jobs.*
import javax.inject.Inject

class Jobs : BaseFragment() {
    lateinit var adapter: JobsAdapter
    @Inject
    lateinit var viewModelFactory: JobsViewModelFactory

    private val viewModel: JobsViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)
            .get(JobsViewModel::class.java)
    }

    init {
        ComponentFactory.createComponent(AppComponent::class).inject(this)
    }

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
        viewModel.fetchJobs()
        setupAdapter()
    }

    override fun setObservers() {
        observeDataEvents(viewModel)

        viewModel.ObNavEvent.observe(this, Observer {
            it.getEventIfNotHandled()?.let { event ->
                when (event) {
                    is JobsNavEvents.NotifyAdapter -> {
                        adapter?.let {
                            adapter.notifyDataSetChanged()
                            //no data found
                            if (viewModel.list.isNullOrEmpty()) {
                                NoDataMessage.visibility = View.VISIBLE
                            } else {
                                NoDataMessage.visibility = View.GONE
                            }
                        }
                    }
                    is JobsNavEvents.JobDetail -> {
                        screenTransactions().addFragment(
                            JobDetails.newInstance(event.job),
                            R.id.container,
                            true
                        )
                    }

                }
            }
        })
    }

    override fun showLoader() {
        root_view.showLoader()
    }

    override fun hideLoader() {
        root_view.hideLoader()
    }

    fun setupAdapter() {
        adapter = JobsAdapter(viewModel)
        rv_jobs_list.adapter = adapter
        rv_jobs_list.layoutManager = LinearLayoutManager(context)
    }

    companion object {
        fun newInstance(): Jobs {
            val fragment = Jobs()
            return fragment
        }
    }

}