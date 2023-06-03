package com.example.data

import com.example.data.mapper.CharacterMapper
import com.example.data.source.CharacterDataSourceFactory
import com.example.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class CharacterRepositoryImp @Inject constructor(
    private val dataSourceFactory: CharacterDataSourceFactory,
    private val characterMapper: CharacterMapper
) : CharacterRepository {
    override suspend fun getCharacters(): Flow<List<com.example.domain.models.Character>> = flow {
        val isCached = dataSourceFactory.getCacheDatSource().isCached()
        val characterList = dataSourceFactory.getDatStore(isCached).getCharacters().map {
            characterMapper.mapFromEntity(it)
        }
        saveCharacter(characterList)
        emit(characterList)

    }

    override suspend fun getCharacter(id: Long): Flow<com.example.domain.models.Character> = flow {
        var character = dataSourceFactory.getCacheDatSource().getCharacter(id)
        if (character.image.isEmpty()) {
            character = dataSourceFactory.getRemoteDatSource().getCharacter(id)
        }
        emit(characterMapper.mapFromEntity(character))
    }

    override suspend fun getBookMarkedCharacters(): Flow<List<com.example.domain.models.Character>> =
        flow {
            val characterList =
                dataSourceFactory.getCacheDatSource().getBookmarkedCharacters().map {
                    characterMapper.mapFromEntity(it)
                }
            emit(characterList)
        }

    override suspend fun saveCharacter(listCharacter: List<com.example.domain.models.Character>) {
        val characterList = listCharacter.map {
            characterMapper.mapToEntity(it)
        }
        dataSourceFactory.getCacheDatSource().saveCharacters(characterList)
    }

    override suspend fun setBookMarkedCharacter(id: Long): Flow<Int> = flow {
        emit(dataSourceFactory.getCacheDatSource().setCharacterBookmark(id))
    }

    override suspend fun setUnBookMarkedCharacter(id: Long): Flow<Int> = flow {
        emit(dataSourceFactory.getCacheDatSource().setCharacterUnBookmark(id))
    }
}
