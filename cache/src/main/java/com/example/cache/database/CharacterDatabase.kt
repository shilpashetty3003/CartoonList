package com.example.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cache.dao.CharacterDao

import com.example.cache.models.CharacterCacheEntity
import com.example.cache.models.CharacterLocationCacheEntity
import com.example.cache.utils.CacheConstants
import com.example.cache.utils.Migration
import javax.inject.Inject

@Database(
    entities = [CharacterCacheEntity::class, CharacterLocationCacheEntity::class],
    version = Migration.DB_VERSION, exportSchema = false
)
abstract class CharacterDatabase @Inject constructor() : RoomDatabase() {
    abstract fun cacheCharacterDao(): CharacterDao

    companion object{
        @Volatile
        private var INSTANCE: CharacterDatabase? = null
        fun getInstance(context: Context):CharacterDatabase = INSTANCE ?: synchronized(this){
            INSTANCE?: buildDatabase(context).also { INSTANCE=it }
        }
        private fun buildDatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext,
            CharacterDatabase::class.java,
            CacheConstants.DB_NAME
        ).build()
    }





}
