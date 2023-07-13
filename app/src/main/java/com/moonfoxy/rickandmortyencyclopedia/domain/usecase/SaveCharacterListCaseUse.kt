package com.moonfoxy.rickandmortyencyclopedia.domain.usecase

import com.moonfoxy.rickandmortyencyclopedia.data.models.Character
import com.moonfoxy.rickandmortyencyclopedia.domain.repository.DataRepository

class SaveCharacterListCaseUse constructor(
    private val dataRepository: DataRepository
) {
    suspend operator fun invoke(characterList: List<Character>) {
        return dataRepository.saveCharacterList(characterList)
    }
}