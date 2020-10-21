package com.example.pokedex.MainAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.Model.PokeData
import com.example.pokedex.R
import com.squareup.picasso.Picasso
import kotlin.random.Random

class PokemonListAdapter : ListAdapter<PokeData, PokemonListAdapter.PokemonViewHolder>(PokemonDiffCallback()) {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        context = holder.itemView.context
        holder.itemView.setBackgroundColor(setRandomCardColor())
        holder.bindTo(getItem(position))
    }

    private fun setRandomCardColor(): Int {
        val coloredList: IntArray = context.resources.getIntArray(R.array.colors)
        return coloredList[Random.nextInt(1, coloredList.size)]
    }

    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.name)
        private val image = view.findViewById<ImageView>(R.id.image)

        @SuppressLint("DefaultLocale")
        fun bindTo(pokemon: PokeData) {
            name.text = pokemon.name.capitalize()
            Picasso.get().load(pokemon.url).into(image)
        }
    }
}
