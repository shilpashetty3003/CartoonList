package com.example.remote.api

import com.example.remote.models.CharacterModel
import com.example.remote.models.CharacterResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {



    @GET("character")
    suspend fun getCharacters():CharacterResponseModel

    suspend fun getCharacter(@Query("id") id:Long):CharacterModel
}