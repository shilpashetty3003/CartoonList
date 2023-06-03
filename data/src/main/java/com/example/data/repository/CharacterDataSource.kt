package com.example.data.repository

import com.example.data.models.CharacterEntity

interface CharacterDataSource {
    //Remote

    suspend fun getCharacters():List<CharacterEntity>
    suspend fun getCharacter(id:Long):CharacterEntity

    suspend fun saveCharacters(listCharacters:List<CharacterEntity>)
    suspend fun getBookmarkedCharacters():List<CharacterEntity>
    suspend fun setCharacterBookmark(characterID:Long):Int
    suspend fun setCharacterUnBookmark(characterId:Long):Int
    suspend fun isCached():Boolean
}