package com.serlife.movies.ui.movie.feed

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serlife.movies.data.entity.Movie
import com.serlife.movies.data.onFailure
import com.serlife.movies.data.onSuccess
import com.serlife.movies.data.repository.MoviesRepository
import kotlinx.coroutines.launch

class ListMoviesViewModal(private val repositoryMovies: MoviesRepository) : ViewModel() {

    var movies = MutableLiveData<List<Movie>>()
    var isLoading = false
    var page = 1

    init {
        loadData()
    }

    fun loadData(reset: Boolean = false) {

        if (reset) {
            page = 1
            movies = MutableLiveData<List<Movie>>()
            isLoading = false
        }

        if (isLoading) return

        isLoading = true
        viewModelScope.launch {
            repositoryMovies.getMoviesList(page)
                .onSuccess {
                    val list = mutableListOf<Movie>()
                    list.addAll(movies.value ?: mutableListOf())
                    list.addAll(it)
                    movies.value = list
                    page++
                    isLoading = false
                }
                .onFailure {
                    Log.i("ERROR!!!!!", it.message.toString())
                    isLoading = false
                }
        }
    }
}