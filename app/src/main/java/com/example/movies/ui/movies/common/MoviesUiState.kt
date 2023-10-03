package com.example.movies.ui.movies.common

import com.example.movies.model.Movie

data class MoviesUiState(
    val movies: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String = "",
)
