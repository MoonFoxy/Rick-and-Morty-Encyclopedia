package com.moonfoxy.rickandmortyencyclopedia.di

import com.moonfoxy.rickandmortyencyclopedia.data.repository.DataRepositoryImpl
import com.moonfoxy.rickandmortyencyclopedia.domain.repository.DataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideCharacterRepository(impl: DataRepositoryImpl): DataRepository
}