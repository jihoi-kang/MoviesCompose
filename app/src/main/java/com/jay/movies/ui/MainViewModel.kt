package com.jay.movies.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jay.movies.api.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiService: ApiService,
) : ViewModel() {

    fun get() {
        viewModelScope.launch {
            val movies = apiService.getMovies("Popularity", 1)

            movies.results.map {
                Log.d("jay", "title: ${it.title}")
            }
        }
    }

}