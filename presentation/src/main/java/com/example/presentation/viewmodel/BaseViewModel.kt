package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.presentation.utils.CoroutineContextProvider
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel(val contextProvider:CoroutineContextProvider) :ViewModel() {

    private val job:Job=Job()

    abstract val coroutineExceptionHandler:CoroutineExceptionHandler
    protected fun launchCoroutineIo(block:suspend () -> Unit) :Job{
        return viewModelScope.launch { contextProvider.io + job +coroutineExceptionHandler
            block
        }
    }
}