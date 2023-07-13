package com.moonfoxy.rickandmortyencyclopedia.domain.usecase

import com.moonfoxy.rickandmortyencyclopedia.data.models.Character
import com.moonfoxy.rickandmortyencyclopedia.domain.repository.DataRepository
import com.moonfoxy.rickandmortyencyclopedia.remote.Resource
import kotlinx.coroutines.flow.Flow

class GetCharacterUseCase constructor(
    private val dataRepository: DataRepository
) {
    operator fun invoke(characterId: Int): Flow<Resource<Character>> {
        return dataRepository.getCharacter(characterId)
    }
}