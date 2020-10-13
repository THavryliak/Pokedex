package com.example.pokedex.Model

data class PokemonDataClass(val id: String, val name: String, val imageURL: String )

     val pokemonList = listOf(
        PokemonDataClass(
            "1",
            "Bulbasaur",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"
        ),
        PokemonDataClass(
            "4",
            "Charmander",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png"
        ),
        PokemonDataClass(
            "14",
            "Kakuna",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/14.png"
        ),
        PokemonDataClass(
            "15",
            "Beedrill",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/15.png"
        ),
        PokemonDataClass(
            "18",
            "Pidgeot",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/18.png"
        ),
        PokemonDataClass(
            "25",
            "Pikachu",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png"
        ),
        PokemonDataClass(
            "27",
            "Sandshrew",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/27.png"
        ),
        PokemonDataClass(
            "28",
            "Sandslash",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/28.png"
        ),
        PokemonDataClass(
            "54",
            "Psyduck",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/54.png"
        )
    )

