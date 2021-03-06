package com.jay.movies.api.response

import com.google.gson.annotations.SerializedName
import com.jay.movies.model.Movie

data class GetMoviesResponse(
    @SerializedName("results")
    val results: List<MovieResponse> = emptyList(),
    @SerializedName("total_pages")
    val totalPages: Int = 0,
) {
    data class MovieResponse(
        @SerializedName("id")
        val id: Int,
        @SerializedName("poster_path")
        val posterPath: String? = "",
        @SerializedName("adult")
        val adult: Boolean = false,
        @SerializedName("overview")
        val overview: String = "",
        @SerializedName("release_date")
        val releaseDate: String? = "",
        @SerializedName("genre_ids")
        val genreIds: List<Int> = emptyList(),
        @SerializedName("original_title")
        val originalTitle: String = "",
        @SerializedName("original_language")
        val originalLanguage: String = "",
        @SerializedName("title")
        val title: String = "",
        @SerializedName("backdrop_path")
        val backdropPath: String? = "",
        @SerializedName("popularity")
        val popularity: Float = 0f,
        @SerializedName("vote_count")
        val voteCount: Int = 0,
        @SerializedName("video")
        val video: Boolean = false,
        @SerializedName("vote_average")
        val voteAverage: Float = 0f,
    )
}

private const val BASE_BACKDROP_PATH = "https://image.tmdb.org/t/p/w780"

fun GetMoviesResponse.MovieResponse.toUiModel() =
    Movie(
        id = this.id,
        title = this.title,
        imageUrl = "$BASE_BACKDROP_PATH${this.posterPath}",
    )