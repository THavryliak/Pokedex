package com.example.pokedex.di

import com.example.pokedex.adapter.PokemonListAdapter
import com.example.pokedex.model.PokeRepositoryImpl
import com.example.pokedex.model.api.PokeApiRequest
import com.example.pokedex.view.PokeDetailsFragment
import com.example.pokedex.view.PokeListFragment
import com.example.pokedex.viewModel.DetailViewModel
import com.example.pokedex.viewModel.PokemonViewModel
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val AppModules: Module = module {

    viewModel { PokemonViewModel(get()) }

    single { PokemonListAdapter(get()) }

    fragment { PokeListFragment(get()) }

    single { DetailViewModel() }

}

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