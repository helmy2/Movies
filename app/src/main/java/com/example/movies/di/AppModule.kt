package com.example.movies.di

import com.example.movies.api.MovieApi
import com.example.movies.repository.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(MovieApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit): MovieApi =
        retrofit.create(MovieApi::class.java)

}

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