package com.jay.movies.data

import com.jay.movies.api.ApiService
import com.jay.movies.api.response.GetMoviesResponse
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

class MovieRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : MovieRemoteDataSource {

    override suspend fun getMovies(page: Int): List<GetMoviesResponse.MovieResponse> {
        return apiService.getMovies(page).results
    }

}

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieRemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindMovieRemoteDataSource(
        movieRemoteDataSourceImpl: MovieRemoteDataSourceImpl
    ): MovieRemoteDataSource

}