package com.example.pokedex.DiModules

import com.example.pokedex.Model.PokeApi.PokeApiRequest
import com.example.pokedex.Model.PokeRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val NetworkModules: Module = module {
    fun createPokeApiService(): PokeApiRequest {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit.create(PokeApiRequest::class.java)
    }
    single { createPokeApiService() }

    single { PokeRepositoryImpl(get()) }
}