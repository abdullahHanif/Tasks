package com.abdullah.tasks.di.factory

import com.abdullah.tasks.AppClass
import com.abdullah.tasks.di.app.component.AppComponent
import com.abdullah.tasks.di.app.component.DaggerAppComponent
import com.abdullah.tasks.di.app.module.AppModule
import kotlin.reflect.KClass

object ComponentFactory {
    private lateinit var appComponent: AppComponent

    fun <T : IComponent> createComponent(componentClass: KClass<T>): T {
        when (componentClass) {
            AppComponent::class -> {
                appComponent = DaggerAppComponent
                    .builder()
                    .appModule(AppModule(AppClass.getAppContext()))
                    .build()

                return appComponent as T
            }

            else -> {
                throw IllegalArgumentException("Unknown Component class: ${componentClass.java.simpleName}")
            }
        }
    }
}