package com.example.apicompose.screens.information

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage

@Composable
fun InformationScreen(
    modifier: Modifier = Modifier,
    id: Long,
    viewModel: InformationScreenViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.getFilmById(id)
    }

    val film by viewModel.film.collectAsState(null)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        film?.let {
            Poster(it.poster.url)
            Name(it.name)
            Year(it.year)
            Description(it.description)
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                AgeRating(it.ageRating)
                FilmLength(it.filmLength)
                Type(it.type)
            }
        }
    }
}

@Composable
fun Poster(
    poster: String,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = poster,
        contentDescription = null
    )
}

@Composable
fun Name(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        name,
        modifier.padding(vertical = 6.dp),
        fontSize = 30.sp
    )
}

@Composable
fun Description(
    description: String,
    modifier: Modifier = Modifier
) {
    Text(
        description,
        modifier.padding(start = 6.dp, bottom = 8.dp)
    )
}

@Composable
fun Year(
    year: Int,
    modifier: Modifier = Modifier
) {
    Text("Year: $year")
}

@Composable
fun Type(
    type: String,
    modifier: Modifier = Modifier
) {
    Text("Type: $type")
}

@Composable
fun FilmLength(
    filmLength: Int,
    modifier: Modifier = Modifier
) {
    Text("Film length: $filmLength")
}

@Composable
fun AgeRating(
    age: Int,
    modifier: Modifier = Modifier
) {
    Text("Age rating: $age")
}