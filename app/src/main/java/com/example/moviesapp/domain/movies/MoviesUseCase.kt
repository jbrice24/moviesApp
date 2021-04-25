package com.example.moviesapp.domain.movies

import com.example.moviesapp.base.State
import com.example.moviesapp.data.model.remote.Movie


interface MoviesUseCase {

    suspend fun getPopularMovies(apiKey : String) : State<List<Movie>>

    suspend fun getTopRatedMovies(apiKey: String) : State<List<Movie>>
}