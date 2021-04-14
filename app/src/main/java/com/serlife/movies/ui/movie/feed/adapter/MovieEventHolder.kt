package com.serlife.movies.ui.movie.feed.adapter

import com.serlife.movies.data.entity.Movie

class MovieEventHolder {
    var onMovieClicked: ((movie: Movie) -> Unit)? = null
}