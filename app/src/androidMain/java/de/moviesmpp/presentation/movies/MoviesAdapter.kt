package de.moviesmpp.presentation.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.R
import de.moviesmpp.domain.model.Post

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    var posts: List<Post> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_movie,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val post = posts[position]
        with(holder) {
//            Glide.with(posterView).load(post.title).into(posterView)
            titleView.text = post.title
        }
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val posterView: ImageView = itemView.findViewById(R.id.iv_movie_poster)
        val titleView: TextView = itemView.findViewById(R.id.tv_movie_title)
    }
}