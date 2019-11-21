package com.abdullah.tasks.data.remotesource

import com.abdullah.tasks.network.NetworkCall
import com.abdullah.tasks.network.RequestResult
import javax.inject.Inject

class JobsRemoteSource @Inject constructor( val networkCall: NetworkCall){

    suspend fun getJobs(): RequestResult<out Any> {
        return networkCall.get("http://private-14c693-rentapanda.apiary-mock.com/jobs")
    }
}