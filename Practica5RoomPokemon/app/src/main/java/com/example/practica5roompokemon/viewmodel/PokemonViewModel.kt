package com.example.practica5roompokemon.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica5roompokemon.data.Pokemon
import com.example.practica5roompokemon.data.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.random.Random

class PokemonViewModel(
    private val repository: PokemonRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _selectedType = MutableStateFlow<String?>(null)
    val selectedType = _selectedType.asStateFlow()

    private val _minLevel = MutableStateFlow(1)
    val minLevel = _minLevel.asStateFlow()

    private val _messages = MutableSharedFlow<String>()
    val messages = _messages.asSharedFlow()

    val allPokemon = repository.getAllPokemon()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    val availableTypes = repository.getTypes()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    val filteredPokemon = combine(
        _selectedType,
        _minLevel,
        _searchQuery
    ) { type, minLevel, search ->
        Triple(type, minLevel, search.trim())
    }.flatMapLatest { (type, minLevel, search) ->
        repository.getFilteredPokemon(type, minLevel, search)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun onSearchChange(value: String) {
        _searchQuery.value = value
    }

    fun onTypeChange(value: String?) {
        _selectedType.value = value
    }

    fun onMinLevelChange(value: Int) {
        _minLevel.value = value.coerceIn(1, 100)
    }

    fun capturePokemon(name: String, type: String) {
        val cleanName = name.trim()

        if (cleanName.isBlank()) {
            emitMessage("Escribe el nombre del Pokémon.")
            return
        }

        if (type.isBlank()) {
            emitMessage("Selecciona un tipo.")
            return
        }

        val formattedName = cleanName
            .lowercase()
            .replaceFirstChar { it.titlecase() }

        viewModelScope.launch(Dispatchers.IO) {
            repository.insertPokemon(
                Pokemon(
                    name = formattedName,
                    type = type,
                    level = 1
                )
            )
            _messages.emit("$formattedName fue capturado.")
        }
    }

    fun levelUp(pokemon: Pokemon) {
        if (pokemon.level >= 100) {
            emitMessage("${pokemon.name} ya alcanzó el nivel 100.")
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            val success = Random.nextInt(100) < 70

            if (success) {
                repository.updatePokemon(
                    pokemon.copy(level = pokemon.level + 1)
                )
                _messages.emit("${pokemon.name} subió a nivel ${pokemon.level + 1}.")
            } else {
                _messages.emit("${pokemon.name} no subió de nivel. Inténtalo otra vez.")
            }
        }
    }

    fun deletePokemon(pokemon: Pokemon) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePokemon(pokemon)
            _messages.emit("${pokemon.name} fue liberado.")
        }
    }

    private fun emitMessage(message: String) {
        viewModelScope.launch {
            _messages.emit(message)
        }
    }
}