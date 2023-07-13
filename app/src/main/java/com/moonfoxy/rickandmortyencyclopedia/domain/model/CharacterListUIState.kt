package com.moonfoxy.rickandmortyencyclopedia.domain.model

import com.moonfoxy.rickandmortyencyclopedia.data.models.Character

data class CharacterListUIState(
    val characterList: List<Character> = emptyList(),
    val isLoading: Boolean = false
)