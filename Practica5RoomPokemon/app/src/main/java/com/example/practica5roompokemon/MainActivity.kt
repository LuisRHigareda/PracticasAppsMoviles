package com.example.practica5roompokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.practica5roompokemon.data.PokemonDatabase
import com.example.practica5roompokemon.data.PokemonRepository
import com.example.practica5roompokemon.navigation.AppNavigationController
import com.example.practica5roompokemon.ui.theme.Practica5RoomPokemonTheme
import com.example.practica5roompokemon.viewmodel.PokemonViewModel
import com.example.practica5roompokemon.viewmodel.PokemonViewModelFactory

class MainActivity : ComponentActivity() {

    private val viewModel: PokemonViewModel by viewModels {
        PokemonViewModelFactory(
            PokemonRepository(
                PokemonDatabase.getDatabase(applicationContext).pokemonDao()
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practica5RoomPokemonTheme {
                AppNavigationController(viewModel = viewModel)
            }
        }
    }
}