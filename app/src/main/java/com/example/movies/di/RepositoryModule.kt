package com.example.movies.di

import com.example.movies.data.network.MovieApi
import com.example.movies.data.repository.DefaultMovieRepository
import com.example.movies.data.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieApi: MovieApi,
    ): MovieRepository {
        return DefaultMovieRepository(
            movieApi = movieApi,
        )
    }
}