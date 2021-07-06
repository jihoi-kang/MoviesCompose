package com.jay.movies.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.jay.movies.data.DataProvider
import com.jay.movies.model.Movie

@Composable
fun Home(selectMovie: (Movie) -> Unit) {
    val movies = remember { DataProvider.movies }
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
