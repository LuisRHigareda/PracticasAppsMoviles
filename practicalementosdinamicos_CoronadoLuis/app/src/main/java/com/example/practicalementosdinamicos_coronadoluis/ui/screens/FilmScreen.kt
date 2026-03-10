package com.example.practicalementosdinamicos_coronadoluis.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalementosdinamicos_coronadoluis.model.sampleFilms
import com.example.practicalementosdinamicos_coronadoluis.ui.components.FilmCard
import com.example.practicalementosdinamicos_coronadoluis.ui.theme.Practicalementosdinamicos_CoronadoLuisTheme

@Composable
fun FilmScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Listado de películas",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(sampleFilms) { film ->
                FilmCard(film = film)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilmsScreenPreview() {
    Practicalementosdinamicos_CoronadoLuisTheme {
        FilmScreen()
    }
}