package com.example.practicalementosdinamicos_coronadoluis.model

import com.example.practicalementosdinamicos_coronadoluis.R

data class Film(
    val id: Int,
    val title: String,
    val description: String,
    val synopsis: String,
    val duration: String,
    val actors: String,
    val year: Int,
    val imageRes: Int = 0
)

val sampleFilms = listOf(
    Film(
        id = 1,
        title = "Titanic",
        description = "Romantic movie",
        synopsis = "Jack y Rose se conocen a bordo del Titanic y viven una historia de amor marcada por la tragedia.",
        duration = "3h 14m",
        actors = "Leonardo DiCaprio, Kate Winslet",
        year = 1997,
        imageRes = R.drawable.titanic
    ),
    Film(
        id = 2,
        title = "Avengers",
        description = "Action movie",
        synopsis = "Los héroes más poderosos de la Tierra se unen para detener una amenaza que pone en riesgo al planeta.",
        duration = "2h 23m",
        actors = "Robert Downey Jr., Chris Evans, Scarlett Johansson",
        year = 2012,
        imageRes = R.drawable.avengers
    ),
    Film(
        id = 3,
        title = "Dune",
        description = "SiFi movie",
        synopsis = "Paul Atreides viaja a Arrakis y debe enfrentar conflictos políticos, familiares y personales.",
        duration = "2h 35m",
        actors = "Timothée Chalamet, Zendaya, Rebecca Ferguson",
        year = 2021,
        imageRes = R.drawable.dune
    ),
    Film(
        id = 4,
        title = "Avatar",
        description = "SiFi movie",
        synopsis = "Jake Sully llega a Pandora y se involucra con los Na'vi mientras descubre los intereses ocultos de la misión humana.",
        duration = "2h 42m",
        actors = "Sam Worthington, Zoe Saldaña, Sigourney Weaver",
        year = 2009,
        imageRes = R.drawable.avatar
    ),
    Film(
        id = 5,
        title = "The Batman",
        description = "Thriller movie",
        synopsis = "Batman investiga una serie de crímenes que revelan corrupción dentro de Gotham.",
        duration = "2h 56m",
        actors = "Robert Pattinson, Zoë Kravitz, Paul Dano",
        year = 2022,
        imageRes = R.drawable.thebatman
    ),
    Film(
        id = 6,
        title = "Harry Potter and the prisoner of Azkaban",
        description = "Fantasy movie",
        synopsis = "Harry regresa a Hogwarts mientras una nueva amenaza relacionada con Sirius Black lo acecha.",
        duration = "2h 22m",
        actors = "Daniel Radcliffe, Emma Watson, Rupert Grint",
        year = 2004,
        imageRes = R.drawable.harrypotter
    ),
    Film(
        id = 7,
        title = "Star Wars episode VIII",
        description = "SiFi movie",
        synopsis = "La Resistencia lucha por sobrevivir mientras Rey desarrolla su entrenamiento con Luke Skywalker.",
        duration = "2h 32m",
        actors = "Daisy Ridley, Mark Hamill, Adam Driver",
        year = 2017,
        imageRes = R.drawable.starwarsviii
    )
)

fun getFilmById(id: Int): Film? {
    return sampleFilms.find { it.id == id }
}