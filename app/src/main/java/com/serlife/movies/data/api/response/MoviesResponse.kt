package com.serlife.movies.data.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.serlife.movies.data.entity.Movie

class MoviesResponse(
    @SerializedName("results")
    @Expose
    val data: List<Movie>? = null
)