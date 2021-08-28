package com.example.movies.data.di

import android.content.Context
import com.example.movies.data.api.*
import com.example.movies.data.util.Constants.BASE_URL
import com.example.movies.ui.util.ConnectionLiveData
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Provides
    @Singleton
    fun provideConnection(@ApplicationContext context: Context) = ConnectionLiveData(context)

    @Provides
    @Singleton
    fun provideFirebaseAuth() = Firebase.auth


    @Provides
    @Singleton
    fun provideFirebaseFirestore() = Firebase.firestore


}

