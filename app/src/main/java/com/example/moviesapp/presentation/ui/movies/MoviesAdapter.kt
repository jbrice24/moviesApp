package com.example.moviesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviesapp.base.BaseViewHolder
import com.example.moviesapp.data.model.remote.Movie
import kotlinx.android.synthetic.main.movies_row.view.*

class MoviesAdapter(private val context : Context,
                    private val movieList : List<Movie>,
                    private val itemClickListener: BaseViewHolder.onItemClickListener<Movie>) : RecyclerView.Adapter<BaseViewHolder<Movie>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Movie> {
        return MoviesViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.movies_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Movie>, position: Int) {
        holder.bindView(movieList[position])
    }

    inner class MoviesViewHolder(itemView : View) : BaseViewHolder<Movie>(itemView){

        override fun bindView(item: Movie) {
            Glide
                .with(context)
                .applyDefaultRequestOptions(RequestOptions().override(350, 350))
                .load("https://image.tmdb.org/t/p/original/" + item.image)
                .into(itemView.ivMovie)

            itemView.tvTitle.setText(item.title)
            itemView.tvDescription.setText(item.description)
            itemView.setOnClickListener { itemClickListener.onItemClick(item)}
        }
    }

}