package com.example.movies.ui.navigation

import com.example.movies.ui.navigation.DestinationConstants.MOVIES
import com.example.movies.ui.navigation.DestinationConstants.MOVIE_DETAILS
import com.example.movies.utlis.MOVIE_ID

sealed class Screen(val route: String) {
    object Movies: Screen(route = MOVIES)
    object MovieDetails: Screen(route = "$MOVIE_DETAILS/{$MOVIE_ID}")
}

internal object DestinationConstants {
    const val MOVIES = "movies_screen"
    const val MOVIE_DETAILS = "movie_details_screen"
}