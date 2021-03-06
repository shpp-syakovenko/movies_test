package com.serlife.movies.data.api

import com.serlife.movies.data.api.response.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("discover/movie")
    suspend fun getMovies(
        @Query(QUERY_PARAM_API_KEY) api_key: String = "d71194ebc35d4c006794a0ccdd01b5e0",
        @Query(QUERY_PARAM_SORT_BY) sort_by: String = "popularity.desc",
        @Query(QUERY_PARAM_PAGE) page: String = "1"
    ): Response<MoviesResponse>

    companion object {
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_SORT_BY = "sort_by"
        private const val QUERY_PARAM_PAGE = "page"
    }
}