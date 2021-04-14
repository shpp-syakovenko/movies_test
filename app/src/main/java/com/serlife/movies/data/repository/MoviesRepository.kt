package com.serlife.movies.data.repository

import com.serlife.movies.data.api.ApiService
import com.serlife.movies.data.entity.Movie
import io.reactivex.rxjava3.core.Observable

class MoviesRepository(private val apiService: ApiService) {

    fun getMoviesList(page: Int = 1): Observable<List<Movie>?> {
        return apiService.getMovies(page = page.toString()).map { it.data }
    }
}