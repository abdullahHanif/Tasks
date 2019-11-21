package com.abdullah.tasks.data.localsource

import com.abdullah.tasks.di.app.scope.ApplicationScope
import com.abdullah.tasks.network.RequestResult
import com.abdullah.tasks.ui.home.model.Job
import javax.inject.Inject

@ApplicationScope
class JobsLocalSource @Inject constructor() : LocalSource() {

        //suspend fun storeJobs(jobs: List<Job>) = db.jobsDao().insert(jobs)

    suspend fun storeJobs(jobs: List<Job>) {
        jobs.forEach {
            db.jobsDao().insert(it)
        }
    }

    suspend fun getJobs() = RequestResult.Local<List<Job>>(db.jobsDao().getAll())
    suspend fun clearJobs() = db.jobsDao().deleteAll()

}