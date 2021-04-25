package com.example.moviesapp.data.repository.remote.movies

import com.example.moviesapp.data.model.remote.Movie
import com.example.moviesapp.data.repository.remote.retrofit.RetrofitClient

class MoviesRemoteRepositoryImpl : MoviesRemoteRepository {

    override suspend fun getPopularMovies(apiKey : String): List<Movie> =
        RetrofitClient.remoteClient.callPopularMovies(apiKey).results

    override suspend fun getTopRatedMovies(apiKey : String): List<Movie> =
        RetrofitClient.remoteClient.callTopRatedMovies(apiKey).results

}