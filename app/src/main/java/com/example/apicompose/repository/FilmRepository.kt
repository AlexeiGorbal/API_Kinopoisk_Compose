package com.example.apicompose.repository

import com.example.apicompose.repository.remote.FilmApi
import com.example.apicompose.repository.remote.FilmEntity
import com.example.apicompose.repository.remote.PosterEntity
import com.example.apicompose.screens.Film
import com.example.apicompose.screens.Films
import com.example.apicompose.screens.Poster
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilmRepository @Inject constructor(
    private val api: FilmApi
) {

    suspend fun loadFilms(): Films {
        val filmsEntity = api.getFilms()
        val film = filmsEntity.films.map { it.toModel() }
        return Films(film)
    }

    suspend fun getFilmById(filmId: Long): Film {
        return api.getFilmById("$filmId").toModel()
    }
}

fun FilmEntity.toModel(): Film {
    return Film(id, name, type, year, description, filmLength, ageRating, poster.toModel())
}

fun PosterEntity.toModel(): Poster {
    return Poster(url)
}