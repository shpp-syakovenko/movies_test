package com.serlife.movies.data.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
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
): Parcelable {
    fun getFullImage(): String {
        return "https://image.tmdb.org/t/p/w500$poster_path"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Movie

        if (id != other.id) return false
        if (original_title != other.original_title) return false
        if (overview != other.overview) return false
        if (poster_path != other.poster_path) return false
        if (release_date != other.release_date) return false
        if (vote_average != other.vote_average) return false
        if (vote_count != other.vote_count) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (original_title?.hashCode() ?: 0)
        result = 31 * result + (overview?.hashCode() ?: 0)
        result = 31 * result + (poster_path?.hashCode() ?: 0)
        result = 31 * result + (release_date?.hashCode() ?: 0)
        result = 31 * result + (vote_average?.hashCode() ?: 0)
        result = 31 * result + (vote_count ?: 0)
        return result
    }
}