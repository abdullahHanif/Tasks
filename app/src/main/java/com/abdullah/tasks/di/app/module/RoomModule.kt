package com.abdullah.tasks.di.app.module

import android.content.Context
import androidx.room.Room
import com.abdullah.tasks.R
import com.abdullah.tasks.db.TasksDatabase
import dagger.Module
import dagger.Provides

@Module
object RoomModule {

    @Synchronized
    @JvmStatic
    @Provides
    fun providesDatabase(context: Context) =
        Room.databaseBuilder(
            context,
            TasksDatabase::class.java,
            context.getString(R.string.db_name)
        ).build()

}