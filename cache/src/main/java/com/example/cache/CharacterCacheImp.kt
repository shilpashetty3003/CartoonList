package com.example.cache

import com.example.cache.dao.CharacterDao
import com.example.cache.mapper.CharacterCacheMapper
import com.example.cache.utils.CachePreferenceHelper
import com.example.data.models.CharacterEntity
import com.example.data.repository.CharacterCache
import javax.inject.Inject

class CharacterCacheImp  @Inject constructor(
    private val characterDao: CharacterDao,
    private val characterCacheMapper:CharacterCacheMapper,
    private val preferenceHelper: CachePreferenceHelper

) : CharacterCache {
    override suspend fun getCharacters(): List<CharacterEntity> {
        return characterDao.getCharacters().map {
            characterCacheMapper.mapFromCache(it)
        }
    }

    override suspend fun getCharacter(id: Long): CharacterEntity {
       return characterCacheMapper.mapFromCache(characterDao.getCharacter(id))
    }

    override suspend fun saveCharacter(listCharacter: List<CharacterEntity>) {
        characterDao.addCharacter(
            *listCharacter.map {
                characterCacheMapper.mapToCache(it)
            }.toTypedArray()
        )
    }

    override suspend fun getBookmarkedCharacter(): List<CharacterEntity> {
        return characterDao.getBookMarkedCharacters().map {
            characterCacheMapper.mapFromCache(it)
        }
    }

    override suspend fun setCharacterBookmark(id: Long): Int {
        return characterDao.bookmarkedCharacter(id)
    }

    override suspend fun setCharacterUnBookmark(id: Long): Int {
       return characterDao.unBookmarkedCharacter(id)
    }

    override suspend fun isCached(): Boolean {
       return  characterDao.getCharacters().isNotEmpty()
    }

    override suspend fun setLastCacheTime(lastCache: Long) {
        preferenceHelper.lastCacheTime=lastCache
    }

    override suspend fun isExpired(): Boolean {
        val currentTime=System.currentTimeMillis()
        val lastCacheTime=preferenceHelper.lastCacheTime
        val expirationTime=(60 * 5 * 1000).toLong()
        return currentTime - lastCacheTime > expirationTime
    }
}