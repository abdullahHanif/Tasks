package com.abdullah.tasks.di.app.component

import android.content.Context
import com.abdullah.tasks.AppClass
import com.abdullah.tasks.base.BaseActivity
import com.abdullah.tasks.data.localsource.LocalSource
import com.abdullah.tasks.di.app.module.*
import com.abdullah.tasks.di.app.scope.ApplicationScope
import com.abdullah.tasks.di.factory.IComponent
import dagger.Component

@Component(modules = [AppModule::class, SystemServicesModule::class, GsonModule::class, GsonModule::class, RoomModule::class, RetrofitModule::class])
@ApplicationScope
interface AppComponent : IComponent {

    fun inject(appClass: AppClass)
    fun inject(localsource: LocalSource)
    fun inject(baseActivity: BaseActivity)
    fun context(): Context
}