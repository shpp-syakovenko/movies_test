package com.serlife.movies.di

import com.serlife.movies.data.api.ApiService
import com.serlife.movies.data.repository.MoviesRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { MoviesRepository(get<ApiService>()) }
}