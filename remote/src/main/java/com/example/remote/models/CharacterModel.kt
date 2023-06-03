package com.example.remote.models

import com.squareup.moshi.Json

data class CharacterModel(
    val created: String,
    val gender: String,
    val id: Int,
    val image: String,
    @field:Json(name="location")
    val characterLocation: CharacterLocation,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String,
    var isBookMarked:Boolean=false
)