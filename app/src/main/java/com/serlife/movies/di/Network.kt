package com.serlife.movies.di

import com.serlife.movies.data.api.ApiFactory
import com.serlife.movies.data.api.ApiService
import org.koin.dsl.module

val networkModule = module {
    single<ApiService> { ApiFactory.createApiService() }
}