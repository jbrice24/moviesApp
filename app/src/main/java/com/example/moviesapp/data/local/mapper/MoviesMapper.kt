package com.example.moviesapp.data.local.mapper

import com.example.moviesapp.data.model.remote.Movie
import io.reactivex.Flowable
import io.reactivex.Observable

interface MoviesMapper {

    suspend fun mapMoviesToPopularMovies(movieList: List<Movie>)
    suspend fun mapMoviesToTopRatedMovies(movieList: List<Movie>)
    suspend fun getPopularMappedMovies() : List<Movie>
    suspend fun getTopRatedMappedMovies(): List<Movie>

    fun mapMoviesToPopularMoviesRX(movieList: List<Movie>)
    fun getPopularMappedMoviesRX() : Observable<List<Movie>>

}