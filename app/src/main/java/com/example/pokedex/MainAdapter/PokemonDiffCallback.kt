package com.example.pokedex.MainAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.pokedex.Model.PokemonDataClass

class PokemonDiffCallback: DiffUtil.ItemCallback<PokemonDataClass>() {
    override fun areItemsTheSame(oldItem: PokemonDataClass, newItem: PokemonDataClass): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PokemonDataClass, newItem: PokemonDataClass): Boolean {
        return oldItem == newItem
    }
}