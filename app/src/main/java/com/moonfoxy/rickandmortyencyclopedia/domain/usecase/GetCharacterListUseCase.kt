package com.moonfoxy.rickandmortyencyclopedia.domain.usecase

import com.moonfoxy.rickandmortyencyclopedia.data.models.Character
import com.moonfoxy.rickandmortyencyclopedia.domain.repository.DataRepository
import com.moonfoxy.rickandmortyencyclopedia.remote.Resource
import kotlinx.coroutines.flow.Flow

class GetCharacterListUseCase constructor(
    private val dataRepository: DataRepository
) {
    operator fun invoke(): Flow<Resource<List<Character>>> {
        return dataRepository.getCharacterList()
    }
}