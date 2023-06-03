package com.example.domain.repository

import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

         suspend fun getCharacters(): Flow<List<com.example.domain.models.Character>>
         suspend fun getCharacter(id:Long):Flow<com.example.domain.models.Character>
         suspend fun getBookMarkedCharacters():Flow<List<com.example.domain.models.Character>>
         suspend fun saveCharacter(listCharacter:List<com.example.domain.models.Character>)
         suspend fun  setBookMarkedCharacter(id:Long):Flow<Int>
         suspend fun setUnBookMarkedCharacter(id:Long):Flow<Int>


}