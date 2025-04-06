package com.example.apicompose.web

import com.example.apicompose.repository.remote.FilmApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideFilmApi(retrofit: Retrofit): FilmApi {
        return retrofit.create(FilmApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level=HttpLoggingInterceptor.Level.BODY
        return Retrofit.Builder()
            .baseUrl("https://api.kinopoisk.dev/")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(ApiKeyInterceptor())
                    .addInterceptor(interceptor)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}