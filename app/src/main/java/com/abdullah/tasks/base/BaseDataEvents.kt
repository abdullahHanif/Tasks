package com.abdullah.tasks.base

sealed class BaseDataEvents {
    object ShowLoader : BaseDataEvents()
    object HideLoader : BaseDataEvents()
}