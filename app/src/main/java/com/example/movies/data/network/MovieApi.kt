package com.example.movies.data.network

import com.example.movies.data.response.MovieResponse
import com.example.movies.data.model.NetworkMovieDetail
//import com.example.movies.data.response.GenresResponse
import com.example.movies.utlis.API_KEY
import com.example.movies.utlis.DEFAULT_LANGUAGE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = DEFAULT_LANGUAGE,
    ): MovieResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = DEFAULT_LANGUAGE,
    ): MovieResponse

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = DEFAULT_LANGUAGE,
    ): MovieResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = DEFAULT_LANGUAGE,
    ): NetworkMovieDetail

//    @GET("genre/movie/list")
//    suspend fun getMovieGenres(
//        @Query("api_key") apiKey: String = API_KEY,
//        @Query("language") language: String = DEFAULT_LANGUAGE
//    ): GenresResponse
}