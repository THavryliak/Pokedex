package com.example.pokedex.MainAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.Model.PokeData
import com.example.pokedex.R
import com.example.pokedex.ViewModel.DetailViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon.view.*
import kotlin.random.Random

class PokemonListAdapter : ListAdapter<PokeData, PokemonListAdapter.PokemonViewHolder>(PokemonDiffCallback()) {

    private val detailModel: DetailViewModel = DetailViewModel()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.itemView.setBackgroundColor(setRandomCardColor(holder.itemView.context))
        holder.bind(getItem(position))

        //fix here
        holder.itemView.setOnClickListener{ view ->
            detailModel.sendData(Pair(holder.itemView.name.text.toString(), (position + 1).toString()))
            view.findNavController().navigate(R.id.action_pokeListFragment_to_pokeDetailsFragment)
        }
    }

    private fun setRandomCardColor(context: Context): Int {
        val coloredList: IntArray = context.resources.getIntArray(R.array.colors)
        return coloredList[Random.nextInt(1, coloredList.size)]
    }

    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.name)
        val image = view.findViewById<ImageView>(R.id.image)

        @SuppressLint("DefaultLocale")
        fun bind(pokemon: PokeData) {
            name.text = pokemon.name.capitalize()
            Picasso.get().load(pokemon.url).into(image)
        }
    }
}
