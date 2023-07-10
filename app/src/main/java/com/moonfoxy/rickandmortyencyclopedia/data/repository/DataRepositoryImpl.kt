package com.moonfoxy.rickandmortyencyclopedia.data.repository

import com.moonfoxy.rickandmortyencyclopedia.BuildConfig.CHARACTERS_IN_PAGE
import com.moonfoxy.rickandmortyencyclopedia.data.models.Character
import com.moonfoxy.rickandmortyencyclopedia.domain.repository.DataRepository
import com.moonfoxy.rickandmortyencyclopedia.domain.repository.LocalRepository
import com.moonfoxy.rickandmortyencyclopedia.domain.repository.RemoteRepository
import com.moonfoxy.rickandmortyencyclopedia.remote.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) : DataRepository {

    private suspend fun checkLocalExpired(): Boolean {
        return localRepository.isExpired().also {
            if (it) localRepository.deleteAllCharacterList()
        }
    }

    override suspend fun getCharacterList(page: Int): Flow<Resource<List<Character>>> = flow {
        emit(Resource.Loading())
        checkLocalExpired()

        try {
            val apiInfo = remoteRepository.getApiInfo()
            var characterCount = localRepository.getCharacterCount()
            var nextPage = 1
            while (characterCount < apiInfo.count && nextPage <= apiInfo.pages) {
                nextPage = characterCount / CHARACTERS_IN_PAGE + 1
                saveCharacterList(remoteRepository.getPageCharacters(nextPage))
                characterCount = localRepository.getCharacterCount()
            }
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection."
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong!"
                )
            )
        }

        emit(Resource.Success(localRepository.getCharacterList()))
    }

    override suspend fun getCharacter(characterId: Int): Flow<Resource<Character>> = flow {
        emit(Resource.Loading())


        val characterCount = localRepository.getCharacterCount()
        if (checkLocalExpired() || characterId in 0..characterCount) {
            try {
                val apiInfo = remoteRepository.getApiInfo()
                if (characterId in 0..apiInfo.count) {
                    emit(
                        Resource.Error(
                            message = "Oops, something went wrong!"
                        )
                    )
                }
                saveCharacter(remoteRepository.getCharacter(characterId))
            } catch (e: HttpException) {
                emit(
                    Resource.Error(
                        message = "Couldn't reach server, check your internet connection."
                    )
                )
            } catch (e: IOException) {
                emit(
                    Resource.Error(
                        message = "Oops, something went wrong!"
                    )
                )
            }
        }

        emit(Resource.Success(localRepository.getCharacter(characterId)))
    }

    override suspend fun saveCharacterList(listCharacters: List<Character>) {
        localRepository.saveCharacterList(listCharacters)
    }

    override suspend fun saveCharacter(character: Character) {
        localRepository.saveCharacter(character)
    }
}