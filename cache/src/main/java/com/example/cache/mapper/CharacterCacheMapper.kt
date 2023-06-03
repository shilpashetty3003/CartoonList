package com.example.cache.mapper

import com.example.cache.models.CharacterCacheEntity
import com.example.data.models.CharacterEntity
import com.example.data.repository.CharacterCache
import javax.inject.Inject

class CharacterCacheMapper @Inject constructor(
    private val cacheLocationCacheMapper: CharacterLocationCacheMapper
) :CacheMapper<CharacterCacheEntity,CharacterEntity> {
    override fun mapFromCache(type: CharacterCacheEntity): CharacterEntity {
       return CharacterEntity(
           created = type.created,
           gender = type.gender,
           id = type.id,
           image = type.image,
           name = type.name,
           species = type.species,
           status = type.status,
           type = type.type,
           url = type.url,
           isBookMarked = type.isBookMarked,
           characterLocation = cacheLocationCacheMapper.mapFromCache(type.characterLocation)
       )
    }

    override fun mapToCache(type: CharacterEntity): CharacterCacheEntity {
       return CharacterCacheEntity(
           created = type.created,
           gender = type.gender,
           id = type.id,
           image = type.image,
           name = type.name,
           species = type.species,
           status = type.status,
           type = type.type,
           url = type.url,
           isBookMarked = type.isBookMarked,
           characterLocation =  cacheLocationCacheMapper.mapToCache(type.characterLocation)
       )
    }

}