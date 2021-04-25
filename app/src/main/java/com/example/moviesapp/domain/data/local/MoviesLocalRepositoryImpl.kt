package com.example.moviesapp.domain.data.local

import com.example.moviesapp.data.local.mapper.MoviesMapper
import com.example.moviesapp.data.local.movies.MoviesLocalRepository
import com.example.moviesapp.data.model.remote.Movie
import javax.inject.Inject

class MoviesLocalRepositoryImpl
    @Inject constructor(
        private val mapper : MoviesMapper
    )
 :MoviesLocalRepository {

    override suspend fun getPopularMovies():List<Movie> =
        mapper.getPopularMappedMovies()

    override suspend fun getTopRatedMovies(): List<Movie> =
        mapper.getTopRatedMappedMovies()


}