package com.example.pokedex.adapter

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
import com.example.pokedex.model.PokeData
import com.example.pokedex.R
import com.example.pokedex.viewModel.DetailViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon.view.*
import kotlin.random.Random


class PokemonListAdapter(private val detailModel: DetailViewModel) : ListAdapter<PokeData, PokemonListAdapter.PokemonViewHolder>(PokemonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.itemView.setBackgroundColor(setRandomCardColor(holder.itemView.context))
        holder.bind(getItem(position))

        //bad
        //adapter should't know about models and and view or navigation
        //solution is to handle click with click interface and navigate to another fragment from PokeListFragment....
        holder.itemView.setOnClickListener{ view ->
            detailModel.sendData(Pair(holder.itemView.name.text.toString(), (position + 1)))
            view.findNavController().navigate(R.id.action_pokeListFragment_to_pokeDetailsFragment)
        }
    }

    private fun setRandomCardColor(context: Context): Int {
        val coloredList: IntArray = context.resources.getIntArray(R.array.colors)
        return coloredList[Random.nextInt(1, coloredList.size)]
    }

    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name: TextView = view.findViewById(R.id.name)
        private val image: ImageView = view.findViewById(R.id.image)

        @SuppressLint("DefaultLocale")
        fun bind(pokemon: PokeData) {
            name.text = pokemon.name.capitalize()
            Picasso.get().load(pokemon.url).into(image)
        }
    }
}
