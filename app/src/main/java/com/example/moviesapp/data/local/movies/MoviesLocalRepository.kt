package com.example.moviesapp.data.local.movies

import com.example.moviesapp.data.model.remote.Movie

interface MoviesLocalRepository {

    suspend fun getPopularMovies() : List<Movie>

    suspend fun getTopRatedMovies() : List<Movie>
}