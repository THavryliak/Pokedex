package com.example.pokedex.ViewModel

import androidx.lifecycle.ViewModel
import com.example.pokedex.Model.PokemonDAO

class PokemonViewModel: ViewModel() {
    private val daoOBJ: PokemonDAO = PokemonDAO()

}