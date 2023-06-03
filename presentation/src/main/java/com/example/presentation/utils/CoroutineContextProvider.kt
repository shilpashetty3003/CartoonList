package com.example.presentation.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

interface CoroutineContextProvider {
    val io:CoroutineDispatcher
    val default:CoroutineDispatcher
    val main:CoroutineDispatcher
}

class CoroutineContextProviderImpl @Inject constructor(
    override val io: CoroutineDispatcher = Dispatchers.IO,
    override val default: CoroutineDispatcher = Dispatchers.Default,
    override val main: CoroutineDispatcher = Dispatchers.Main
): CoroutineContextProvider{

}