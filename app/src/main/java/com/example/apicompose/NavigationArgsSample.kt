package com.example.apicompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.apicompose.screens.information.InformationScreen
import com.example.apicompose.screens.list.ListFilmsScreen

@Composable
fun NavigationArgsSample(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController,
        startDestination = Routes.ListFilmsScreen.route
    ) {
        composable(Routes.ListFilmsScreen.route) {
            ListFilmsScreen(
                modifier = modifier,
                onNavToInfScreen = {
                    navController.navigate(Routes.InformationScreen.route + "/$it")
                }
            )
        }

        composable(
            route = Routes.InformationScreen.route + "/{id_film}",
            arguments = listOf(
                navArgument("id_film") {
                    type = NavType.LongType
                }
            )
        ) {
            val id = it.arguments?.getLong("id_film") ?: 0
            InformationScreen(
                id = id,
                modifier = modifier
            )
        }
    }
}