package com.example.pokedex.ViewModel

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.Model.PokemonDAO
import com.example.pokedex.Model.PokemonDataClass

import kotlin.random.Random


class PokemonViewModel : ViewModel() {
    private val daoOBJ: PokemonDAO = PokemonDAO()

    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean> = _loadingState

    private val _errorState = MutableLiveData<Boolean>()
    val errorState: LiveData<Boolean> = _errorState

    private val _showContentState = MutableLiveData<List<PokemonDataClass>>()
    val showContentState: LiveData<List<PokemonDataClass>> = _showContentState

    fun setState() {
        isLoading()

        Handler().postDelayed({
            //error example
            if (Random.nextInt(1, 11) == 5) {
                showError()
            } else {
                showContent(daoOBJ.getPokemonList())
            }
        }, 3000)
    }

    private fun isLoading() {
        _loadingState.value = true
        _errorState.value = false
        _showContentState.value = emptyList()
    }

    private fun showContent(data: List<PokemonDataClass>) {
        if (data.isEmpty()) {
            showError()
        } else {
            _showContentState.postValue(data)
            _loadingState.value = false
            _errorState.value = false
        }
    }

    private fun showError() {
        _errorState.value = true
        _showContentState.value = emptyList()
        _loadingState.value = false
    }
}