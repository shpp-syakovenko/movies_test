package com.serlife.movies.ui.list_movies

import androidx.recyclerview.widget.RecyclerView
import com.serlife.movies.data.entity.Movie
import com.serlife.movies.databinding.ItemMovieBinding
import com.squareup.picasso.Picasso

class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) {
        Picasso.get().load(movie.getFullImage()).into(binding.ivPoster)
    }
}