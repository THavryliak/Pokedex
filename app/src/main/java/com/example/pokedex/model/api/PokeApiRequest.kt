package com.example.pokedex.model.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApiRequest {

    @GET("pokemon")
    fun fetchPokemonList(
        @Query("limit") limit: Int = 1000,
        @Query("offset") offset: Int = 0
    ): Call<PokeListResponse>
}
