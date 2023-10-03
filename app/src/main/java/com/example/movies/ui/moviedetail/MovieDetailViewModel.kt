package com.example.movies.ui.moviedetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.repository.MovieRepository
import com.example.movies.utlis.MOVIE_ID
import com.example.movies.utlis.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: MovieRepository,
) : ViewModel() {

    private val _movieDetail = mutableStateOf(MovieDetailUiState())
    val movieDetail: State<MovieDetailUiState> = _movieDetail

    init {
        viewModelScope.launch {
            val movieId = savedStateHandle.get<Int>(MOVIE_ID)
                ?: throw IllegalStateException("No movie_id was passed to destination.")
            getMovieDetails(movieId)
        }
    }

    private fun getMovieDetails(movieId: Int) {
        repository.getMovieDetail(movieId).map { result ->
            when (result) {
                is Result.Success -> _movieDetail.value =
                    MovieDetailUiState(movieDetails = result.data)
                is Result.Error -> _movieDetail.value =
                    MovieDetailUiState(errorMessage = result.exception.message.orEmpty())
                is Result.Loading -> MovieDetailUiState(isLoading = true)
            }
        }.launchIn(viewModelScope)
    }
}