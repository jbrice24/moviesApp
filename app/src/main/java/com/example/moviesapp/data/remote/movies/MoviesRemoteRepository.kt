package com.example.moviesapp.data.repository.remote.movies

import com.example.moviesapp.data.model.remote.Movie

interface MoviesRemoteRepository {

    suspend fun getPopularMovies(apiKey : String) : List<Movie>

    suspend fun getTopRatedMovies(apiKey: String) : List<Movie>

}