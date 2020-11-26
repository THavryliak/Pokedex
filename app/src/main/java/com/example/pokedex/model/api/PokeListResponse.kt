package com.example.pokedex.model.api

import com.example.pokedex.model.PokeData

data class PokeListResponse(
    val results: List<PokeData>
)

