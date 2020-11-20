package com.example.pokedex.viewModel

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.model.PokeData
import com.example.pokedex.model.PokeRepository
import com.example.pokedex.model.PokeRepositoryImpl


class PokemonViewModel(private val repo: PokeRepositoryImpl) : ViewModel() {

    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean> = _loadingState

    private val _errorState = MutableLiveData<Boolean>()
    val errorState: LiveData<Boolean> = _errorState

    private val _showContentState = MutableLiveData<List<PokeData>>()
    val showContentState: LiveData<List<PokeData>> = _showContentState

    fun setState() {
        isLoading()

        Handler().postDelayed({
            repo.getPokemonList(object : PokeRepository.ApiCallback<List<PokeData>> {
                override fun onSuccess(data: List<PokeData>) {
                    showContent(data)
                }
                override fun onError() {
                    showError()
                }
            })
        }, 3000)
    }


    private fun isLoading() {
        _loadingState.value = true
        _errorState.value = false
        _showContentState.value = emptyList()
    }

    private fun showContent(data: List<PokeData>) {
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