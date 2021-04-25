package com.example.moviesapp.base

data class PayLoad<out T>(
    val results : T
)