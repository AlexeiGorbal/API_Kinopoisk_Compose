package com.example.apicompose.domain

import com.example.apicompose.domain.remote.FilmApi
import com.example.apicompose.domain.remote.FilmEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilmRepository @Inject constructor(
    private val api: FilmApi,
) {

    suspend fun loadFilms(): List<Film> {
        val filmsEntity = api.getFilms()
        return filmsEntity.films.map { it.toModel() }
    }

    suspend fun getFilmById(filmId: Long): Film {
        return api.getFilmById("$filmId").toModel()
    }
}

private fun FilmEntity.toModel(): Film {
    return Film(id, name, type, year, description, filmLength, ageRating, poster.url)
}