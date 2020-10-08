package com.example.pokedex

data class PokemonDataClass(val id: String, val name: String, val imageURL: String )

    val pokemonList = listOf(
        PokemonDataClass("1","Bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"),
        PokemonDataClass("4","Charmander", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png"),
        PokemonDataClass("18","Pidgeot", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/18.png"),
        PokemonDataClass("25","Pikachu", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png"),
        PokemonDataClass("54","Psyduck", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/54.png")
    )
