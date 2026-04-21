package com.example.practica5roompokemon.data

import kotlinx.coroutines.flow.Flow

class PokemonRepository(private val dao: PokemonDao) {

    fun getAllPokemon(): Flow<List<Pokemon>> = dao.getAllPokemon()

    fun getTypes(): Flow<List<String>> = dao.getTypes()

    fun getFilteredPokemon(
        type: String?,
        minLevel: Int,
        search: String
    ): Flow<List<Pokemon>> = dao.getFilteredPokemon(type, minLevel, search)

    suspend fun insertPokemon(pokemon: Pokemon) = dao.insertPokemon(pokemon)

    suspend fun updatePokemon(pokemon: Pokemon) = dao.updatePokemon(pokemon)

    suspend fun deletePokemon(pokemon: Pokemon) = dao.deletePokemon(pokemon)
}