package com.jay.movies.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.jay.movies.data.DataProvider
import com.jay.movies.model.Movie
import com.jay.movies.ui.MovieItem
import com.jay.movies.ui.detail.DetailActivity
import com.jay.movies.ui.theme.MoviesComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesComposeTheme {
                MyApp {
                    Log.d("jay", "${it.title} clicked!")
                    startActivity(DetailActivity.getIntent(this, it))
                }
            }
        }
    }
}

@Composable
fun MyApp(navigationToDetail: (Movie) -> Unit) {
    Scaffold(
        content = {
            MainContent(navigationToDetail)
        }
    )
}

@Composable
fun MainContent(navigationToDetail: (Movie) -> Unit) {
    val movies = remember { DataProvider.movies }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = movies,
            itemContent = {
                MovieItem(
                    movie = it,
                    navigationToDetail = navigationToDetail,
                )
            }
        )
    }
}