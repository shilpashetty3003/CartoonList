package com.example.cache.mapper

import com.example.cache.models.CharacterLocationCacheEntity
import com.example.data.models.CharacterLocationEntity
import javax.inject.Inject

class CharacterLocationCacheMapper @Inject constructor() :CacheMapper<CharacterLocationCacheEntity,CharacterLocationEntity> {
    override fun mapFromCache(model: CharacterLocationCacheEntity): CharacterLocationEntity {
        return  CharacterLocationEntity(
            name=model.name,
            url  =model.url
        )
    }

    override fun mapToCache(model: CharacterLocationEntity): CharacterLocationCacheEntity {
        return CharacterLocationCacheEntity(
            name = model.name,
            url=model.url
        )
    }
}