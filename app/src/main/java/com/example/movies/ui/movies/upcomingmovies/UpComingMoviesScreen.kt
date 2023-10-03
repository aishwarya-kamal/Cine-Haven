package com.example.movies.ui.movies.upcomingmovies

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movies.model.Movie
import com.example.movies.ui.movies.common.MoviesScreenContent
import com.example.movies.ui.movies.common.MoviesUiState

@Composable
fun UpComingMoviesScreen(
    modifier: Modifier = Modifier,
    viewModel: UpComingMoviesViewModel = hiltViewModel(),
    onMovieClicked: (Movie) -> Unit,
) {
    val uiState: MoviesUiState by viewModel.movies
    MoviesScreenContent(modifier = modifier, movies = uiState.movies, onMovieClicked = onMovieClicked)
}
