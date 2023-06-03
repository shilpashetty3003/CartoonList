package com.example.domain.interceptors

import com.example.domain.models.Character
import com.example.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


typealias  GetCharacterListBaseUseCase = BaseUseCase<Unit, Flow<List<com.example.domain.models.Character>>>
class GetCharacterListUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) : GetCharacterListBaseUseCase{
    override suspend fun invoke(params: Unit) = characterRepository.getCharacters()
}