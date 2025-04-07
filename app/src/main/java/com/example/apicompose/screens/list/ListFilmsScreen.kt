package com.example.apicompose.screens.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.example.apicompose.domain.Film

@Composable
fun ListFilmsScreen(
    modifier: Modifier = Modifier,
    onNavToInfScreen: (Long) -> Unit,
    viewModel: ListFilmsViewModel = hiltViewModel(),
) {
    val films by viewModel.films.collectAsState()

    LazyColumn(modifier) {
        films?.also {
            items(it) { film ->
                FilmItem(film, { onNavToInfScreen(it.id) })
            }
        }
    }
}

@Composable
fun FilmItem(
    film: Film,
    onItemClick: (Film) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .clickable { onItemClick(film) }
            .padding(10.dp)
    ) {
        Row(
            verticalAlignment = CenterVertically,
            modifier = Modifier.height(IntrinsicSize.Min)
        ) {
            AsyncImage(
                model = film.posterUrl,
                contentDescription = null
            )
            VerticalDivider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Column {
                Text(
                    text = film.name,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .weight(1f)
                )
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(1.dp)
                )
                Text(
                    text = film.description,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .weight(1f),
                    maxLines = 1
                )
            }
        }
    }
}