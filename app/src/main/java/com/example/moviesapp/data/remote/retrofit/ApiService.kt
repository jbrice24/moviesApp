package com.example.moviesapp.data.repository.remote.retrofit

import com.example.moviesapp.base.PayLoad
import com.example.moviesapp.data.model.remote.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("popular")
    suspend fun callPopularMovies(@Query("api_key") apiKey : String)
            : PayLoad<List<Movie>>

    @GET("top_rated")
    suspend fun callTopRatedMovies(@Query("api_key") apiKey : String)
            : PayLoad<List<Movie>>

}