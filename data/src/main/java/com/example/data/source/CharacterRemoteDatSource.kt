package com.example.data.source

import com.example.data.models.CharacterEntity
import com.example.data.repository.CharacterDataSource
import com.example.data.repository.CharacterRemote
import javax.inject.Inject

class CharacterRemoteDatSource @Inject constructor(private val characterRemote: CharacterRemote) :
    CharacterDataSource {
    override suspend fun getCharacters(): List<CharacterEntity> {
        return characterRemote.getCharacters()
    }

    override suspend fun getCharacter(id: Long): CharacterEntity {
        return characterRemote.getCharacter(id)
    }

    override suspend fun saveCharacters(listCharacters: List<CharacterEntity>) {
        throw  java.lang.UnsupportedOperationException("")
    }

    override suspend fun getBookmarkedCharacters(): List<CharacterEntity> {
        throw  java.lang.UnsupportedOperationException("")
    }

    override suspend fun setCharacterBookmark(characterID: Long): Int {
        throw  java.lang.UnsupportedOperationException("")
    }

    override suspend fun setCharacterUnBookmark(characterId: Long): Int {
        throw  java.lang.UnsupportedOperationException("")
    }

    override suspend fun isCached(): Boolean {
        throw  java.lang.UnsupportedOperationException("")
    }
}