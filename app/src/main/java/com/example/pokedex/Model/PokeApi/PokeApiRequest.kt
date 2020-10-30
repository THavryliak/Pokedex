package com.example.pokedex.Model.PokeApi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApiRequest {

    @GET("pokemon")
    fun fetchPokemonList(
        @Query("limit") limit: Int = 1000,
        @Query("offset") offset: Int = 0
    ): Call<PokeListResponse>
}
