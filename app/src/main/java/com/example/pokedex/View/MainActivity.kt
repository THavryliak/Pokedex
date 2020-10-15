package com.example.pokedex.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pokedex.MainAdapter.PokemonListAdapter
import com.example.pokedex.Model.PokemonDataClass
import com.example.pokedex.R
import com.example.pokedex.ViewModel.PokemonViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val model: PokemonViewModel = PokemonViewModel()
    private val adapter = PokemonListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = adapter

        model.loadingState.observe(this, androidx.lifecycle.Observer {
            if (it) {
                loadingPanel.visibility = View.VISIBLE
            } else {
                loadingPanel.visibility = View.GONE
            }
        })

        model.showContentState.observe(this, androidx.lifecycle.Observer { data ->
            if (data.isNotEmpty()) {
                recyclerView.visibility = View.VISIBLE
            } else {
                recyclerView.visibility = View.GONE
            }
            setData(data)
        })

        model.errorState.observe(this, androidx.lifecycle.Observer {
            if (it) {
                errorView.visibility = View.VISIBLE
            } else {
                errorView.visibility = View.GONE
            }
        })

        model.setState()
    }

    fun setData(data: List<PokemonDataClass>) {
        adapter.submitList(data)
    }
}