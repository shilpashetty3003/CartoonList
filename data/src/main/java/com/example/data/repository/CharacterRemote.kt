package com.example.data.repository

import com.example.data.models.CharacterEntity

interface CharacterRemote {

    suspend fun getCharacters():List<CharacterEntity>
    suspend fun getCharacter(id:Long):CharacterEntity
}