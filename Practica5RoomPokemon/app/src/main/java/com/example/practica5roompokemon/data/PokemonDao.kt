package com.example.practica5roompokemon.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: Pokemon)

    @Update
    suspend fun updatePokemon(pokemon: Pokemon)

    @Delete
    suspend fun deletePokemon(pokemon: Pokemon)

    @Query("SELECT * FROM pokemon ORDER BY name ASC")
    fun getAllPokemon(): Flow<List<Pokemon>>

    @Query("""
        SELECT * FROM pokemon
        WHERE (:type IS NULL OR type = :type)
        AND level >= :minLevel
        AND (
            :search = '' OR
            LOWER(name) LIKE '%' || LOWER(:search) || '%' OR
            LOWER(type) LIKE '%' || LOWER(:search) || '%'
        )
        ORDER BY level DESC, name ASC
    """)
    fun getFilteredPokemon(
        type: String?,
        minLevel: Int,
        search: String
    ): Flow<List<Pokemon>>

    @Query("SELECT DISTINCT type FROM pokemon ORDER BY type ASC")
    fun getTypes(): Flow<List<String>>
}