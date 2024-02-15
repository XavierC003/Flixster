package com.example.flixster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.text.FieldPosition

class BestMovieRecyclerViewAdapter(
    private val movies: List<BestMovie>,
    private val mListener : OnListFragmentInteractionListener?
) : RecyclerView.Adapter<BestMovieRecyclerViewAdapter.MovieViewHolder>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_best_movie, parent, false)
        return MovieViewHolder(view)
    }
    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView){
        var mItem: BestMovie? = null
        val mMovieTitle: TextView = mView.findViewById<View>(R.id.movie_title) as TextView
        val mMovieOverview: TextView = mView.findViewById<View>(R.id.movie_overview) as TextView
        val mMovieImage: ImageView = mView.findViewById<View>(R.id.movie_Image) as ImageView

        override fun toString(): String {
            return mMovieTitle.toString() + " '" + mMovieOverview.text + "'"
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.mItem = movie
        holder .mMovieTitle.text = movie.title
        holder.mMovieOverview.text = movie.overview
        val url = "https://image.tmdb.org/t/p/w500/" + movie.movieImageUrl
        Glide.with(holder.mView)
            .load(url)
            .centerCrop()
            .into(holder.mMovieImage)

        holder.mView.setOnClickListener{
            holder.mItem?.let {movie ->
                mListener?.onItemClick(movie)
            }
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}