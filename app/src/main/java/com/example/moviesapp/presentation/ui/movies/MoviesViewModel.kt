package com.example.moviesapp.presentation.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviesapp.base.State
import com.example.moviesapp.data.model.remote.Movie
import com.example.moviesapp.domain.movies.MoviesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers

class MoviesViewModel @ViewModelInject constructor(
    private val moviesUseCase : MoviesUseCase
) : ViewModel() {

    private val compositeDispose = CompositeDisposable()

    private val popularList = MutableLiveData<State<List<Movie>>>()

    val getPopularListState:LiveData<State<List<Movie>>>
        get() = popularList

    fun getPopularMovieList(apiKey : String) : LiveData<State<List<Movie>>> {

        return liveData(Dispatchers.IO) {
            emit(State.Loading())

            try {
                emit(moviesUseCase.getPopularMovies(apiKey))
            }catch (e : Exception) {
                emit(State.Failure(e.message))
            }

        }
    }

    fun getTopRatedMovies(apiKey: String) : LiveData<State<List<Movie>>> {

        return liveData(Dispatchers.IO) {
            emit(State.Loading())

            try {
                emit(moviesUseCase.getTopRatedMovies(apiKey))
            }catch (e : Exception) {
                emit(State.Failure(e.message))
            }

        }
    }

    fun getPopularMoviesRX(apiKey: String) {

        popularList.postValue(State.Loading())

        compositeDispose
            .add(moviesUseCase
                .getPopularMoviesRX(apiKey)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        popularList.postValue(State.Success(it))
                    } , {
                        popularList.postValue(State.Failure(it.message))
                    }
                ))
    }

    override fun onCleared() {
        super.onCleared()
        compositeDispose.clear()
    }





}