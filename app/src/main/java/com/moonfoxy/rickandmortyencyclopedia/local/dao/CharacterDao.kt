package com.moonfoxy.rickandmortyencyclopedia.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.moonfoxy.rickandmortyencyclopedia.local.models.CharacterEntity
import com.moonfoxy.rickandmortyencyclopedia.local.util.LocalConstants

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacterList(characters: List<CharacterEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacter(character: CharacterEntity)

    @Query("SELECT * FROM ${LocalConstants.CHARACTER_TABLE_NAME}")
    fun getCharacterList(): List<CharacterEntity>

    @Query("SELECT * FROM ${LocalConstants.CHARACTER_TABLE_NAME} WHERE id = :id")
    fun getCharacter(id: Int): CharacterEntity

    @Query("DELETE FROM ${LocalConstants.CHARACTER_TABLE_NAME}")
    fun deleteAll()
}