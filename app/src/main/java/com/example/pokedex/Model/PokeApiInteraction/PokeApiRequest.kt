package com.example.pokedex.Model.PokeApiInteraction

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApiRequest {

    @GET("pokemon")
    fun fetchPokemonList(
        @Query("limit") limit: Int = 50,
        @Query("offset") offset: Int = 0
    ): Call<DataListResponse>
}


fun createPokeApiService(): PokeApiRequest {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    return retrofit.create(PokeApiRequest::class.java)
}