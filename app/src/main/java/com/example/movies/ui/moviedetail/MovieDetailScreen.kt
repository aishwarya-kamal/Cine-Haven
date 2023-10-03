package com.example.movies.ui.moviedetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movies.R
import com.example.movies.model.MovieDetail
import com.example.movies.utlis.POSTER_BASE_URL

@Composable
fun MovieDetailScreen(
    movieId: Int,
    modifier: Modifier = Modifier,
    viewModel: MovieDetailViewModel = hiltViewModel()
) {
    val uiState: MovieDetailUiState by viewModel.movieDetail
    MovieDetails(modifier = modifier, movieDetail = uiState.movieDetails)

    if (uiState.errorMessage.isNotBlank()) {
        Text(
            text = uiState.errorMessage,
            color = MaterialTheme.colorScheme.error,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
    }
}

@Composable
fun MovieDetails(
    modifier: Modifier = Modifier,
    movieDetail: MovieDetail?,
) {
    Card(
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
    ) {

        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                contentScale = ContentScale.Crop,
                model = ImageRequest.Builder(LocalContext.current)
                    .data(POSTER_BASE_URL + movieDetail?.posterPath)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
            )

            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = movieDetail?.title.orEmpty(),
                style = MaterialTheme.typography.headlineMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                modifier = Modifier.padding(8.dp),
                text = movieDetail?.overview.orEmpty(),
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMovieDetails() {
    MovieDetails(
        movieDetail = MovieDetail("en", "This is Overview", ".jpg", "Mission Impossible", 500)
    )
}