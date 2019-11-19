package com.abdullah.tasks.db.dao

import androidx.room.*


@Dao
interface JobsDao {

    @Query("SELECT * from Job")
    suspend fun getAll(): List<String>

    @Query("SELECT * from Job WHERE id = :id")
    suspend fun getJobById(id: String): List<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(job: String)

    @Query("DELETE from Job")
    suspend fun deleteAll(): Int

    @Update
    suspend fun updateJob(job: String) :Int
}