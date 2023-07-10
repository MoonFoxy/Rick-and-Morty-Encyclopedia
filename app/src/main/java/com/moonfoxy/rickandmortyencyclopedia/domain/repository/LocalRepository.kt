package com.moonfoxy.rickandmortyencyclopedia.domain.repository

import com.moonfoxy.rickandmortyencyclopedia.data.models.Character

interface LocalRepository {
        suspend fun getCharacterList(): List<Character>
        suspend fun getCharacter(characterId: Int): Character
        suspend fun getCharacterCount(): Int
        suspend fun saveCharacterList(listCharacters: List<Character>)
        suspend fun saveCharacter(character: Character)
        suspend fun deleteAllCharacterList()
        suspend fun isNotEmpty(): Boolean
        suspend fun isExpired(): Boolean
        suspend fun setLastCacheTime(lastCache: Long)
}