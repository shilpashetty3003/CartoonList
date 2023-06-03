package com.example.data.source

import com.example.data.models.CharacterEntity
import com.example.data.repository.CharacterCache
import com.example.data.repository.CharacterDataSource
import javax.inject.Inject

class CharacterCacheDataSource @Inject constructor(
    private val characterCache: CharacterCache
) :CharacterDataSource  {
    override suspend fun getCharacters(): List<CharacterEntity> {
        return  characterCache.getCharacters()
    }

    override suspend fun getCharacter(id: Long): CharacterEntity {
        return characterCache.getCharacter(id)
    }

    override suspend fun saveCharacters(listCharacters: List<CharacterEntity>) {
        characterCache.saveCharacter(listCharacters)
        characterCache.setLastCacheTime(System.currentTimeMillis())
    }

    override suspend fun getBookmarkedCharacters(): List<CharacterEntity> {
        return  characterCache.getBookmarkedCharacter()
    }

    override suspend fun setCharacterBookmark(characterID: Long): Int {
        return characterCache.setCharacterBookmark(characterID)
    }

    override suspend fun setCharacterUnBookmark(characterId: Long): Int {
        return characterCache.setCharacterUnBookmark(characterId)
    }

    override suspend fun isCached(): Boolean {
        return  characterCache.isCached()
    }
}