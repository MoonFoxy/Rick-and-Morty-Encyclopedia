package com.moonfoxy.rickandmortyencyclopedia.di

import com.moonfoxy.rickandmortyencyclopedia.data.repository.DataRepositoryImpl
import com.moonfoxy.rickandmortyencyclopedia.domain.repository.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideCharacterRepository(impl: DataRepositoryImpl): DataRepository = impl
}