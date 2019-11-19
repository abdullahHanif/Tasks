package com.abdullah.tasks.data.repository

import com.abdullah.tasks.data.localsource.JobsLocalSource
import com.abdullah.tasks.data.remotesource.JobsRemoteSource
import com.abdullah.tasks.util.InternetConnection
import javax.inject.Inject

class JobsRepository @Inject constructor(
    val remoteSource: JobsRemoteSource,
    val localSource: JobsLocalSource,
    val internetConnection: InternetConnection
) {
    suspend fun getJobs() =
        if (internetConnection.isNetworkConnected()) remoteSource.getJobs() else localSource.getJobs()
}