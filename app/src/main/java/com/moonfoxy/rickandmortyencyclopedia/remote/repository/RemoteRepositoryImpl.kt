package com.moonfoxy.rickandmortyencyclopedia.remote.repository

import com.moonfoxy.rickandmortyencyclopedia.data.models.Character
import com.moonfoxy.rickandmortyencyclopedia.data.models.CharacterInfo
import com.moonfoxy.rickandmortyencyclopedia.domain.repository.RemoteRepository
import com.moonfoxy.rickandmortyencyclopedia.remote.api.ApiService
import com.moonfoxy.rickandmortyencyclopedia.remote.mappers.CharacterDtoMapper
import com.moonfoxy.rickandmortyencyclopedia.remote.mappers.CharacterInfoDtoMapper
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val characterDtoMapper: CharacterDtoMapper,
    private val characterInfoDtoMapper: CharacterInfoDtoMapper
) : RemoteRepository {

    override suspend fun getPageCharacters(page: Int): List<Character> {
        return apiService.getCharacterList(page).characters.map { characterModel ->
            characterDtoMapper.mapFromModel(characterModel)
        }
    }

    override suspend fun getCharacter(characterId: Int): Character {
        return characterDtoMapper.mapFromModel(apiService.getCharacter(characterId))
    }

    override suspend fun getApiInfo(): CharacterInfo {
        return characterInfoDtoMapper.mapFromModel(apiService.getCharacterList(1).info)
    }
}