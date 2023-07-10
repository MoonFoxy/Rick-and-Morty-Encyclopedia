package com.moonfoxy.rickandmortyencyclopedia.di

import com.moonfoxy.rickandmortyencyclopedia.BuildConfig
import com.moonfoxy.rickandmortyencyclopedia.domain.repository.RemoteRepository
import com.moonfoxy.rickandmortyencyclopedia.remote.api.ApiService
import com.moonfoxy.rickandmortyencyclopedia.remote.api.ServiceFactory
import com.moonfoxy.rickandmortyencyclopedia.remote.repository.RemoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return ServiceFactory.create(BuildConfig.DEBUG, BuildConfig.BASE_URL)
    }

    @Provides
    @Singleton
    fun provideRemoteRepositoryImpl(impl: RemoteRepositoryImpl): RemoteRepository = impl
}