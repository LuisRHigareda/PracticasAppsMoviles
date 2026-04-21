package com.example.practica5roompokemon.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CatchingPokemon
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.practica5roompokemon.data.PokemonCatalog
import com.example.practica5roompokemon.data.PokemonCatalogEntry
import com.example.practica5roompokemon.viewmodel.PokemonViewModel
import kotlin.math.roundToInt
import kotlin.random.Random

private fun resolvePokemonImageResId(
    context: Context,
    entry: PokemonCatalogEntry
): Int {
    val candidates = PokemonCatalog.getPossibleImageNames(entry)

    for (name in candidates) {
        val resId = context.resources.getIdentifier(name, "drawable", context.packageName)
        if (resId != 0) return resId
    }

    return 0
}

@Composable
fun CapturarScreen(viewModel: PokemonViewModel) {
    var name by rememberSaveable { mutableStateOf("") }

    val pokemonEntry = remember(name) {
        PokemonCatalog.findByName(name)
    }

    var encounterLevel by rememberSaveable(name) {
        mutableIntStateOf(
            pokemonEntry?.let { PokemonCatalog.generateLevel(it) } ?: 1
        )
    }

    var attempts by rememberSaveable(name) { mutableIntStateOf(0) }

    val captureChance = remember(pokemonEntry, encounterLevel, attempts) {
        pokemonEntry?.let {
            PokemonCatalog.calculateCaptureChance(
                rarity = it.rarity,
                level = encounterLevel,
                attempts = attempts
            )
        } ?: 0.0
    }

    val context = LocalContext.current
    val imageResId = remember(pokemonEntry) {
        pokemonEntry?.let { resolvePokemonImageResId(context, it) } ?: 0
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(28.dp)
            ) {
                androidx.compose.foundation.layout.Column(
                    modifier = Modifier.padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Text(
                        text = "Buscar Pokémon",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Escribe el nombre exacto para encontrarlo en tu Pokédex local.",
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Nombre del Pokémon") },
                        singleLine = true,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null
                            )
                        }
                    )

                    Button(
                        onClick = {
                            if (pokemonEntry == null) {
                                viewModel.showMessage("Ese Pokémon no está en la Pokédex local.")
                                return@Button
                            }

                            val success = Random.nextDouble() <= captureChance

                            if (success) {
                                viewModel.captureResolvedPokemon(pokemonEntry, encounterLevel)
                                name = ""
                                attempts = 0
                            } else {
                                attempts += 1
                                viewModel.showMessage("${pokemonEntry.name} escapó. Sigue lanzando Poké Balls.")
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        enabled = pokemonEntry != null
                    ) {
                        Icon(
                            imageVector = Icons.Default.CatchingPokemon,
                            contentDescription = null
                        )
                        Text("  Lanzar Poké Ball")
                    }
                }
            }
        }

        item {
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(28.dp)
            ) {
                if (pokemonEntry == null) {
                    androidx.compose.foundation.layout.Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(150.dp)
                                .background(
                                    MaterialTheme.colorScheme.surfaceVariant,
                                    RoundedCornerShape(24.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "?",
                                style = MaterialTheme.typography.displayMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        Text(
                            text = "Sin coincidencias",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Prueba con nombres como Pikachu, Charizard, Bulbasaur o Mew.",
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                } else {
                    androidx.compose.foundation.layout.Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        if (imageResId != 0) {
                            Image(
                                painter = painterResource(id = imageResId),
                                contentDescription = pokemonEntry.name,
                                modifier = Modifier.size(150.dp)
                            )
                        } else {
                            Box(
                                modifier = Modifier
                                    .size(150.dp)
                                    .background(
                                        MaterialTheme.colorScheme.surfaceVariant,
                                        RoundedCornerShape(24.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "#${pokemonEntry.dexNumber}",
                                    style = MaterialTheme.typography.headlineMedium,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        Text(
                            text = pokemonEntry.name,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Surface(
                                shape = RoundedCornerShape(50),
                                color = pokemonTypeColor(pokemonEntry.type).copy(alpha = 0.18f)
                            ) {
                                Text(
                                    text = pokemonEntry.type,
                                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                                    color = pokemonTypeColor(pokemonEntry.type),
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                            pokemonEntry.secondaryType?.let { secondType ->
                                Surface(
                                    shape = RoundedCornerShape(50),
                                    color = pokemonTypeColor(secondType).copy(alpha = 0.18f)
                                ) {
                                    Text(
                                        text = secondType,
                                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                                        color = pokemonTypeColor(secondType),
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                        }

                        ElevatedCard(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(22.dp)
                        ) {
                            androidx.compose.foundation.layout.Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(18.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(
                                    text = "Nivel salvaje: $encounterLevel",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )

                                Text(
                                    text = "Probabilidad de captura: ${(captureChance * 100).roundToInt()}%",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.Bold
                                )

                                Text(
                                    text = "Intentos: $attempts",
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}