package com.abdullah.tasks.ui.home.viewmodel

import com.abdullah.tasks.base.BaseViewModel
import com.abdullah.tasks.di.app.scope.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


@ApplicationScope
class MainActivityViewModel @Inject constructor() : BaseViewModel(),
    CoroutineScope by CoroutineScope(Dispatchers.Main) {

}