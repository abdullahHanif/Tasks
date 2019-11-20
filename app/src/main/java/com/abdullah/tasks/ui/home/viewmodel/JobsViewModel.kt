package com.abdullah.tasks.ui.home.viewmodel

import com.abdullah.tasks.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class JobsViewModel @Inject constructor() : BaseViewModel(),  CoroutineScope by CoroutineScope(Dispatchers.Main){


}