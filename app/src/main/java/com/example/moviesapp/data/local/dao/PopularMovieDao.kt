package com.example.moviesapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesapp.data.local.entity.PopularMovie

@Dao
interface PopularMovieDao {

    @Query("SELECT * FROM popularmovie")
    suspend fun getPopularMovies(): List<PopularMovie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertMovies(list: List<PopularMovie>)
}