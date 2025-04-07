package com.example.apicompose.domain.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface FilmApi {
    @GET("v1.4/movie?page=1&limit=10&typeNumber=1&rating.kp=7-10&ageRating=12-18")
    suspend fun getFilms(): FilmsEntity

    @GET("v1.4/movie/{id}")
    suspend fun getFilmById(@Path("id") id: String): FilmEntity
}