package com.abdullah.tasks.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        attachViewModel()
        setObservers()
    }

    protected abstract fun attachViewModel()
    protected abstract fun setObservers()
    protected abstract fun startObservingNavEvents()
}