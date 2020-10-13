package com.example.pokedex.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokedex.MainAdapter.PokemonsListAdapter
import com.example.pokedex.R
import com.example.pokedex.Model.pokemonList
import com.example.pokedex.ViewModel.PokemonViewModel
import kotlinx.android.synthetic.main.activity_main.recyclerView

class MainActivity : AppCompatActivity() {

    private val model: PokemonViewModel = PokemonViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = PokemonsListAdapter()
        recyclerView.adapter = adapter

        adapter.submitList(pokemonList)
    }
}