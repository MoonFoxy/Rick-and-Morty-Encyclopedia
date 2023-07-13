package com.moonfoxy.rickandmortyencyclopedia.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.moonfoxy.rickandmortyencyclopedia.local.util.LocalConstants.CHARACTER_ORIGIN_TABLE_NAME

@Entity(tableName = CHARACTER_ORIGIN_TABLE_NAME)
data class CharacterOriginEntity(
    @ColumnInfo("origin_name") val name: String,
    @ColumnInfo("origin_url") val url: String
)