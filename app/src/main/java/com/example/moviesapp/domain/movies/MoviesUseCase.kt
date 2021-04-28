package com.example.moviesapp.domain.movies

import com.example.moviesapp.base.State
import com.example.moviesapp.data.model.remote.Movie
import io.reactivex.Observable


interface MoviesUseCase {

    suspend fun getPopularMovies(apiKey : String) : State<List<Movie>>

    suspend fun getTopRatedMovies(apiKey: String) : State<List<Movie>>

    fun getPopularMoviesRX(apiKey : String) : Observable<List<Movie>>

    fun getTopRatedMoviesRX(apiKey: String) : Observable<List<Movie>>

}