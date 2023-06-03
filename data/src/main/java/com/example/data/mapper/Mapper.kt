package com.example.data.mapper

interface Mapper<T,V> {

    fun mapFromEntity(type:T):V
    fun mapToEntity(type:V):T
}