package com.example.movies.data.repository

import com.example.movies.data.model.toMovie
import com.example.movies.data.model.toMovieDetail
import com.example.movies.data.network.MovieApi
import com.example.movies.model.Movie
import com.example.movies.model.MovieDetail
import com.example.movies.utlis.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DefaultMovieRepository @Inject constructor(
    private val movieApi: MovieApi,
) : MovieRepository {

    override fun getMovies(
        popular: Boolean,
        topRated: Boolean,
        upcoming: Boolean
    ): Flow<Result<List<Movie>>> = flow {
        emit(Result.Loading)
        try {
            val networkMovies = if (popular) {
                movieApi.getPopularMovies().results
            } else if (topRated) {
                movieApi.getTopRatedMovies().results
            } else {
                movieApi.getUpcomingMovies().results
            }
            val movies = networkMovies.map { networkMovie ->
                networkMovie.toMovie()
            }
            emit(Result.Success(movies))
        } catch (exception: IllegalStateException) {
            emit(Result.Error(exception))
        } catch (exception: IOException) {
            emit(Result.Error(exception))
        } catch (exception: HttpException) {
            emit(Result.Error(exception))
        }
    }

    override fun getMovieDetail(movieId: Int): Flow<Result<MovieDetail>> = flow {
        emit(Result.Loading)
        try {
            val movieDetail = movieApi.getMovieDetail(movieId).toMovieDetail()
            emit(Result.Success(movieDetail))
        } catch (exception: IOException) {
            emit(Result.Error(exception))
        }
    }

//    override suspend fun getMovieGenres(): List<Genre> {
//        return movieApi.getMovieGenres().genres
//    }

}