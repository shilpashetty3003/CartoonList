package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.CHARACTER_LOCATION_TABLE_NAME)
data class CharacterLocationCacheEntity(
    @PrimaryKey
    @ColumnInfo(name = "location")
    val name: String,
    @ColumnInfo(name = "location_url")
    val url: String
)