package com.example.pokedex.DiModules

import com.example.pokedex.MainAdapter.PokemonListAdapter
import com.example.pokedex.Model.PokeRepositoryImpl
import com.example.pokedex.View.PokeListFragment
import com.example.pokedex.ViewModel.DetailViewModel
import com.example.pokedex.ViewModel.PokemonViewModel
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val AppModules: Module = module {

    single { PokemonListAdapter(get()) }

    fragment { PokeListFragment(get()) }

    viewModel { PokemonViewModel(get()) }

    single { DetailViewModel() }

}