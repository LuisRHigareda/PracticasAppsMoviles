package com.example.practicalementosdinamicos_coronadoluis.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalementosdinamicos_coronadoluis.R
import com.example.practicalementosdinamicos_coronadoluis.model.Film
import com.example.practicalementosdinamicos_coronadoluis.ui.theme.Practicalementosdinamicos_CoronadoLuisTheme

@Composable
fun FilmCard(
    film: Film,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = film.imageRes),
                contentDescription = film.title,
                modifier = Modifier
                    .size(width = 55.dp, height = 75.dp)
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = film.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = film.description,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilmCardPreview() {
    Practicalementosdinamicos_CoronadoLuisTheme {
        FilmCard(
            film = Film(
                id = 1,
                title = "Titanic",
                description = "Romantic movie",
                synopsis = "Jack y Rose se conocen a bordo del Titanic.",
                duration = "3h 14m",
                actors = "Leonardo DiCaprio, Kate Winslet",
                year = 1997,
                imageRes = R.drawable.titanic
            )
        )
    }
}