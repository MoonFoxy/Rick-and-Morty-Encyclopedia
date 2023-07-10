package com.moonfoxy.rickandmortyencyclopedia.domain.repository

import com.moonfoxy.rickandmortyencyclopedia.data.models.Character
import com.moonfoxy.rickandmortyencyclopedia.data.models.CharacterInfo

interface RemoteRepository {
    suspend fun getPageCharacters(page: Int): List<Character>
    suspend fun getCharacter(characterId: Int): Character
    suspend fun getApiInfo(): CharacterInfo
}