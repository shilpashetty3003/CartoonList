package com.example.domain.interceptors

import com.example.domain.models.Character
import com.example.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetCharacterListByIdBaseUseCase = BaseUseCase<Long, Flow<com.example.domain.models.Character>>

class  GetCharacterListByIdUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) : GetCharacterListByIdBaseUseCase{
    override suspend fun invoke(params: Long): Flow<Character>  = characterRepository.getCharacter(params)
}