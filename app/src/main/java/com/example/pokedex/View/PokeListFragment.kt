package com.example.pokedex.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.pokedex.MainAdapter.PokemonListAdapter
import com.example.pokedex.Model.PokeData
import com.example.pokedex.R
import com.example.pokedex.ViewModel.PokemonViewModel
import kotlinx.android.synthetic.main.fragment_poke_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokeListFragment(private val adapter: PokemonListAdapter) : Fragment(R.layout.fragment_poke_list){

    private val model: PokemonViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView.adapter = adapter

        model.loadingState.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if (it) {
                loadingPanel.visibility = View.VISIBLE
            } else {
                loadingPanel.visibility = View.GONE
            }
        })

        model.showContentState.observe(viewLifecycleOwner, androidx.lifecycle.Observer { data ->
            if (data.isNotEmpty()) {
                recyclerView.visibility = View.VISIBLE
            } else {
                recyclerView.visibility = View.GONE
            }
            setData(data)
        })

        model.errorState.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if (it) {
                errorView.visibility = View.VISIBLE
            } else {
                errorView.visibility = View.GONE
            }
        })

        model.setState()
    }

    private fun setData(data: List<PokeData>) {
        adapter.submitList(data)
    }
}