package com.example.practicalementosdinamicos_coronadoluis.model

import com.example.practicalementosdinamicos_coronadoluis.R

data class Film(
    val id: Int,
    val title: String,
    val description: String,
    val imageRes: Int = 0
)

val sampleFilms = listOf(
    Film(id = 1, title = "Titanic", description = "Romantic movie", imageRes = R.drawable.titanic),
    Film(id = 2, title = "Avengers", description = "Action movie", imageRes = R.drawable.avengers),
    Film(id = 3, title = "Dune", description = "SiFi movie", imageRes = R.drawable.dune),
    Film(id = 4, title = "Avatar", description = "SiFi movie", imageRes = R.drawable.avatar),
    Film(id = 5, title = "The Batman", description = "Thriller movie", imageRes = R.drawable.thebatman),
    Film(id = 6, title = "Harry Potter and the prisoner of Azkaban", description = "Fantasy movie", imageRes = R.drawable.harrypotter),
    Film(id = 7, title = "Star Wars episode VIII", description = "SiFi movie", imageRes = R.drawable.starwarsviii)
)