package com.jay.movies.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import com.jay.movies.model.Movie
import com.jay.movies.ui.MainViewModel

@Composable
fun Home(
    viewModel: MainViewModel,
    selectMovie: (Movie) -> Unit,
) {
    val movies: List<Movie> by viewModel.movieItems.observeAsState(listOf())

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = movies,
            itemContent = {
                MovieItem(
                    movie = it,
                    selectMovie = selectMovie,
                )
            }
        )
    }
}
