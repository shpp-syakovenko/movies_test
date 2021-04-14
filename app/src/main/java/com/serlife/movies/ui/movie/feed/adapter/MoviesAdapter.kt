package com.serlife.movies.ui.movie.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.serlife.movies.R
import com.serlife.movies.data.entity.Movie
import com.serlife.movies.databinding.ItemMovieBinding

class MoviesAdapter : ListAdapter<Movie, MovieViewHolder>(MovieItemsDiffCallback()) {

    var eventHolder: MovieEventHolder? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding: ItemMovieBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_movie, parent, false)

        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(currentList[position], eventHolder)
    }

}