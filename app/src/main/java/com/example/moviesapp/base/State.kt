package com.example.moviesapp.base

import java.lang.Exception

sealed class State<out T> {
    class Loading<out T> : State<T>()
    data class Success<out T>(val payLoad : T) : State<T>()
    data class Failure<out T>(val e : String?) : State<T>()
}