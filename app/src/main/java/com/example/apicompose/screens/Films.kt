package com.example.apicompose.screens

data class Films(val films: List<Film>)

data class Film(
    val id: Long,
    val name: String,
    val type: String,
    val year: Int,
    val description: String,
    val filmLength: Int,
    val ageRating: Int,
    val poster: Poster
)

data class Poster(val url: String)