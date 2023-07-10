package com.moonfoxy.rickandmortyencyclopedia.local.repository

import com.moonfoxy.rickandmortyencyclopedia.BuildConfig.CACHE_EXPIRATION_TIME
import com.moonfoxy.rickandmortyencyclopedia.data.models.Character
import com.moonfoxy.rickandmortyencyclopedia.domain.repository.LocalRepository
import com.moonfoxy.rickandmortyencyclopedia.local.dao.CharacterDao
import com.moonfoxy.rickandmortyencyclopedia.local.mappers.CharacterEntityMapper
import com.moonfoxy.rickandmortyencyclopedia.local.util.SharedPreferencesHelper
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val characterDao: CharacterDao,
    private val characterEntityMapper: CharacterEntityMapper,
    private val preferencesHelper: SharedPreferencesHelper
) : LocalRepository {

    override suspend fun getCharacterList(): List<Character> {
        return characterDao.getCharacterList().map { cacheCharacter ->
            characterEntityMapper.mapFromModel(cacheCharacter)
        }
    }

    override suspend fun getCharacter(characterId: Int): Character {
        return characterEntityMapper.mapFromModel(characterDao.getCharacter(characterId))
    }

    override suspend fun getCharacterCount(): Int {
        return characterDao.getCharacterList().count()
    }

    override suspend fun saveCharacterList(listCharacters: List<Character>) {
        characterDao.insertCharacterList(
            listCharacters.map {
                characterEntityMapper.mapToModel(it)
            }.toList()
        )
    }

    override suspend fun saveCharacter(character: Character) {
        return characterDao.insertCharacter(characterEntityMapper.mapToModel(character))
    }

    override suspend fun deleteAllCharacterList() {
        characterDao.deleteAll()
    }

    override suspend fun isNotEmpty(): Boolean {
        return characterDao.getCharacterList().isNotEmpty()
    }

    override suspend fun setLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheTime = lastCache
    }

    override suspend fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = getLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > CACHE_EXPIRATION_TIME
    }

    /**
     * Get in millis, the last time the cache was accessed.
     */
    private fun getLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCacheTime
    }
}