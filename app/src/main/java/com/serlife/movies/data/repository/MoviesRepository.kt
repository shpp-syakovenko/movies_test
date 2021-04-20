package com.serlife.movies.data.repository

import com.serlife.movies.data.Either
import com.serlife.movies.data.api.ApiService
import com.serlife.movies.data.entity.Movie

class MoviesRepository(private val apiService: ApiService) {

    suspend fun getMoviesList(page: Int = 1): Either<List<Movie>> {
        val response = apiService.getMovies(page = page.toString())
        val body = response.body()?.data
        return if (!response.isSuccessful || body == null) {
            Either.failure(Exception("Fail"))
        } else {
            Either.success(body)
        }
    }
}