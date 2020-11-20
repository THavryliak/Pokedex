package com.example.pokedex.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.pokedex.model.PokeData

class PokemonDiffCallback: DiffUtil.ItemCallback<PokeData>() {
    override fun areItemsTheSame(oldItem: PokeData, newItem: PokeData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PokeData, newItem: PokeData): Boolean {
        return oldItem == newItem
    }
}