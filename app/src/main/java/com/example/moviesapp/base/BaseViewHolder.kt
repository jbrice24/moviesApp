package com.example.moviesapp.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bindView(item : T)

    interface onItemClickListener<T> {
        fun onItemClick(item : T)
    }

}