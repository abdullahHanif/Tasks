package com.abdullah.tasks.data.localsource

import com.abdullah.tasks.db.TasksDatabase
import com.abdullah.tasks.di.app.component.AppComponent
import com.abdullah.tasks.di.factory.ComponentFactory
import javax.inject.Inject

abstract class LocalSource {

    @Inject
    lateinit var db: TasksDatabase

    init {
        ComponentFactory.createComponent(AppComponent::class).inject(this)
    }

}