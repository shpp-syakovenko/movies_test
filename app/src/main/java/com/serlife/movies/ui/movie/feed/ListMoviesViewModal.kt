package com.serlife.movies.ui.movie.feed

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serlife.movies.data.entity.Movie
import com.serlife.movies.data.repository.MoviesRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ListMoviesViewModal(private val repositoryMovies: MoviesRepository) : ViewModel() {

    var movies = MutableLiveData<List<Movie>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        loadData()
    }

    private fun loadData() {

        // add coroutine






        compositeDisposable.add(
            repositoryMovies.getMoviesList(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    movies.value = it
                }, {
                    Log.i("ERROR!!!!!", it.message.toString())
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}