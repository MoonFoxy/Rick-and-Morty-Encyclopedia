package com.moonfoxy.rickandmortyencyclopedia.local.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CharacterEntityConverter {
    @TypeConverter
    fun fromArrayListToJson(value: ArrayList<String>): String = Gson().toJson(value)

    @TypeConverter
    fun fromJsonToArrayList(value: String): ArrayList<String> {
        val listType = object : TypeToken<ArrayList<String>>() {}.type
        return Gson().fromJson(value, listType)
    }
}