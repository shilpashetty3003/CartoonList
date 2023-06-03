package com.example.cache.mapper

interface CacheMapper<T,V> {

    fun mapFromCache(model:T):V
    fun mapToCache(model:V):T
}