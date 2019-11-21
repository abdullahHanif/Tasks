package com.abdullah.tasks.db.dao

import androidx.room.*
import com.abdullah.tasks.ui.home.model.Job


@Dao
interface JobsDao {

    @Query("SELECT * from Job")
    suspend fun getAll(): List<Job>

    @Query("SELECT * from Job WHERE id = :id")
    suspend fun getJobById(id: Int): Job

    @Insert
    suspend fun insert(job: Job)

    @Query("DELETE from Job")
    suspend fun deleteAll(): Int

    @Update
    suspend fun updateJob(job: Job) :Int
}