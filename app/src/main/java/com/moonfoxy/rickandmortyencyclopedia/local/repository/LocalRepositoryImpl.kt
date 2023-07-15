package com.moonfoxy.rickandmortyencyclopedia.local.repository

import com.moonfoxy.rickandmortyencyclopedia.BuildConfig
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

    override fun getCharacterList(): List<Character> {
        return characterDao.getCharacterList().map { cacheCharacter ->
            characterEntityMapper.mapFromModel(cacheCharacter)
        }
    }

    override fun getCharacter(characterId: Int): Character {
        return characterEntityMapper.mapFromModel(characterDao.getCharacter(characterId))
    }

    override fun getCharacterCount(): Int {
        return characterDao.getCharacterList().count()
    }

    override fun saveCharacterList(listCharacters: List<Character>) {
        characterDao.insertCharacterList(
            listCharacters.map {
                characterEntityMapper.mapToModel(it)
            }.toList()
        )
    }

    override fun saveCharacter(character: Character) {
        return characterDao.insertCharacter(characterEntityMapper.mapToModel(character))
    }

    override fun deleteAllCharacterList() {
        characterDao.deleteAll()
    }

    override fun isNotEmpty(): Boolean {
        return characterDao.getCharacterList().isNotEmpty()
    }

    override fun setLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheTime = lastCache
    }

    override fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = getLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > BuildConfig.CACHE_EXPIRATION_TIME
    }

    /**
     * Get in millis, the last time the cache was accessed.
     */
    private fun getLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCacheTime
    }
}