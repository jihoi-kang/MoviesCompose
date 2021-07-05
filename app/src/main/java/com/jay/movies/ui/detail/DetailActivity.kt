package com.jay.movies.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.jay.movies.model.Movie
import com.jay.movies.ui.theme.MoviesComposeTheme

class DetailActivity : ComponentActivity() {

    private val movie: Movie? by lazy {
        intent?.getParcelableExtra(EXTRA_MOVIE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesComposeTheme {
                Text(text = "Hello ${movie?.title}!")
            }
        }
    }

    companion object {
        private const val EXTRA_MOVIE = "EXTRA_MOVIE"

        fun getIntent(
            context: Context,
            movie: Movie
        ) = Intent(context, DetailActivity::class.java).apply {
            putExtra(EXTRA_MOVIE, movie)
        }
    }

}