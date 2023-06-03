package com.example.remote.mapper

import com.example.data.models.CharacterLocationEntity
import com.example.remote.models.CharacterLocation
import javax.inject.Inject

class CharacterLocationEntityMapper @Inject constructor() :
    EntityMapper<CharacterLocation, CharacterLocationEntity> {
    override fun mapFromModal(model: CharacterLocation): CharacterLocationEntity {
        return CharacterLocationEntity(
            name = model.name, url = model.url
        )
    }
}