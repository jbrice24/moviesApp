package com.example.moviesapp.dagger.modules

import android.content.Context
import androidx.room.Room
import com.example.moviesapp.data.local.database.AppDatabase
import com.example.moviesapp.data.local.mapper.MoviesMapper
import com.example.moviesapp.data.local.movies.MoviesLocalRepository
import com.example.moviesapp.data.repository.remote.movies.MoviesRemoteRepository
import com.example.moviesapp.data.repository.remote.movies.MoviesRemoteRepositoryImpl
import com.example.moviesapp.domain.data.local.MoviesLocalRepositoryImpl
import com.example.moviesapp.domain.data.mapper.MoviesMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    fun providesMovieRemoteRepo() : MoviesRemoteRepository = MoviesRemoteRepositoryImpl()

    @Singleton
    @Provides
    fun providesMovieDatabase(
        @ApplicationContext context : Context
    ) =
        Room.inMemoryDatabaseBuilder(
        context,
        AppDatabase::class.java
    ).build()

    @Singleton
    @Provides
    fun providesPopularMoviesDao(db : AppDatabase) = db.popularMovieDao()

    @Singleton
    @Provides
    fun providesTopRatedMoviesDao(db : AppDatabase) = db.popularMovieDao()

    @Provides
    fun providesMovieLocalRepo(mapper : MoviesMapper) : MoviesLocalRepository = MoviesLocalRepositoryImpl(mapper)

    @Provides
    fun providesMovieMapper(db : AppDatabase) : MoviesMapper = MoviesMapperImpl(db)

}