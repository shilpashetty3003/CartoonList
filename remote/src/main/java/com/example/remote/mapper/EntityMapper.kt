package com.example.remote.mapper

interface EntityMapper<M, E> {
    fun mapFromModal(model: M): E
}