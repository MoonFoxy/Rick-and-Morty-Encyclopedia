package com.moonfoxy.rickandmortyencyclopedia.di

import android.content.Context
import com.moonfoxy.rickandmortyencyclopedia.domain.repository.LocalRepository
import com.moonfoxy.rickandmortyencyclopedia.local.dao.CharacterDao
import com.moonfoxy.rickandmortyencyclopedia.local.database.CharactersDatabase
import com.moonfoxy.rickandmortyencyclopedia.local.repository.LocalRepositoryImpl
import com.moonfoxy.rickandmortyencyclopedia.local.util.SharedPreferencesHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): CharactersDatabase {
        return CharactersDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideCharacterDao(charactersDatabase: CharactersDatabase): CharacterDao {
        return charactersDatabase.getCharacterDao()
    }

    @Provides
    @Singleton
    fun provideLocalRepositoryImpl(impl: LocalRepositoryImpl): LocalRepository = impl

    @Provides
    @Singleton
    fun provideSharedPreferenceHelper(@ApplicationContext context: Context): SharedPreferencesHelper {
        return SharedPreferencesHelper(context)
    }
}