package com.abdullah.tasks.ui.home.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abdullah.tasks.di.app.scope.ApplicationScope
import com.abdullah.tasks.ui.home.viewmodel.JobDetailsViewModel
import com.abdullah.tasks.ui.home.viewmodel.JobsViewModel
import javax.inject.Inject

@ApplicationScope
class JobsViewModelFactory @Inject constructor(val viewModel: JobsViewModel) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass != JobsViewModel::class.java)
            throw IllegalArgumentException("Unknown View model class")
        else
            return viewModel as T
    }
}