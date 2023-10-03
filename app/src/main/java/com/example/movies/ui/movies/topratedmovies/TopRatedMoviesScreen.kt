package com.example.movies.ui.movies.topratedmovies

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movies.model.Movie
import com.example.movies.ui.movies.common.MoviesScreenContent
import com.example.movies.ui.movies.common.MoviesUiState

@Composable
fun TopRatedMoviesScreen(
    modifier: Modifier = Modifier,
    viewModel: TopRatedMoviesViewModel = hiltViewModel(),
    onMovieClicked: (Movie) -> Unit,
) {
    val uiState: MoviesUiState by viewModel.movies
    MoviesScreenContent(modifier = modifier, movies = uiState.movies, onMovieClicked = onMovieClicked)
}
