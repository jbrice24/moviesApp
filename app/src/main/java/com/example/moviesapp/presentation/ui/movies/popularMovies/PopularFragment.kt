package com.example.moviesapp.presentation.ui.movies.popularMovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.MoviesAdapter
import com.example.moviesapp.R
import com.example.moviesapp.base.State
import com.example.moviesapp.base.BaseViewHolder
import com.example.moviesapp.data.model.remote.Movie
import com.example.moviesapp.presentation.ui.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.movies_fragment.*

@AndroidEntryPoint
class PopularFragment : Fragment(), BaseViewHolder.onItemClickListener<Movie> {

    private val viewModel by activityViewModels<MoviesViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        setObservers()
    }

    private fun initRecyclerView(){
        rvMovies.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setObservers() {

        viewModel
            .getPopularMovieList(getString(R.string.api_key))
            .observe(viewLifecycleOwner, observeMoviesList())

    }

    private fun observeMoviesList() : Observer<State<List<Movie>>>{

        return Observer {
            when(it) {
                is State.Loading -> {
                    pgMovies.visibility = View.VISIBLE
                }

                is State.Success -> {
                    pgMovies.visibility = View.GONE
                    rvMovies.adapter = MoviesAdapter(requireContext(), it.payLoad, this)
                }

                is State.Failure -> {
                    pgMovies.visibility = View.GONE
                    Toast.makeText(requireContext(), it.e.message, Toast.LENGTH_LONG).show()
                }
            }
        }

    }

    override fun onItemClick(item: Movie) {

        val bundle = Bundle()
        bundle.putParcelable("movie_key", item)

       findNavController().navigate(R.id.movieDetailFragment, bundle)
    }
}