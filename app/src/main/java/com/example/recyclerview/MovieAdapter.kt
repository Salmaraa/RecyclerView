package com.example.recyclerview


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityPilihFilmBinding


typealias onClickMovie = (Film) -> Unit

class MovieAdapter(private val listMovie: List<Film>,
                   private val onClickMovie: onClickMovie):
    RecyclerView.Adapter<MovieAdapter.ItemMovieViewHolder>(){
    inner class ItemMovieViewHolder(private val binding :
                                    ActivityPilihFilmBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind (data : Film){
            with(binding){
                judulFilm.text = data.nameMovie
                deskripsiFilm.text = data.descMovie

                val image_movie = when (data.imageMovie){
                    R.drawable.sherina -> R.drawable.sherina
                    R.drawable.tegar -> R.drawable.tegar
                    R.drawable.helloghost-> R.drawable.helloghost
                    else -> R.drawable.suhita
                }

                posterFilm.setImageResource(image_movie)
                itemView.setOnClickListener{
                    onClickMovie(data)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMovieViewHolder {
        val binding = ActivityPilihFilmBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ItemMovieViewHolder(binding)
    }

    override fun getItemCount(): Int =listMovie.size

    override fun onBindViewHolder(holder: ItemMovieViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }
}
