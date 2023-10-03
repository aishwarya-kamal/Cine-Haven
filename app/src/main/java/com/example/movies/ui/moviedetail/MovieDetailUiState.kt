package com.example.movies.ui.moviedetail

import com.example.movies.model.MovieDetail

data class MovieDetailUiState(
    val movieDetails: MovieDetail? = null,
    val isLoading: Boolean = false,
    val errorMessage: String = ""
)