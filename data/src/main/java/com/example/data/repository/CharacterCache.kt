package com.example.data.repository

import com.example.data.models.CharacterEntity

interface CharacterCache {

    suspend fun getCharacters():List<CharacterEntity>
    suspend fun getCharacter(id:Long):CharacterEntity
    suspend fun saveCharacter(listCharacter:List<CharacterEntity>)
    suspend fun getBookmarkedCharacter():List<CharacterEntity>
    suspend fun setCharacterBookmark(id:Long):Int
    suspend fun setCharacterUnBookmark(id:Long):Int
    suspend fun isCached():Boolean
    suspend fun setLastCacheTime(lastCache:Long)
    suspend fun isExpired():Boolean

}