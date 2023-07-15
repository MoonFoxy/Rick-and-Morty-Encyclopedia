package com.moonfoxy.rickandmortyencyclopedia.local.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CharacterEntityConverter {
    @TypeConverter
    fun fromListToJson(value: List<String>): String = Gson().toJson(value)

    @TypeConverter
    fun fromJsonToList(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }
}