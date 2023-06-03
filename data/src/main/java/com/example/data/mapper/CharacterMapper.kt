package com.example.data.mapper

import com.example.data.models.CharacterEntity
import com.example.domain.models.Character
import javax.inject.Inject

class CharacterMapper @Inject constructor(
    private val locationMapper:CharacterLocationMapper
) :Mapper<CharacterEntity,com.example.domain.models.Character> {
    override fun mapFromEntity(type: CharacterEntity): Character {
       return Character(
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
           characterLocation = locationMapper.mapFromEntity(type.characterLocation)
       )
    }

    override fun mapToEntity(type: Character): CharacterEntity {
        return  CharacterEntity(
            created = type.created,
            gender = type.gender,
            id = type.id,
            image = type.image,
            characterLocation = locationMapper.mapToEntity(type.characterLocation),
            name = type.name,
            species = type.species,
            status = type.status,
            type = type.type,
            url = type.url,
            isBookMarked = type.isBookMarked
        )

    }
}