package com.moonfoxy.rickandmortyencyclopedia.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.moonfoxy.rickandmortyencyclopedia.local.util.LocalConstants.CHARACTER_ORIGIN_TABLE_NAME

@Entity(tableName = CHARACTER_ORIGIN_TABLE_NAME)
data class CharacterOriginEntity(
    @PrimaryKey
    @ColumnInfo("name") val name: String,
    @ColumnInfo("url") val url: String
)