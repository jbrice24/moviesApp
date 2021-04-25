package com.example.moviesapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "topratedmovie")
data class TopRatedMovie(
    @PrimaryKey val id : String,
    @ColumnInfo(name = "Title") val title : String,
    @ColumnInfo(name = "Description") val description : String,
    @ColumnInfo(name = "Image") val image : String
)

