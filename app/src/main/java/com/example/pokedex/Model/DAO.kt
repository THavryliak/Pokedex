package com.example.pokedex.Model

interface DAO {

    fun getPokemonList(): List<PokemonDataClass>

    //it's not all functional
}