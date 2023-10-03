package com.example.movies.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.movies.ui.moviedetail.MovieDetailScreen
import com.example.movies.ui.movies.popularmovies.MoviesScreen
import com.example.movies.ui.movies.topratedmovies.TopRatedMoviesScreen
import com.example.movies.ui.movies.upcomingmovies.UpComingMoviesScreen
import com.example.movies.utlis.MOVIE_ID

@Composable
fun MovieNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Movies.route,
    ) {
        composable(route = Screen.Movies.route) {
            MoviesScreen { movie ->
                navController.navigate(route = "movie_details_screen/${movie.id}")
            }
        }

        composable(
            route = Screen.MovieDetails.route,
            arguments = listOf(navArgument(MOVIE_ID) {
                type = NavType.IntType
            }),
        ) {
            val movieId = it.arguments?.getInt(MOVIE_ID)
            MovieDetailScreen(movieId = movieId ?: 1)
        }

        composable(route = BottomBarTab.Popular.route) {
            MoviesScreen { movie ->
                navController.navigate(route = "movie_details_screen/${movie.id}")
            }
        }
        composable(route = BottomBarTab.TopRated.route) {
            TopRatedMoviesScreen { movie ->
                navController.navigate(route = "movie_details_screen/${movie.id}")
            }
        }
        composable(route = BottomBarTab.Upcoming.route) {
            UpComingMoviesScreen { movie ->
                navController.navigate(route = "movie_details_screen/${movie.id}")
            }
        }
    }
}