package com.moonfoxy.rickandmortyencyclopedia.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.moonfoxy.rickandmortyencyclopedia.local.util.LocalConstants.CHARACTER_LOCATION_TABLE_NAME

@Entity(tableName = CHARACTER_LOCATION_TABLE_NAME)
data class CharacterLocationEntity(
    @PrimaryKey @ColumnInfo("location_name") val name: String,
    @ColumnInfo("location_url") val url: String
)
