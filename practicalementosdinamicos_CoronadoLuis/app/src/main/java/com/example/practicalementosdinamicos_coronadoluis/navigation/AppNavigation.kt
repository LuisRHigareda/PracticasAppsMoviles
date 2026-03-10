package com.example.practicalementosdinamicos_coronadoluis.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practicalementosdinamicos_coronadoluis.model.getFilmById
import com.example.practicalementosdinamicos_coronadoluis.ui.screens.FilmDetailScreen
import com.example.practicalementosdinamicos_coronadoluis.ui.screens.FilmsScreen
import com.example.practicalementosdinamicos_coronadoluis.ui.screens.LoginScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("list")
                }
            )
        }

        composable("list") {
            FilmsScreen(
                onFilmClick = { filmId ->
                    navController.navigate("detail/$filmId")
                }
            )
        }

        composable(
            route = "detail/{filmId}",
            arguments = listOf(
                navArgument("filmId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val filmId = backStackEntry.arguments?.getInt("filmId") ?: 0
            val film = getFilmById(filmId)

            if (film != null) {
                FilmDetailScreen(
                    film = film,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}