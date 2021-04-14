package com.serlife.movies.di

import com.serlife.movies.data.repository.MoviesRepository
import com.serlife.movies.ui.movie.feed.ListMoviesViewModal
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ListMoviesViewModal(get<MoviesRepository>()) }
}