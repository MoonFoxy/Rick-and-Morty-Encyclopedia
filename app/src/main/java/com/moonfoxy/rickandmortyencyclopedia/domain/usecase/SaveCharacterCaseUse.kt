package com.moonfoxy.rickandmortyencyclopedia.domain.usecase

import com.moonfoxy.rickandmortyencyclopedia.data.models.Character
import com.moonfoxy.rickandmortyencyclopedia.domain.repository.DataRepository
import javax.inject.Inject

class SaveCharacterCaseUse @Inject constructor(
    private val dataRepository: DataRepository
) {
    suspend operator fun invoke(character: Character) {
        return dataRepository.saveCharacter(character)
    }
}