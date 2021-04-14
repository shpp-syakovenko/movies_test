package com.serlife.movies.ui.movie.feed.adapter

import androidx.recyclerview.widget.DiffUtil
import com.serlife.movies.data.entity.Movie

class MovieItemsDiffCallback : DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

}