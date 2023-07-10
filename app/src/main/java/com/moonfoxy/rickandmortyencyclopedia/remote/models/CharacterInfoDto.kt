package com.moonfoxy.rickandmortyencyclopedia.remote.models

import com.google.gson.annotations.SerializedName

data class CharacterInfoDto(
    @SerializedName("count") val count: Int,
    @SerializedName("pages") val pages: Int
)
