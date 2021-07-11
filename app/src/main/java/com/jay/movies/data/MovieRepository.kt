package com.jay.movies.data

import com.jay.movies.model.Movie

interface MovieRepository {

    suspend fun getMovies(page: Int): List<Movie>

}