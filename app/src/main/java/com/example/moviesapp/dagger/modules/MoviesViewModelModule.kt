package com.example.moviesapp.dagger.modules

import com.example.moviesapp.domain.movies.MoviesUseCase
import com.example.moviesapp.domain.movies.MoviesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent ::class)
abstract class MoviesViewModelModule {

    @Binds
    abstract fun bindUseCase(moviesUseCaseImpl: MoviesUseCaseImpl) : MoviesUseCase

}