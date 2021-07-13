package com.jay.movies.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.jay.movies.model.Movie
import com.jay.movies.ui.MainViewModel

@Composable
fun Home(
    viewModel: MainViewModel,
    selectMovie: (Movie) -> Unit,
) {
    val movies = viewModel.movies.collectAsLazyPagingItems()

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(movies) { movie ->
            MovieItem(movie = movie!!, selectMovie = selectMovie)
            Divider()
        }
    }
}
