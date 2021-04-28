package com.example.moviesapp.data.repository.remote.movies

import com.example.moviesapp.base.PayLoad
import com.example.moviesapp.data.model.remote.Movie
import com.example.moviesapp.data.repository.remote.retrofit.RetrofitClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MoviesRemoteRepositoryImpl : MoviesRemoteRepository {

    override suspend fun getPopularMovies(apiKey : String): List<Movie> =
        RetrofitClient.remoteClient.callPopularMovies(apiKey).results

    override suspend fun getTopRatedMovies(apiKey : String): List<Movie> =
        RetrofitClient.remoteClient.callTopRatedMovies(apiKey).results

    override fun getPopularMoviesRX(apiKey: String): Observable<List<Movie>> {

        return RetrofitClient.remoteClient
            .callPopularMoviesRX(apiKey)
            .map {
                return@map it.results
            }
    }

    override fun getTopRatedMoviesRX(apiKey: String): Observable<List<Movie>> {
        TODO("Not yet implemented")
    }
}