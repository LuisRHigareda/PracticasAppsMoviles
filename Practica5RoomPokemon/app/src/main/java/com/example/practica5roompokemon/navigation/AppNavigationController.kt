package com.example.practica5roompokemon.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CatchingPokemon
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.practica5roompokemon.screens.BolsaScreen
import com.example.practica5roompokemon.screens.CapturarScreen
import com.example.practica5roompokemon.screens.HomeScreen
import com.example.practica5roompokemon.viewmodel.PokemonViewModel

sealed class AppScreen(
    val route: String,
    val title: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
) {
    data object Home : AppScreen("home", "Pokédex", Icons.Default.Home)
    data object Capturar : AppScreen("capturar", "Capturar", Icons.Default.CatchingPokemon)
    data object Bolsa : AppScreen("bolsa", "Colección", Icons.Default.Inventory2)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigationController(viewModel: PokemonViewModel) {
    val navController = rememberNavController()
    val snackbarHostState = remember { SnackbarHostState() }
    val allPokemon by viewModel.allPokemon.collectAsStateWithLifecycle()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route ?: AppScreen.Home.route

    val items = listOf(
        AppScreen.Home,
        AppScreen.Capturar,
        AppScreen.Bolsa
    )

    LaunchedEffect(Unit) {
        viewModel.messages.collect { message ->
            snackbarHostState.showSnackbar(message)
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = items.firstOrNull { it.route == currentRoute }?.title ?: "Pokédex",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        bottomBar = {
            NavigationBar {
                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title
                            )
                        },
                        label = { Text(item.title) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppScreen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(AppScreen.Home.route) {
                HomeScreen(allPokemon = allPokemon)
            }

            composable(AppScreen.Capturar.route) {
                CapturarScreen(viewModel = viewModel)
            }

            composable(AppScreen.Bolsa.route) {
                BolsaScreen(viewModel = viewModel)
            }
        }
    }
}