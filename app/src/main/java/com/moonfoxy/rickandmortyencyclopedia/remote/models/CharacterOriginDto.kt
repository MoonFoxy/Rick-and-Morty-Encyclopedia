package com.moonfoxy.rickandmortyencyclopedia.remote.models

import com.google.gson.annotations.SerializedName


data class CharacterOriginDto(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)