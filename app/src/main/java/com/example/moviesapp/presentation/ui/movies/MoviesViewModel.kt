package com.example.moviesapp.presentation.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.base.State
import com.example.moviesapp.data.model.remote.Movie
import com.example.moviesapp.domain.movies.MoviesUseCase
import com.example.moviesapp.domain.movies.MoviesUseCaseImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.reflect.Constructor
import javax.inject.Inject

class MoviesViewModel @ViewModelInject constructor(
    private val moviesUseCase : MoviesUseCase
) : ViewModel() {

    private val apiKey = "2276cd1681047a01ba1b6426de8b7230"

    val fetchPopularMoviesList = liveData(Dispatchers.IO) {
            emit(State.Loading())

            try {
                emit(moviesUseCase.getPopularMovies(apiKey))
            }catch (e : Exception) {
                emit(State.Failure(e))
            }

        }

    val fetchTopRatedMoviesList = liveData(Dispatchers.IO) {
        emit(State.Loading())

        try {
            emit(moviesUseCase.getTopRatedMovies(apiKey))
        }catch (e : Exception) {
            emit(State.Failure(e))
        }

    }


}