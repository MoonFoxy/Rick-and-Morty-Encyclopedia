package com.moonfoxy.rickandmortyencyclopedia.domain.repository

import com.moonfoxy.rickandmortyencyclopedia.data.models.Character

interface LocalRepository {
    fun getCharacterList(): List<Character>
    fun getCharacter(characterId: Int): Character
    fun getCharacterCount(): Int
    fun saveCharacterList(listCharacters: List<Character>)
    fun saveCharacter(character: Character)
    fun deleteAllCharacterList()
    fun isNotEmpty(): Boolean
    fun isExpired(): Boolean
    fun setLastCacheTime(lastCache: Long)
}