package com.moonfoxy.rickandmortyencyclopedia.domain.usecase

import com.moonfoxy.rickandmortyencyclopedia.data.models.Character
import com.moonfoxy.rickandmortyencyclopedia.domain.repository.DataRepository
import javax.inject.Inject

class SaveCharacterListCaseUse @Inject constructor(
    private val dataRepository: DataRepository
) {
    suspend operator fun invoke(characterList: List<Character>) {
        return dataRepository.saveCharacterList(characterList)
    }
}