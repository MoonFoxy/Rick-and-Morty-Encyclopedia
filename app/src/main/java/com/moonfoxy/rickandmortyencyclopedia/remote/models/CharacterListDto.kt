package com.moonfoxy.rickandmortyencyclopedia.remote.models

import com.google.gson.annotations.SerializedName


data class CharacterListDto(
    @SerializedName("info") val info: CharacterInfoDto,
    @SerializedName("results") val characters: ArrayList<CharacterDto> = arrayListOf()
)