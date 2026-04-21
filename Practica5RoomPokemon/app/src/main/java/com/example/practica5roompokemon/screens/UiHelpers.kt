package com.example.practica5roompokemon.screens

import androidx.compose.ui.graphics.Color

val PokemonTypes = listOf(
    "Agua", "Bicho", "Dragón", "Eléctrico", "Fantasma",
    "Fuego", "Hada", "Hielo", "Lucha", "Normal",
    "Planta", "Psíquico", "Roca", "Siniestro",
    "Tierra", "Veneno", "Volador"
)

fun pokemonTypeColor(type: String): Color {
    return when (type.lowercase()) {
        "agua" -> Color(0xFF0EA5E9)
        "bicho" -> Color(0xFF84CC16)
        "dragón" -> Color(0xFF7C3AED)
        "eléctrico" -> Color(0xFFFACC15)
        "fantasma" -> Color(0xFF6366F1)
        "fuego" -> Color(0xFFEF4444)
        "hada" -> Color(0xFFF472B6)
        "hielo" -> Color(0xFF67E8F9)
        "lucha" -> Color(0xFFB91C1C)
        "normal" -> Color(0xFF94A3B8)
        "planta" -> Color(0xFF22C55E)
        "psíquico" -> Color(0xFFEC4899)
        "roca" -> Color(0xFFA16207)
        "siniestro" -> Color(0xFF334155)
        "tierra" -> Color(0xFFD97706)
        "veneno" -> Color(0xFFA855F7)
        "volador" -> Color(0xFF60A5FA)
        else -> Color(0xFF64748B)
    }
}