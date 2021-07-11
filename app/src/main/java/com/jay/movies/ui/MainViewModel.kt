package com.jay.movies.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jay.movies.data.MovieRepository
import com.jay.movies.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
) : ViewModel() {

    private val _movieItems = MutableLiveData<List<Movie>>()
    val movieItems: LiveData<List<Movie>> = _movieItems

    private var page = 1

    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {
            val movies = movieRepository.getMovies(page)
            _movieItems.value = movies
            page += 1
        }
    }

}