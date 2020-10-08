package com.example.pokedex

import androidx.recyclerview.widget.DiffUtil

class PokemonDiffCallback: DiffUtil.ItemCallback<PokemonDataClass>() {
    override fun areItemsTheSame(oldItem: PokemonDataClass, newItem: PokemonDataClass): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PokemonDataClass, newItem: PokemonDataClass): Boolean {
        return oldItem == newItem
    }
}