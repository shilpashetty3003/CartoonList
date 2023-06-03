package com.example.remote.repository

import com.example.data.models.CharacterEntity
import com.example.data.repository.CharacterRemote
import com.example.remote.api.CharacterService
import com.example.remote.mapper.CharacterEntityMapper
import javax.inject.Inject

class CharacterRemoteImp @Inject constructor(
    private val characterService: CharacterService,
    private val characterEntityMapper: CharacterEntityMapper

) : CharacterRemote {
    override suspend fun getCharacters(): List<CharacterEntity> {
        return characterService.getCharacters().characters.map {
            characterEntityMapper.mapFromModal(it)
        }
    }

    override suspend fun getCharacter(id: Long): CharacterEntity {
        return characterEntityMapper.mapFromModal(characterService.getCharacter(id))
    }
}