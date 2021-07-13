package com.jay.movies.ui.home

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.jay.movies.data.MovieRepository
import com.jay.movies.model.Movie

class MoviePagingSource(
    private val movieRepository: MovieRepository,
) : PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPage = params.key ?: 1
            val movies = movieRepository.getMovies(nextPage)

            LoadResult.Page(
                data = movies,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}