package com.example.movies.data.repository

import com.example.movies.model.Movie
import com.example.movies.model.MovieDetail
import com.example.movies.utlis.Result
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovies(popular: Boolean = false, topRated: Boolean = false, upcoming: Boolean = false): Flow<Result<List<Movie>>>
    fun getMovieDetail(movieId: Int): Flow<Result<MovieDetail>>
//    suspend fun getMovieGenres(): List<Genre>
}