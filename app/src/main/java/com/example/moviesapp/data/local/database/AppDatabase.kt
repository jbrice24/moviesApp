package com.example.moviesapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesapp.data.local.dao.PopularMovieDao
import com.example.moviesapp.data.local.dao.TopRatedMovieDao
import com.example.moviesapp.data.local.entity.PopularMovie
import com.example.moviesapp.data.local.entity.TopRatedMovie

@Database(entities = [PopularMovie::class, TopRatedMovie::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun popularMovieDao(): PopularMovieDao

    abstract fun topRatedMovieDao(): TopRatedMovieDao

}