package com.example.moviesapp.data.model.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id : String = "",
    val title : String = "",
    @SerializedName("overview")
    val description : String = "",
    @SerializedName("poster_path")
    val image : String = ""
) : Parcelable