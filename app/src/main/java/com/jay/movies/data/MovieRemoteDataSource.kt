package com.jay.movies.data

import com.jay.movies.api.response.GetMoviesResponse

interface MovieRemoteDataSource {

    suspend fun getMovies(page: Int): List<GetMoviesResponse.MovieResponse>

}