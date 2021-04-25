package com.example.moviesapp.data.local.mapper

import com.example.moviesapp.data.model.remote.Movie

interface MoviesMapper {

    suspend fun mapMoviesToPopularMovies(movieList: List<Movie>)
    suspend fun mapMoviesToTopRatedMovies(movieList: List<Movie>)
    suspend fun getPopularMappedMovies() : List<Movie>
    suspend fun getTopRatedMappedMovies(): List<Movie>

}