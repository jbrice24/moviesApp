package com.example.moviesapp.presentation.ui.movies.detail

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviesapp.R
import com.example.moviesapp.data.model.remote.Movie
import com.example.moviesapp.presentation.ui.movies.MoviesActivity
import kotlinx.android.synthetic.main.fragment_movie_detail.*

class MovieDetailFragment : Fragment() {

    private lateinit var movie : Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireArguments().let {

            movie = it.getParcelable<Movie>("movie_key")!!

        }

        (activity as MoviesActivity).supportActionBar?.title = movie.title
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home)
            activity?.onBackPressed()

        return true
    }

    fun initViews(){

        Glide
            .with(requireContext())
            .applyDefaultRequestOptions(RequestOptions().override(700, 700))
            .load("https://image.tmdb.org/t/p/original/" + movie.image)
            .into(ivMovie)

        tvTitle.setText(movie.title)
        tvDescription.setText(movie.description)
    }
}