package com.example.practicalementosdinamicos_coronadoluis.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practicalementosdinamicos_coronadoluis.ui.screens.FilmScreen
import com.example.practicalementosdinamicos_coronadoluis.ui.screens.LoginScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN_SCREEN
    ) {
        composable(Routes.LOGIN_SCREEN) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Routes.FILMS_SCREEN)
                }
            )
        }

        composable(Routes.FILMS_SCREEN) {
            FilmScreen()
        }
    }
}

object Routes {
    const val LOGIN_SCREEN = "login"
    const val FILMS_SCREEN = "list"
}