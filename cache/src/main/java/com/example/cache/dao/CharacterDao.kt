package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.models.CharacterCacheEntity
import com.example.data.models.CharacterEntity


@Dao
interface CharacterDao {

    @Query("select * from characters")
    fun getCharacters():List<CharacterCacheEntity>

    @Query("select * from characters where id=:id")
    fun getCharacter(id:Long):CharacterCacheEntity

    @Query("select * from characters where is_bookmarked=1")
    fun getBookMarkedCharacters():List<CharacterCacheEntity>

    @Query("delete from characters")
    fun clearCharacters():Int

    @Query("update characters set is_bookmarked=1 where id=:id")
    fun bookmarkedCharacter(id:Long):Int

    @Query("update characters set is_bookmarked=0 where id=:id")
    fun unBookmarkedCharacter(id:Long):Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCharacter(vararg characterList:CharacterCacheEntity)






}