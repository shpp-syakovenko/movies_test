package com.serlife.movies.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Movie(
    @SerializedName("id")
    @Expose
    val id: Int?,
    @SerializedName("original_title")
    @Expose
    val original_title: String?,
    @SerializedName("overview")
    @Expose
    val overview: String?,
    @SerializedName("poster_path")
    @Expose
    val poster_path: String?,
    @SerializedName("release_date")
    @Expose
    val release_date: String?,
    @SerializedName("vote_average")
    @Expose
    val vote_average: Double?,
    @SerializedName("vote_count")
    @Expose
    val vote_count: Int?
) {
    fun getFullImage(): String {
        return "https://image.tmdb.org/t/p/w500$poster_path"
    }
}