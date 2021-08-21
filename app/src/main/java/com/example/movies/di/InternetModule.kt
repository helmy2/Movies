package com.example.movies.di

import com.example.movies.api.*
import com.example.movies.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object InternetModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit): SearchApi =
        retrofit.create(SearchApi::class.java)

    @Provides
    @Singleton
    fun provideDetailsApi(retrofit: Retrofit): DetailsApi =
        retrofit.create(DetailsApi::class.java)

    @Provides
    @Singleton
    fun provideDiscoverApi(retrofit: Retrofit): DiscoverApi =
        retrofit.create(DiscoverApi::class.java)


    @Provides
    @Singleton
    fun provideHomeApi(retrofit: Retrofit): HomeApi =
        retrofit.create(HomeApi::class.java)

    @Provides
    @Singleton
    fun providePersonApi(retrofit: Retrofit): PersonApi =
        retrofit.create(PersonApi::class.java)

}

