package com.abdullah.tasks.ui.home.events

import com.abdullah.tasks.ui.home.model.Job

sealed class JobsNavEvents {
    class JobDetail(val job: Job) : JobsNavEvents()

    object NotifyAdapter : JobsNavEvents()
}