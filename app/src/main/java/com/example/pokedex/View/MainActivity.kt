package com.example.pokedex.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.example.pokedex.MainAdapter.PokemonListAdapter
import com.example.pokedex.Model.PokeData
import com.example.pokedex.R
import com.example.pokedex.ViewModel.PokemonViewModel
import kotlinx.android.synthetic.main.fragment_poke_list.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}