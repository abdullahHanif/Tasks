package com.abdullah.tasks.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.abdullah.tasks.R
import com.abdullah.tasks.databinding.LiJobBinding
import com.abdullah.tasks.ui.home.viewmodel.JobsViewModel

class JobsAdapter(val viewModel: JobsViewModel) : RecyclerView.Adapter<JobsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: LiJobBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.li_job, parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount() = viewModel.list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.model = viewModel.list[position]

        holder.binding.root.setOnClickListener{
            viewModel.menuItemClick(viewModel.list[position])
        }


    }

    class ViewHolder(val binding: LiJobBinding) : RecyclerView.ViewHolder(binding.root)
}