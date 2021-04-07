package com.serlife.movies.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MoviesResponse(
    @SerializedName("results")
    @Expose
    val data: List<Movie>? = null
)