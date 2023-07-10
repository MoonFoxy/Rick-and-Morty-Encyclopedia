package com.moonfoxy.rickandmortyencyclopedia.remote.api

import com.moonfoxy.rickandmortyencyclopedia.remote.models.CharacterDto
import com.moonfoxy.rickandmortyencyclopedia.remote.models.CharacterListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    suspend fun getCharacterList(@Query("page") page: Int): CharacterListDto

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): CharacterDto
}