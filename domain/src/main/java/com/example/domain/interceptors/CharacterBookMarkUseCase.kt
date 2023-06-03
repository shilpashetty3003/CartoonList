package com.example.domain.interceptors

import com.example.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias CharacterBookMarkBaseUseCase= BaseUseCase<Long,Flow<Int>>

class CharacterBookMarkUseCase  @Inject constructor(
    private val characterRepository: CharacterRepository
) : CharacterBookMarkBaseUseCase{
    override suspend fun invoke(params: Long): Flow<Int> = characterRepository.setBookMarkedCharacter(params)
}