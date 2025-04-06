package com.example.apicompose

sealed class Routes(val route: String) {
    object ListFilmsScreen : Routes("list_film_screen")
    object InformationScreen : Routes("information_screen")
}