package com.example.movies.ui.movies.popularmovies

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
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
) : ViewModel() {

    private val _movies = mutableStateOf(MoviesUiState())
    val movies: State<MoviesUiState> = _movies

    init {
        getPopularMovies()
    }

    private fun getPopularMovies() {
        movieRepository.getMovies(popular = true).onEach { movie ->
            when (movie) {
                is Result.Success -> _movies.value = MoviesUiState(movies = movie.data)
                is Result.Error -> _movies.value =
                    MoviesUiState(errorMessage = movie.exception.message.orEmpty())

                is Result.Loading -> Timber.v("PopularVM Loading...")
            }
        }.launchIn(viewModelScope)
    }
}