package com.example.movies.di

import com.example.movies.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideDetailsRepository(
        detailsRepositoryImpl: DetailsRepositoryImpl
    ): DetailsRepository

    @Binds
    @Singleton
    abstract fun provideDiscoverRepository(
        discoverRepositoryImpl: DiscoverRepositoryImpl
    ): DiscoverRepository

    @Binds
    @Singleton
    abstract fun provideHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository

    @Binds
    @Singleton
    abstract fun providePersonRepository(
        personRepositoryImpl: PersonRepositoryImpl
    ): PersonRepository

    @Binds
    @Singleton
    abstract fun provideSearchRepository(
        searchRepositoryImpl: SearchRepositoryImpl
    ): SearchRepository
}