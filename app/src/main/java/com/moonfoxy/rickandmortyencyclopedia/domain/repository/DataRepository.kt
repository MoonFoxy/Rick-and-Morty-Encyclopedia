package com.moonfoxy.rickandmortyencyclopedia.domain.repository

import com.moonfoxy.rickandmortyencyclopedia.data.models.Character
import com.moonfoxy.rickandmortyencyclopedia.remote.Resource
import kotlinx.coroutines.flow.Flow

interface DataRepository {
    suspend fun getCharacterList(page: Int): Flow<Resource<List<Character>>>
    suspend fun getCharacter(characterId: Int): Flow<Resource<Character>>
    suspend fun saveCharacterList(listCharacters: List<Character>)
    suspend fun saveCharacter(character: Character)
}