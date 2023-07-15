package com.moonfoxy.rickandmortyencyclopedia.local.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.moonfoxy.rickandmortyencyclopedia.local.util.LocalConstants.CHARACTER_TABLE_NAME

@Entity(tableName = CHARACTER_TABLE_NAME)
data class CharacterEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    @Embedded val origin: CharacterOriginEntity,
    @Embedded val location: CharacterLocationEntity,
    val image: String,
    val episode: List<String> = emptyList(),
    val url: String,
    val created: String
)