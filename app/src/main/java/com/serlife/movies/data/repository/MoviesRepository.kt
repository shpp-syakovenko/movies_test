package com.serlife.movies.data.repository

import com.serlife.movies.data.api.ApiFactory
import com.serlife.movies.data.entity.Movie
import io.reactivex.rxjava3.core.Observable

class MoviesRepository {
    fun getMoviesList(page: Int = 1): Observable<List<Movie>?> {
        val response = ApiFactory.apiService.getMovies(page = page.toString())
        return response.map {
            it.data
        }
    }
}