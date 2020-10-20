package com.example.pokedex.Model

import com.example.pokedex.Model.PokeApiInteraction.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokeRepositoryImpl: PokeRepository {
    private val api: PokeApiRequest = createPokeApiService()

    override fun getPokemonList(callback: PokeRepository.ApiCallback<List<PokeData>>) {
        api.fetchPokemonList().enqueue(object : Callback<DataListResponse>{
             override fun onResponse(call: Call<DataListResponse>, response: Response<DataListResponse>) {
                val pokeList = response.body()
                if (response.isSuccessful && pokeList != null){
                    return callback.onSuccess(pokeList.results.map { PokeData -> PokeData(PokeData.name, PokeData.getImageUrl()) })
                }
                else{
                    callback.onError()
                }
            }
            override fun onFailure(call: Call<DataListResponse>, t: Throwable) {
                callback.onError()
            }
        })
    }
}