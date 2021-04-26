package com.example.moviesapp.presentation.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviesapp.base.State
import com.example.moviesapp.data.model.remote.Movie
import com.example.moviesapp.domain.movies.MoviesUseCase
import kotlinx.coroutines.Dispatchers

class MoviesViewModel @ViewModelInject constructor(
    private val moviesUseCase : MoviesUseCase
) : ViewModel() {

    fun getPopularMovieList(apiKey : String) : LiveData<State<List<Movie>>> {

        return liveData(Dispatchers.IO) {
            emit(State.Loading())

            try {
                emit(moviesUseCase.getPopularMovies(apiKey))
            }catch (e : Exception) {
                emit(State.Failure(e))
            }

        }
    }

    fun getTopRatedMovies(apiKey: String) : LiveData<State<List<Movie>>> {

        return liveData(Dispatchers.IO) {
            emit(State.Loading())

            try {
                emit(moviesUseCase.getTopRatedMovies(apiKey))
            }catch (e : Exception) {
                emit(State.Failure(e))
            }

        }
    }





}