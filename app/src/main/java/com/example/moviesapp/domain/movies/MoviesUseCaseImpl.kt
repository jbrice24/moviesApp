package com.example.moviesapp.domain.movies

import android.util.Log
import com.example.moviesapp.base.State
import com.example.moviesapp.data.local.mapper.MoviesMapper
import com.example.moviesapp.data.model.remote.Movie
import com.example.moviesapp.data.repository.remote.movies.MoviesRemoteRepository
import javax.inject.Inject

class MoviesUseCaseImpl @Inject constructor(
    private val remoteRepository: MoviesRemoteRepository,
    private val mapper: MoviesMapper
) : MoviesUseCase {

    override suspend fun getPopularMovies(apiKey: String): State<List<Movie>> {
        val dbList = mapper.getPopularMappedMovies()

        Log.d("dbListsize P" , dbList.size.toString())

        return if(dbList.isNotEmpty())
            State.Success(dbList)
        else {
            val response = remoteRepository.getPopularMovies(apiKey)
            mapper.mapMoviesToPopularMovies(response)
            State.Success(response)
        }
    }

    override suspend fun getTopRatedMovies(apiKey: String): State<List<Movie>> {
        val dbList = mapper.getTopRatedMappedMovies()

        Log.d("dbListsize T" , dbList.size.toString())

        return if(dbList.isNotEmpty())
            State.Success(dbList)
        else {
            val response = remoteRepository.getTopRatedMovies(apiKey)
            mapper.mapMoviesToTopRatedMovies(response)
            State.Success(response)
        }
    }
}