package com.example.moviesapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesapp.data.local.entity.PopularMovie
import com.example.moviesapp.data.local.entity.TopRatedMovie

@Dao
interface TopRatedMovieDao {
    @Query("SELECT * FROM topratedmovie")
    suspend  fun getTopRatedMovies(): List<TopRatedMovie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertTopRatedMovie(list: List<TopRatedMovie>)
}