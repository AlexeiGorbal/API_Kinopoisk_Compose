package com.example.apicompose.repository.remote

import com.google.gson.annotations.SerializedName

data class FilmsEntity(
    @SerializedName("docs") val films: List<FilmEntity>
)

data class FilmEntity(
   @SerializedName("id") val id: Long,
   @SerializedName("name") val name: String,
   @SerializedName("type") val type: String,
   @SerializedName("year") val year: Int,
   @SerializedName("description") val description: String,
   @SerializedName("movieLength") val filmLength: Int,
   @SerializedName("ageRating") val ageRating: Int,
   @SerializedName("poster") val poster: PosterEntity
)

data class PosterEntity(@SerializedName("url")val url: String)