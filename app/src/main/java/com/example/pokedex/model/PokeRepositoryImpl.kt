package com.example.pokedex.model

import com.example.pokedex.model.api.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokeRepositoryImpl(private val api: PokeApiRequest ): PokeRepository {

    override fun getPokemonList(callback: PokeRepository.ApiCallback<List<PokeData>>) {
        api.fetchPokemonList().enqueue(object : Callback<PokeListResponse>{
             override fun onResponse(call: Call<PokeListResponse>, response: Response<PokeListResponse>) {
                val pokeList = response.body()
                if (response.isSuccessful && pokeList != null){
                    return callback.onSuccess(pokeList.results.map { PokeData -> PokeData( PokeData.name, PokeData.getImageUrl()) })
                }
                else{
                    callback.onError()
                }
            }
            override fun onFailure(call: Call<PokeListResponse>, t: Throwable) {
                callback.onError()
            }
        })
    }
}