package com.example.domain.interceptors

import com.example.domain.models.Character
import com.example.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetCharacterBookMarkBaseUseCase = BaseUseCase<Unit,Flow<List<com.example.domain.models.Character>>>

class GetCharacterBookmarkUseCase @Inject  constructor(
    private val characterRepository: CharacterRepository
) : GetCharacterBookMarkBaseUseCase {
    override suspend fun invoke(params: Unit): Flow<List<Character>>  =  characterRepository.getBookMarkedCharacters()
}