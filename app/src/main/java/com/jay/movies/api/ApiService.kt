package com.jay.movies.api

import com.jay.movies.api.response.GetMovieResponse
import com.jay.movies.api.response.GetMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.text.SimpleDateFormat
import java.util.*

interface ApiService {

    @GET("/3/discover/movie")
    suspend fun getMovies(
        @Query("page") page: Int,
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("release_date.lte") today: String = SimpleDateFormat("yyyy-MM-dd").format(Date()),
    ): GetMoviesResponse

    @GET("/3/movie/{movieId}")
    suspend fun getMovie(
        @Path("movieId") movieId: String,
    ): GetMovieResponse

}