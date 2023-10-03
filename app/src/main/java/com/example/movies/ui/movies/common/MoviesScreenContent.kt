package com.example.movies.ui.movies.common

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movies.model.Movie
import com.example.movies.ui.theme.MoviesTheme

@Composable
internal fun MoviesScreenContent(
    modifier: Modifier = Modifier,
    movies: List<Movie>,
    onMovieClicked: (Movie) -> Unit,
) {
    LazyVerticalGrid(
        modifier = modifier.padding(top = 4.dp, end = 4.dp),
        columns = GridCells.Fixed(2),
    ) {
        items(movies) { movie ->
            MovieItem(movie = movie, onItemClick = onMovieClicked)
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MoviesScreenContentPreview() {
    MoviesTheme {
        MoviesScreenContent(
            modifier = Modifier,
            movies = listOf(
                Movie(
                    1,
                    ".jpg"
                ),
                Movie(
                    2,
                    ".jpg"
                ),
                Movie(
                    3,
                    ".jpg"
                ),
            ),
            onMovieClicked = {}
        )
    }
}