package com.example.pokedex.MainAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.Model.PokemonDataClass
import com.example.pokedex.R
import com.squareup.picasso.Picasso

class PokemonsListAdapter: ListAdapter<PokemonDataClass, PokemonsListAdapter.PokemonViewHolder>(PokemonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pokemon, parent, false))
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.name)
        private val image = view.findViewById<ImageView>(R.id.image)

        fun bindTo(pokemon: PokemonDataClass) {
            name.text = pokemon.name
            Picasso.get().load(pokemon.imageURL).into(image)
        }
    }
}
