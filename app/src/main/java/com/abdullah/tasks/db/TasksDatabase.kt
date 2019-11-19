package com.abdullah.tasks.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abdullah.tasks.db.dao.JobsDao
import com.abdullah.tasks.di.app.scope.ApplicationScope


@ApplicationScope
@Database(
    entities = [String::class],
    version = 1,
    exportSchema = false
)
abstract class TasksDatabase : RoomDatabase() {

    abstract fun jobsDao(): JobsDao
}