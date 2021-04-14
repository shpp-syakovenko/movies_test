package com.serlife.movies.ui.movie.feed.adapter

import androidx.recyclerview.widget.RecyclerView
import com.serlife.movies.data.entity.Movie
import com.serlife.movies.databinding.ItemMovieBinding

class MovieViewHolder(private val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie, eventHolder: MovieEventHolder?) {
        binding.movie = movie
        binding.ivPoster.setOnClickListener { eventHolder?.onMovieClicked?.invoke(movie) }
        binding.executePendingBindings()
    }

}