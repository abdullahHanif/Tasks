package com.abdullah.tasks.data.localsource

import com.abdullah.tasks.di.app.scope.ApplicationScope
import com.abdullah.tasks.network.RequestResult
import javax.inject.Inject

@ApplicationScope
class JobsLocalSource @Inject constructor() : LocalSource() {

    suspend fun storeJobs(jobs: String) = db.jobsDao().insert(jobs)
    suspend fun getJobs() = RequestResult.Local<List<String>>(db.jobsDao().getAll())
    suspend fun clearJobs() = db.jobsDao().deleteAll()

}