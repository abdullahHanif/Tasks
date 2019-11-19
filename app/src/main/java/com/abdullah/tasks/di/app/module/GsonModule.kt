package com.abdullah.tasks.di.app.module

import com.abdullah.tasks.di.app.scope.ApplicationScope
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module
object GsonModule {

    @JvmStatic
    @Provides
    @ApplicationScope
    fun provideGson() = Gson()
}