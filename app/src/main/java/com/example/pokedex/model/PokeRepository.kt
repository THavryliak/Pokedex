package com.example.pokedex.model


interface PokeRepository {

    interface ApiCallback<T> {
        fun onSuccess(data: T)
        fun onError()
    }

    fun getPokemonList(callback: ApiCallback<List<PokeData>>)
}