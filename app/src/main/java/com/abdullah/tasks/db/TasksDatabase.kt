package com.abdullah.tasks.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.abdullah.tasks.db.dao.JobsDao
import com.abdullah.tasks.di.app.scope.ApplicationScope
import com.abdullah.tasks.ui.home.model.Job
import com.abdullah.tasks.ui.home.model.JobTypeConverter


@ApplicationScope
@Database(
    entities = [Job::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(JobTypeConverter::class)
abstract class TasksDatabase : RoomDatabase() {

    abstract fun jobsDao(): JobsDao
}