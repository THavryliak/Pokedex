package com.example.pokedex.Model

class PokemonDAO: DAO {
    override fun getPokemonList(): List<PokemonDataClass> {
        return pokemonList
    }
}