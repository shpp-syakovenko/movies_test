package com.serlife.movies.ui.movie.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.serlife.movies.data.entity.Movie
import com.serlife.movies.databinding.ListMoviesBinding
import com.serlife.movies.ui.movie.feed.adapter.MovieEventHolder
import com.serlife.movies.ui.movie.feed.adapter.MoviesAdapter
import com.serlife.movies.ui.view.ScrollMoreListener
import com.serlife.movies.ui.view.ScrollMoreListener.Companion.SCROLL_DIRECTION_BOTTOM
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListMoviesFragment : Fragment() {

    private lateinit var binding: ListMoviesBinding

    private val adapter: MoviesAdapter
        get() = binding.rvListMovie.adapter as MoviesAdapter

    private val viewModel: ListMoviesViewModal by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ListMoviesBinding.inflate(inflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.movies.observe(viewLifecycleOwner, ::setMovies)

        binding.lifecycleOwner = this
        binding.rvListMovie.adapter = MoviesAdapter()

        binding.rvListMovie.addOnScrollListener(ScrollMoreListener(SCROLL_DIRECTION_BOTTOM) {

        })

        adapter.eventHolder = MovieEventHolder().apply {
            onMovieClicked = ::openMovieDetails
        }
    }

    private fun setMovies(movies: List<Movie>) {
        adapter.submitList(movies)
    }

    private fun openMovieDetails(movie: Movie) {
        findNavController().navigate(ListMoviesFragmentDirections.actionDetailMovieFragment(movie))
    }
}