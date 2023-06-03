package com.example.domain.interceptors

import com.example.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias CharacterUnBookMarkBaseUseCase = BaseUseCase<Long,Flow<Int>>
class CharacterUnBookMarkUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) :CharacterUnBookMarkBaseUseCase {
    override suspend fun invoke(params: Long): Flow<Int> = characterRepository.setUnBookMarkedCharacter(params)
}