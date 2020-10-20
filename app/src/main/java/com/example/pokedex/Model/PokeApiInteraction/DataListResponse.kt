package com.example.pokedex.Model.PokeApiInteraction

import com.example.pokedex.Model.PokeData

data class DataListResponse(
    val results: List<PokeData>
)

