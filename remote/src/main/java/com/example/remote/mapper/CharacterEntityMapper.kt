package com.example.remote.mapper

import com.example.data.models.CharacterEntity
import com.example.remote.models.CharacterModel
import javax.inject.Inject

class CharacterEntityMapper @Inject constructor(
    private val characterLocationEntityMapper: CharacterLocationEntityMapper
) : EntityMapper<CharacterModel, CharacterEntity> {
    override fun mapFromModal(model: CharacterModel): CharacterEntity {
        return CharacterEntity(
            created = model.created,
            gender = model.gender,
            id = model.id,
            image = model.image,
            characterLocation = characterLocationEntityMapper.mapFromModal(model.characterLocation),
            name = model.name,
            species = model.species,
            status = model.status,
            type = model.type,
            url = model.url,
            isBookMarked = model.isBookMarked
        )
    }

}