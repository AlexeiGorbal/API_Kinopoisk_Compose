package com.example.apicompose.domain

data class Film(
    val id: Long,
    val name: String,
    val type: String,
    val year: Int,
    val description: String,
    val filmLength: Int,
    val ageRating: Int,
    val posterUrl: String,
)