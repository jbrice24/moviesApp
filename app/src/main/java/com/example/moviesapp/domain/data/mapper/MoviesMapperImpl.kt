package com.example.moviesapp.domain.data.mapper

import com.example.moviesapp.data.local.database.AppDatabase
import com.example.moviesapp.data.local.entity.PopularMovie
import com.example.moviesapp.data.local.entity.TopRatedMovie
import com.example.moviesapp.data.local.mapper.MoviesMapper
import com.example.moviesapp.data.model.remote.Movie
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MoviesMapperImpl @Inject constructor(
    private val db : AppDatabase
) : MoviesMapper{

    override suspend fun mapMoviesToPopularMovies(movieList: List<Movie>) {
        db.popularMovieDao().insertMovies(movieList.map { PopularMovie(it.id, it.title, it.description, it.image) })
    }

    override suspend fun mapMoviesToTopRatedMovies(movieList: List<Movie>) {
        db.topRatedMovieDao().insertTopRatedMovie(movieList.map { TopRatedMovie(it.id, it.title, it.description, it.image) })
    }

    override suspend fun getPopularMappedMovies(): List<Movie> {
        return db.popularMovieDao().getPopularMovies().map { Movie(it.id, it.title, it.description, it.image) }
    }

    override suspend fun getTopRatedMappedMovies(): List<Movie> {
        return db.topRatedMovieDao().getTopRatedMovies().map { Movie(it.id, it.title, it.description, it.image) }
    }

    override fun mapMoviesToPopularMoviesRX(movieList: List<Movie>) {
        db.popularMovieDao().insertMoviesRX(movieList.map { PopularMovie(it.id, it.title, it.description, it.image) })
    }

    override fun getPopularMappedMoviesRX() : Observable<List<Movie>> {
        return db.popularMovieDao().getPopularMoviesRX()
            .map {
                it.map { Movie(it.id, it.title, it.description, it.image) }
            }

    }
}