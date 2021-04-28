package com.example.moviesapp.data.repository.remote.movies

import com.example.moviesapp.data.model.remote.Movie
import io.reactivex.Observable

interface MoviesRemoteRepository {

    suspend fun getPopularMovies(apiKey : String) : List<Movie>

    suspend fun getTopRatedMovies(apiKey: String) : List<Movie>

    fun getPopularMoviesRX(apiKey : String) : Observable<List<Movie>>

    fun getTopRatedMoviesRX(apiKey: String) : Observable<List<Movie>>

}