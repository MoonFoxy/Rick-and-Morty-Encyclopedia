package com.moonfoxy.rickandmortyencyclopedia.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.moonfoxy.rickandmortyencyclopedia.local.util.LocalConstants.CHARACTER_TABLE_NAME

@Entity(tableName = CHARACTER_TABLE_NAME)
data class CharacterEntity(
    @PrimaryKey
    @ColumnInfo("id") val id: Int,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("status") val status: String,
    @ColumnInfo("species") val species: String,
    @ColumnInfo("type") val type: String,
    @ColumnInfo("gender") val gender: String,
    @ColumnInfo("origin") val origin: CharacterOriginEntity,
    @ColumnInfo("location") val location: CharacterLocationEntity,
    @ColumnInfo("image") val image: String,
    @ColumnInfo("episode") val episode: ArrayList<String> = arrayListOf(),
    @ColumnInfo("url") val url: String,
    @ColumnInfo("created") val created: String
)
