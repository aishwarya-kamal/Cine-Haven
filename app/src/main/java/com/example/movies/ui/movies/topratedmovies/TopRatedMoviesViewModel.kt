package com.example.movies.ui.movies.topratedmovies

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.repository.MovieRepository
import com.example.movies.ui.movies.common.MoviesUiState
import com.example.movies.utlis.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TopRatedMoviesViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
) : ViewModel() {

    private val _movies = mutableStateOf(MoviesUiState())
    val movies: State<MoviesUiState> = _movies

    init {
        getTopRatedMovies()
    }

    private fun getTopRatedMovies() {
        movieRepository.getMovies(topRated = true).onEach { movie ->
            when (movie) {
                is Result.Success -> _movies.value = MoviesUiState(movies = movie.data)
                is Result.Error -> _movies.value =
                    MoviesUiState(errorMessage = movie.exception.message.orEmpty())

                is Result.Loading -> Log.e("VM", "VM Loading")
            }
        }.launchIn(viewModelScope)
    }
}