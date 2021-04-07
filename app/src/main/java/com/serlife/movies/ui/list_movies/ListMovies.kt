package com.serlife.movies.ui.list_movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.serlife.movies.databinding.ListMoviesBinding

class ListMovies : Fragment() {

    private lateinit var binding: ListMoviesBinding
    private val viewModel: ListMoviesViewModal by lazy {
        ViewModelProvider(this).get(
            ListMoviesViewModal::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ListMoviesBinding.inflate(inflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MoviesAdapter()
        viewModel.movies.observe(viewLifecycleOwner, {
            adapter.items = it
        })
        binding.lifecycleOwner = this
        binding.rvListMovie.adapter = adapter
    }
}