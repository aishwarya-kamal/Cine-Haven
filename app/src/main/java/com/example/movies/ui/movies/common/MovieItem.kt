package com.example.movies.ui.movies.common

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movies.R
import com.example.movies.model.Movie
import com.example.movies.utlis.POSTER_BASE_URL

@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    movie: Movie,
    onItemClick: (Movie) -> Unit,
) {
    OutlinedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 2.dp, bottom = 2.dp)
            .clickable { onItemClick(movie) },
        shape = RoundedCornerShape(3.dp),
        border = BorderStroke(0.2.dp, Color.Black),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp),
                placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                contentScale = ContentScale.Crop,
                model = ImageRequest.Builder(LocalContext.current)
                    .data(POSTER_BASE_URL + movie.posterPath)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
            )
//            Column {
//                Text(
//                    modifier = Modifier.padding(horizontal = 8.dp),
//                    text = movie.title,
//                    style = MaterialTheme.typography.headlineMedium,
//                    maxLines = 2,
//                    overflow = TextOverflow.Ellipsis,
//                )
//                Row {
//                    Text(
//                        modifier = Modifier.padding(start = 8.dp),
//                        text = movie.voteAverage.toString(),
//                        style = MaterialTheme.typography.bodyLarge,
//                        overflow = TextOverflow.Ellipsis,
//                    )
//                    Image(painterResource(id = R.drawable.ic_star), contentDescription = null)
//                }
//            }
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MovieItemPreview() {
    MovieItem(
        movie = Movie(1, ".jpg"),
        onItemClick = {}
    )
}